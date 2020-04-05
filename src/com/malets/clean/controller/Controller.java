package com.malets.clean.controller;

import com.malets.clean.command.Command;
import com.malets.clean.pool.CustomConnectionPool;
import com.malets.clean.command.CommandFactory;
import com.malets.clean.util.ConfigurationManager;
import com.malets.clean.util.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp){
        String page;
        CommandFactory client = new CommandFactory();
        Command command = client.defineCommand(req);
        page = command.execute(req);
        try { if (page != null){
                logger.log(Level.DEBUG, "Client is redirected to page: " + page);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
                requestDispatcher.forward(req, resp);
            } else {
                page = ConfigurationManager.getProperty("path.page.index");
                req.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage", req));
                resp.sendRedirect(req.getContextPath() + page);
            }
        } catch (ServletException | IOException ex){
            logger.log(Level.ERROR, "Error while creating new client" + ex); // FIXME: 24.02.2020 
        }
    }

    @Override
    public void destroy() {
        CustomConnectionPool.INSTANCE.destroyPool();
    }


}
