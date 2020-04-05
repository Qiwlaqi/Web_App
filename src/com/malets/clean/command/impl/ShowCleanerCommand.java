package com.malets.clean.command.impl;

import com.malets.clean.bean.Cleaner;
import com.malets.clean.bean.Service;
import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.CleanerService;
import com.malets.clean.model.ServiceService;
import com.malets.clean.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowCleanerCommand implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        List<Cleaner> cleaners;
        try {
            cleaners = CleanerService.getInstance().findCleaners();
        } catch (ServiceException ex) {
            return ConfigurationManager.getProperty("path.page.exception");
        }
        req.setAttribute("cleaners", cleaners);
        return ConfigurationManager.getProperty("path.page.show.cleaner");
    }
}
