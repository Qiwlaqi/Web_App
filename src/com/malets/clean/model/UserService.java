package com.malets.clean.model;

import com.malets.clean.bean.User;
import com.malets.clean.dao.UserDAO;
import com.malets.clean.exception.DAoException;
import com.malets.clean.exception.ServiceException;

import java.util.List;

public class UserService {
    private static UserService instance = new UserService();

    public static UserService getInstance() {
        return instance;
    }

    public void createUser(User user) throws ServiceException {
        try {
            new UserDAO().create(user);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public User findUser(String login) throws ServiceException {
        User user;
        try {
            user = new UserDAO().findUser(login);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
        return user;
    }

    public User findUser(String login, String password) throws ServiceException {
        User user;
        try {
            user = new UserDAO().findUser(login, password);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
        return user;
    }

    public void delete(User user) throws ServiceException {
        try {
            new UserDAO().delete(user);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<User> findUsers() throws ServiceException {
        try {
            return new UserDAO().findAll();
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public void update(User user) throws ServiceException {
        try {
            new UserDAO().update(user);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public String findRole(String login) throws ServiceException{
        try {
            return new UserDAO().findRole(login);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }
}
