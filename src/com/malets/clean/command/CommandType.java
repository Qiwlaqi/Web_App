package com.malets.clean.command;

import com.malets.clean.command.Command;
import com.malets.clean.command.impl.*;

public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogOutCommand();
        }
    },
    CREATE_USER{
        {
            this.command = new CreateUserCommand();
        }
    },
    UPDATE_USER{
        {
            this.command = new UpdateUserCommand();
        }
    },
    DELETE_USER{
        {
            this.command = new DeleteUserCommand();
        }
    },
    SHOW_USER{
        {
            this.command = new ShowUserCommand();
        }
    },
    LANGUAGE{
        {
            this.command = new SetLanguageCommand();
        }
    };

    Command command;
    public Command getCommand(){
        return command;
    }
}
