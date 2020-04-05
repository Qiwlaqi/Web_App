package com.malets.clean.model;

import com.malets.clean.bean.Service;
import com.malets.clean.bean.User;
import com.malets.clean.dao.ServiceDAo;
import com.malets.clean.dao.UserDAO;
import com.malets.clean.exception.DAoException;
import com.malets.clean.exception.ServiceException;

import java.util.List;

public class ServiceService {

    private static ServiceService instance = new ServiceService();

    public static ServiceService getInstance() {
        return instance;
    }

    public List<Service> findServices() throws ServiceException {
        try {
            return new ServiceDAo().findAll();
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }
}
