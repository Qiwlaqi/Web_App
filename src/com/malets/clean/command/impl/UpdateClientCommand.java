package com.malets.clean.command.impl;

import com.malets.clean.bean.Client;
import com.malets.clean.bean.User;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.ClientService;
import com.malets.clean.model.UserService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class UpdateClientCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        String login = req.getSession().getAttribute("user").toString();
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int phone = Integer.parseInt(req.getParameter("phone"));
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setLogin(login);
        client.setPhone(phone);
        client.setPassword(password);
        client.setRooms(rooms);
        try {
            ClientService.getInstance().updateClient(client);
        } catch (ServiceException e) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        return ConfigurationManager.getProperty("path.page.update.client");
    }
}
