package com.malets.clean.command.impl;

import com.malets.clean.bean.User;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        List<User> users;
        try {
            users = UserService.getInstance().findUsers();
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        req.setAttribute("users", users);
        return ConfigurationManager.getProperty("path.page.show");
    }
}
