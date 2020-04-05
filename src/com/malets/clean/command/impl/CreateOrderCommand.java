package com.malets.clean.command.impl;

import com.malets.clean.bean.Order;
import com.malets.clean.bean.User;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.OrderService;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class CreateOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String service = req.getParameter("service");
        String cleaner = req.getParameter("cleaner");
        String date = req.getParameter("date");
        String client = req.getSession().getAttribute("user").toString();
        Order order = new Order(cleaner, service, date, client);
        try {
            OrderService.getInstance().createOrder(order);
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        return ConfigurationManager.getProperty("path.page.create.order");
    }
}
