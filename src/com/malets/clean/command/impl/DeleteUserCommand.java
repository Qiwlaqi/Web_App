package com.malets.clean.command.impl;

import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getParameter("login");
        req.setAttribute("login", login);
        try {
            UserService.getInstance().delete(UserService.getInstance().findUser(login));
        } catch (ServiceException e) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        return ConfigurationManager.getProperty("path.page.delete");
    }
}
