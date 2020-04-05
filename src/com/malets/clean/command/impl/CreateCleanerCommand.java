package com.malets.clean.command.impl;

import com.malets.clean.bean.Cleaner;
import com.malets.clean.bean.Client;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.CleanerService;
import com.malets.clean.model.ClientService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class CreateCleanerCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int phone = Integer.parseInt(req.getParameter("phone"));
        int roleId = 3;
        int category = Integer.parseInt(req.getParameter("category"));
        int seniority = Integer.parseInt(req.getParameter("seniority"));
        Cleaner cleaner = new Cleaner(login, password, name, surname, phone, roleId, category, seniority);
        try {
            CleanerService.getInstance().createCleaner(cleaner);
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        return ConfigurationManager.getProperty("path.page.create.cleaner");
    }
}
