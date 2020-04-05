package com.malets.clean.model;

import com.malets.clean.bean.Client;
import com.malets.clean.bean.User;
import com.malets.clean.dao.ClientDAo;
import com.malets.clean.dao.UserDAO;
import com.malets.clean.exception.DAoException;
import com.malets.clean.exception.ServiceException;

import java.util.List;

public class ClientService {
    private static ClientService instance = new ClientService();

    public static ClientService getInstance() {
        return instance;
    }

    public void createClient(Client client) throws ServiceException {
        try {
            new ClientDAo().create(client);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public void updateClient(Client client) throws ServiceException {
        try {
            new ClientDAo().update(client);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Client> findClients() throws ServiceException {
        try {
            return new ClientDAo().findAll();
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }
}
