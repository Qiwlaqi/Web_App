package com.malets.clean.command.impl;

import com.malets.clean.bean.User;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.util.ConfigurationManager;
import com.malets.clean.model.UserService;

import javax.servlet.http.HttpServletRequest;

public class CreateUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int phone = Integer.parseInt(req.getParameter("phone"));
        int roleId = Integer.parseInt(req.getParameter("role"));
        User user = new User(login, password, name, surname, phone, roleId);
        try {
            UserService.getInstance().createUser(user);
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        req.setAttribute("user", user);
        return ConfigurationManager.getProperty("path.page.create");
    }
}
