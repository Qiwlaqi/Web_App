package com.malets.clean.command.impl;

import com.malets.clean.bean.Cleaner;
import com.malets.clean.bean.Client;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.CleanerService;
import com.malets.clean.model.ClientService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowClientCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        List<Client> clients;
        try {
            clients = ClientService.getInstance().findClients();
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        req.setAttribute("clients", clients);
        return ConfigurationManager.getProperty("path.page.show.client");
    }
}