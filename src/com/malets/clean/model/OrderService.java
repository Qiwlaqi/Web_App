package com.malets.clean.model;

import com.malets.clean.bean.Order;
import com.malets.clean.bean.Service;
import com.malets.clean.bean.User;
import com.malets.clean.dao.OrderDAo;
import com.malets.clean.dao.ServiceDAo;
import com.malets.clean.dao.UserDAO;
import com.malets.clean.exception.DAoException;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.pool.CustomConnectionPool;
import com.malets.clean.util.ConstantManager;
import org.apache.logging.log4j.Level;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static OrderService instance = new OrderService();

    public static OrderService getInstance() {
        return instance;
    }

    public void delete(Integer id) throws ServiceException {
        try {
            new OrderDAo().delete(id);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public void createOrder(Order order) throws ServiceException {
        try {
            new OrderDAo().create(order);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Order> findCleanerOrders(String login) throws ServiceException {
        try {
            return new OrderDAo().findCleanerOrders(login);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Order> findClientOrders(String login) throws ServiceException {
        try {
            return new OrderDAo().findClientOrders(login);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Order> findAll() throws ServiceException {
        try {
            return new OrderDAo().findAll();
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

}
