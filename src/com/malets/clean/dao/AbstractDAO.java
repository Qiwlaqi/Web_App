package com.malets.clean.dao;

import com.malets.clean.bean.Entity;
import com.malets.clean.exception.DAoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<K, T extends Entity> {

    private static Logger logger = LogManager.getLogger();

    public abstract List<T> findAll() throws DAoException;

    public abstract T findEntityById(K id);

    public abstract boolean delete(K id) throws DAoException;

    public abstract boolean delete(T entity) throws DAoException;

    public abstract boolean create(T entity) throws DAoException;

    public abstract T update(T entity) throws DAoException;

    public void close(Statement statement) throws DAoException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while closing statement" + ex);
            throw new DAoException(ex);
        }
    }
}
