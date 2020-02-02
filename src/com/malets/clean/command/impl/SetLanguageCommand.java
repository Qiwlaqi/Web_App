package com.malets.clean.command.impl;

import com.malets.clean.command.Command;
import com.malets.clean.util.ConfigurationManager;
import com.malets.clean.util.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class SetLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("languageerror");
        if (request.getParameter("lang") == null){
            request.getSession().setAttribute("languageerror", MessageManager.getProperty("message.languageerror", request));
        }
        else if (request.getParameter("lang").equals("en")){
            request.getSession().setAttribute("language", "en");
        }
        else {
            request.getSession().setAttribute("language", "de");
        }
        return request.getParameter("jsp");
    }
}
