package com.malets.clean.command.impl;

import com.malets.clean.bean.Client;
import com.malets.clean.bean.User;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.ClientService;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int phone = Integer.parseInt(req.getParameter("phone"));
        int roleId = 2;
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        Client client = new Client(login, password, name, surname, phone, roleId, rooms);
        try {
            ClientService.getInstance().createClient(client);
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        req.getSession().setAttribute("role", "client");
        return ConfigurationManager.getProperty("path.page.main");
    }
}
