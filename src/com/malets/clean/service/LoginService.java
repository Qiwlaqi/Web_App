package com.malets.clean.service;

import com.malets.clean.bean.User;
import com.malets.clean.exception.ServiceException;
import com.malets.clean.model.UserService;

public class LoginService {
    public static boolean checkLogin(String login, String password) {
        User user = null;
        try {
            user = UserService.getInstance().findUser(login, password);
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }
        return (user != null);
    }
}
