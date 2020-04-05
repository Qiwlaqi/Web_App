package com.malets.clean.dao;

import com.malets.clean.bean.Client;
import com.malets.clean.exception.DAoException;
import com.malets.clean.pool.CustomConnectionPool;
import com.malets.clean.util.ConstantManager;
import com.malets.clean.util.PasswordManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAo extends AbstractDAO<Integer, Client> {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Client> findAll() throws DAoException {
        List<Client> clients = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ConstantManager.properties.getProperty("SQL_SELECT_CLIENT"));
            while (resultSet.next()) {
                Client client = new Client();
                client.setName(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_NAME")));
                client.setSurname(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_SURNAME")));
                client.setLogin(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_LOGIN")));
                client.setPhone(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_PHONE")));
                client.setRooms(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_ROOMS")));
                clients.add(client);
            }
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while getting list of clients");
            throw new DAoException(ex);
        } finally {
            close(statement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return clients;
    }

    @Override
    public Client findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Client entity) throws DAoException {
        return false;
    }

    @Override
    public boolean create(Client entity) throws DAoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_CREATE_USER"));
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, PasswordManager.INSTANCE.encrypt(entity.getPassword()));
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setInt(5, entity.getPhone());
            preparedStatement.setInt(6, entity.getRoleId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_CREATE_CLIENT"));
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setInt(2, entity.getRooms());
            preparedStatement.executeUpdate();
            logger.log(Level.DEBUG, "New client is created");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while creating new client" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public Client update(Client entity) throws DAoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_UPDATE_CLIENT"));
            preparedStatement.setString(1, PasswordManager.INSTANCE.encrypt(entity.getPassword()));
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setInt(4, entity.getPhone());
            preparedStatement.setInt(5, entity.getRooms());
            preparedStatement.setString(6, entity.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while updating client" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return entity;
    }

    public int findClientId(String login) throws DAoException {
        int clientId;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_CLIENT_BY_LOGIN"));
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            clientId = resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_CLIENT_ID"));
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding client id" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return clientId;
    }
}
