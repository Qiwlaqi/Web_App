package com.malets.clean.command.impl;

import com.malets.clean.command.Command;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.UserService;
import com.malets.clean.service.LoginService;
import com.malets.clean.util.ConfigurationManager;
import com.malets.clean.util.ConstantManager;
import com.malets.clean.util.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(ConstantManager.properties.getProperty("PARAM_NAME_LOGIN"));
        String pass = request.getParameter(ConstantManager.properties.getProperty("PARAM_NAME_PASSWORD"));
        if (LoginService.checkLogin(login, pass)) {
            String role;
            try {
                role = UserService.getInstance().findRole(login);
            } catch (ServiceException ex) {
                return ConfigurationManager.getProperty("path.page.exception");
            }
            if (request.getSession().getAttribute("role") == null){
                request.getSession().setAttribute("role", role);
            }
            request.getSession().setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror", request));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
