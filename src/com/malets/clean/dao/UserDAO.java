package com.malets.clean.dao;

import com.malets.clean.bean.Role;
import com.malets.clean.exception.DAoException;
import com.malets.clean.util.ConstantManager;
import com.malets.clean.pool.CustomConnectionPool;
import com.malets.clean.bean.User;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<Integer, User> {

    private static Logger logger = LogManager.getLogger();

    @Override
    public List<User> findAll() throws DAoException{
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ConstantManager.properties.getProperty("SQL_SELECT_ALL_USERS"));
            while (resultSet.next()) {
                User user = new User();
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getInt("phone"));
                user.setRoleId(resultSet.getInt("role_id"));
                users.add(user);
            }
            logger.log(Level.DEBUG, "List of users is presented");
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while getting list of users");
            throw new DAoException(ex);
        } finally {
            close(statement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return users;
    }

    @Override
    public User findEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(User entity) throws DAoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_DELETE_USER_BY_LOGIN"));
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.executeUpdate();
            logger.log(Level.DEBUG, "User is deleted");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while deleting user" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public boolean create(User entity) throws DAoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_CREATE_USER"));
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setInt(5, entity.getPhone());
            preparedStatement.setInt(6, entity.getRoleId());
            preparedStatement.executeUpdate();
            logger.log(Level.DEBUG, "New user is created");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while creating new user" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return true;
    }

    @Override
    public User update(User entity) throws DAoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_UPDATE_USER"));
            preparedStatement.setString(1, entity.getPassword());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setInt(4, entity.getPhone());
            preparedStatement.setString(5, entity.getLogin());
            preparedStatement.executeUpdate();
            logger.log(Level.DEBUG, "User" + entity.getLogin() + " is updated");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while updating user" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return entity;
    }

    public User findUser(String login) throws DAoException{
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_USER_BY_LOGIN"));
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()){
                logger.log(Level.WARN, "There is no user with such login");
                return null;
            }
                user.setLogin(login);
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getInt("phone"));
                user.setRoleId(resultSet.getInt("role_id"));
            resultSet.close();
            logger.log(Level.DEBUG, "User by login is found");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding user by login" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return user;
    }

    public User findUser(String login, String password) throws DAoException{
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_USER_BY_LOGIN_AND_PASS"));
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()){
                logger.log(Level.WARN, "There is no user with such login or password");
                return null;
            }
            user.setLogin(login);
            user.setPassword(password);
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setPhone(resultSet.getInt("phone"));
            user.setRoleId(resultSet.getInt("role_id"));
            resultSet.close();
            logger.log(Level.DEBUG, "User by login and password is found");
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding user by login and password" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return user;
    }

    public String findRole(String login) throws DAoException{
        String role;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_ROLE_BY_LOGIN"));
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int roleId = resultSet.getInt("role_id");
            System.out.println(roleId);
            role = findRole(roleId);
            resultSet.close();
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error while finding role" + ex);
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return role;
    }

    private String findRole(int roleId) throws DAoException{
        String role;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = CustomConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(ConstantManager.properties.getProperty("SQL_SELECT_ROLE"));
            preparedStatement.setInt(1, roleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            role = resultSet.getString(1);
            resultSet.close();
        } catch (SQLException ex) {
            throw new DAoException(ex);
        } finally {
            close(preparedStatement);
            CustomConnectionPool.INSTANCE.releaseConnection(connection);
        }
        return role;
    }
}
