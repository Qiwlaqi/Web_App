package com.malets.clean.pool;

import com.malets.clean.util.ConstantManager;
import com.malets.clean.exception.DAoException;
import com.malets.clean.util.PoolManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public enum CustomConnectionPool {
    INSTANCE;

    private Logger logger = LogManager.getLogger();

    private BlockingQueue<Connection> freeConnections;
    private Queue<Connection> givenAwayConnections;

    CustomConnectionPool() {
        freeConnections = new LinkedBlockingDeque<>(Integer.parseInt(ConstantManager.properties.getProperty("CONNECTION_POOL_SIZE")));
        givenAwayConnections = new ArrayDeque<>();

        Properties properties = PoolManager.getProperties();

        try {
            Class.forName(ConstantManager.properties.getProperty("DRIVER_URL")).getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(ConstantManager.properties.getProperty("DATABASE_URL"), properties);
            for (int i = 0; i < Integer.parseInt(ConstantManager.properties.getProperty("CONNECTION_POOL_SIZE")); i++) {
                freeConnections.offer(connection);
            }
            logger.log(Level.INFO, "Connection pool is created");
        } catch (Exception ex) {
            logger.log(Level.ERROR, "Error while connecting to database" + ex);
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = new ProxyConnection(freeConnections.take());
            givenAwayConnections.offer(connection);
            logger.log(Level.DEBUG, "Connection is given to user");
        } catch (InterruptedException ex) {
            logger.log(Level.ERROR, "Error while getting connection" + ex);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (!(connection instanceof ProxyConnection)) {

                //throw new DAoException("Unregistered connection"); // FIXME: 25.01.2020

        }
        givenAwayConnections.remove(connection);
        freeConnections.offer(connection);
        logger.log(Level.DEBUG, "Connection is released to the pool");
    }

    public void destroyPool() {
        for (int i = 0; i < Integer.parseInt(ConstantManager.properties.getProperty("CONNECTION_POOL_SIZE")); i++) {
            try {
                new ProxyConnection(freeConnections.take()).reallyClose();
            } catch (InterruptedException ex) {
                logger.log(Level.ERROR, "Error while destroying connection pool" + ex);
            }
        }
        logger.log(Level.INFO, "Connection pool is destroyed");
    }
}
