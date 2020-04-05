package com.malets.clean.command.impl;

import com.malets.clean.bean.Cleaner;
import com.malets.clean.bean.Order;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.CleanerService;
import com.malets.clean.model.OrderService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        List<Order> orders;
        try {
            if (req.getSession().getAttribute("role").equals("cleaner")) {
                orders = OrderService.getInstance().findCleanerOrders(req.getSession().getAttribute("user").toString());
            }
            else if (req.getSession().getAttribute("role").equals("client")){
                orders = OrderService.getInstance().findClientOrders(req.getSession().getAttribute("user").toString());
            }
            else {
                orders = OrderService.getInstance().findAll();
            }
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        if (orders.size() == 0){
            req.getSession().setAttribute("ordermessage", "You have no orders");
            return ConfigurationManager.getProperty("path.page.show.order");
        }
        req.getSession().setAttribute("ordermessage", "Order list");
        req.setAttribute("orders", orders);
        return ConfigurationManager.getProperty("path.page.show.order");
    }
}