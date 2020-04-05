package com.malets.clean.dao;

import com.malets.clean.bean.Order;
import com.malets.clean.exception.DAoException;
import com.malets.clean.pool.CustomConnectionPool;
import com.malets.clean.util.ConstantManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAo extends AbstractDAO<Integer, Order> {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Order> findAll() throws DAoException {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ConstantManager.properties.getProperty("SQL_SELECT_ORDER"));
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_ORDER_ID")));
                order.setDate(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_DATE")));
                order.setDescription(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_DESCRIPTION")));
                orders.add(order);
            }
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding order list" + ex);
            throw new DAoException(ex);
        } finally {
            close(statement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return orders;
    }

    @Override
    public Order findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DAoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_DELETE_ORDER"));
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.log(Level.DEBUG, "Order is deleted");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while deleting order" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public boolean delete(Order entity) throws DAoException {
        return false;
    }

    @Override
    public boolean create(Order entity) throws DAoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_CREATE_ORDER"));
            preparedStatement.setInt(1, new CleanerDAo().findCleanerId(entity.getCleanerName()));
            preparedStatement.setInt(2, new ServiceDAo().findServiceId(entity.getDescription()));
            preparedStatement.setString(3, entity.getDate());
            preparedStatement.setInt(4, new ClientDAo().findClientId(entity.getClientLogin()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while creating new order", ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public Order update(Order entity) throws DAoException {
        return null;
    }

    public List<Order> findCleanerOrders(String login) throws DAoException {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_ORDER_CLEANER"));
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_ORDER_ID")));
                order.setDate(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_DATE")));
                order.setDescription(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_DESCRIPTION")));
                order.setCleanerName(login);
                orders.add(order);
            }
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding cleaner orders" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return orders;
    }

    public List<Order> findClientOrders(String login) throws DAoException {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_ORDER_CLIENT"));
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_ORDER_ID")));
                order.setDate(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_DATE")));
                order.setDescription(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_DESCRIPTION")));
                order.setCleanerName(login);
                orders.add(order);
            }
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding client orders" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return orders;
    }
}
