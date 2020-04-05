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
    },
    SHOW_SERVICE{
        {
            this.command = new ShowServiceCommand();
        }
    },
    SHOW_CLEANER{
        {
            this.command = new ShowCleanerCommand();
        }
    },
    SHOW_ORDER{
        {
            this.command = new ShowOrderCommand();
        }
    },
    CREATE_ORDER{
        {
            this.command = new CreateOrderCommand();
        }
    },
    UPDATE_CLIENT{
        {
            this.command = new UpdateClientCommand();
        }
    },
    DELETE_ORDER{
        {
            this.command = new DeleteOrderCommand();
        }
    },
    REGISTER{
        {
            this.command = new RegisterCommand();
        }
    },
    SHOW_CLIENT{
        {
            this.command = new ShowClientCommand();
        }
    },
    CREATE_CLEANER{
        {
            this.command = new CreateCleanerCommand();
        }
    };

    Command command;
    public Command getCommand(){
        return command;
    }
}
