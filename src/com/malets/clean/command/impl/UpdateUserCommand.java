package com.malets.clean.command.impl;

import com.malets.clean.bean.User;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class UpdateUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        User user;
        try {
            user = UserService.getInstance().findUser(login);
        } catch (ServiceException e) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int phone = Integer.parseInt(req.getParameter("phone"));
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        try {
            UserService.getInstance().update(user);
        } catch (ServiceException e) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        req.setAttribute("user", user);
        return ConfigurationManager.getProperty("path.page.update");
    }
}
