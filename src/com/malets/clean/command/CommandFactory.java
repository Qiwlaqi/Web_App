package com.malets.clean.command;

import com.malets.clean.command.Command;
import com.malets.clean.command.CommandType;
import com.malets.clean.command.EmptyCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

    private static Logger logger = LogManager.getLogger();

    public Command defineCommand(HttpServletRequest req){
        Command current = new EmptyCommand();
        String action = req.getParameter("command");
        if (action == null || action.isEmpty()){
            return current;
        }
        try {
            CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
            current = currentEnum.getCommand();
            logger.log(Level.DEBUG, "Current command is: " + action);
        } catch (IllegalArgumentException ex){
            logger.log(Level.ERROR, "Unknown command", ex);
        }
        return current;
    }
}
