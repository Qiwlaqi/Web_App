package com.malets.clean.dao;

import com.malets.clean.bean.Cleaner;
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

public class CleanerDAo extends AbstractDAO<Integer, Cleaner> {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<Cleaner> findAll() throws DAoException {
        List<Cleaner> cleaners = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ConstantManager.properties.getProperty("SQL_SELECT_CLEANER"));
            while (resultSet.next()) {
                Cleaner cleaner = new Cleaner();
                cleaner.setName(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_NAME")));
                cleaner.setSurname(resultSet.getString(ConstantManager.properties.getProperty("DAO_COLUMN_SURNAME")));
                cleaner.setCategory(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_CATEGORY")));
                cleaner.setSeniority(resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_SENIORITY")));
                cleaners.add(cleaner);
            }
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while getting list of cleaners");
            throw new DAoException(ex);
        } finally {
            close(statement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return cleaners;
    }

    @Override
    public Cleaner findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Cleaner entity) throws DAoException {
        return false;
    }

    @Override
    public boolean create(Cleaner entity) throws DAoException {
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
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_CREATE_CLEANER"));
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setInt(2, entity.getCategory());
            preparedStatement.setInt(3, entity.getSeniority());
            preparedStatement.executeUpdate();
            logger.log(Level.DEBUG, "New cleaner is created");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while creating new cleaner" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public Cleaner update(Cleaner entity) throws DAoException {
        return null;
    }

    public int findCleanerId(String login) throws DAoException {
        int cleanerId;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_CLEANER_BY_LOGIN"));
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            cleanerId = resultSet.getInt(ConstantManager.properties.getProperty("DAO_COLUMN_CLEANER_ID"));
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding cleaner id" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return cleanerId;
    }
}
