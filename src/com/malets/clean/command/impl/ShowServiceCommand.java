package com.malets.clean.command.impl;

import com.malets.clean.bean.Service;
import com.malets.clean.bean.User;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.ServiceService;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowServiceCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        List<Service> services;
        try {
            services = ServiceService.getInstance().findServices();
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        req.setAttribute("services", services);
        return ConfigurationManager.getProperty("path.page.show.service");
    }
}
