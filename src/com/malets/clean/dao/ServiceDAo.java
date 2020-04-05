package com.malets.clean.dao;

import com.malets.clean.bean.Entity;
import com.malets.clean.bean.Service;
import com.malets.clean.exception.DAoException;
import com.malets.clean.pool.CustomConnectionPool;
import com.malets.clean.util.ConstantManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAo extends AbstractDAO<Integer, Service> {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Service> findAll() throws DAoException {
        List<Service> services = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ConstantManager.properties.getProperty("SQL_SELECT_ALL_SERVICE"));
            while (resultSet.next()) {
                Service service = new Service();
                service.setServiceId(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_SERVICE_ID")));
                service.setDescription(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_DESCRIPTION")));
                service.setPrice(resultSet.getBigDecimal(ConstantManager.properties.getProperty("DAO_COLUMN_PRICE")));
                services.add(service);
            }
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while getting list of services");
            throw new DAoException(ex);
        } finally {
            close(statement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return services;
    }

    @Override
    public Service findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Service entity) throws DAoException {
        return false;
    }

    @Override
    public boolean create(Service entity) throws DAoException {
        return false;
    }

    @Override
    public Service update(Service entity) throws DAoException {
        return null;
    }

    public int findServiceId(String description) throws DAoException {
        int serviceId;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_SERVICE_BY_DESCRIPTION"));
            preparedStatement.setString(1, description);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            serviceId = resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_SERVICE_ID"));
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding service id" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return serviceId;
    }

}
