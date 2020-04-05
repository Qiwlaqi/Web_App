package com.malets.clean.model;

import com.malets.clean.bean.Cleaner;
import com.malets.clean.bean.Client;
import com.malets.clean.bean.Service;
import com.malets.clean.dao.CleanerDAo;
import com.malets.clean.dao.ClientDAo;
import com.malets.clean.dao.ServiceDAo;
import com.malets.clean.exception.DAoException;
import com.malets.clean.exception.ServiceException;

import java.util.List;

public class CleanerService {

    private static CleanerService instance = new CleanerService();

    public static CleanerService getInstance() {
        return instance;
    }

    public void createCleaner(Cleaner cleaner) throws ServiceException {
        try {
            new CleanerDAo().create(cleaner);
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Cleaner> findCleaners() throws ServiceException {
        try {
            return new CleanerDAo().findAll();
        } catch (DAoException ex) {
            throw new ServiceException(ex);
        }
    }
}
