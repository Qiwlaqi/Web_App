package com.malets.clean.command.impl;

import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.OrderService;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class DeleteOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        try {
            OrderService.getInstance().delete(orderId);
        } catch (ServiceException e) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        return ConfigurationManager.getProperty("path.page.delete.order");
    }
}
