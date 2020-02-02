package com.malets.clean.bean;

import java.io.Serializable;

public class User extends Entity implements Serializable, Cloneable {
    private String login;
    private String password;
    private String name;
    private String surname;
    private int phone;
    private int roleId;

    public User() {
    }

    public User(String login, String password, String name, String surname, int phone, int roleId) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.roleId = roleId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User guest = (User) obj;
        return (login == guest.login || login != null && login.equals(guest.login)) &&
                (password == guest.password || (password != null && password.equals(guest.password))) &&
                (name == guest.name || (name != null && name.equals(guest.name))) &&
                (surname == guest.surname || (surname != null && surname.equals(guest.surname))) &&
                phone == guest.phone &&
                roleId == guest.roleId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + phone;
        result = prime * result + roleId;
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User{").append("login='").append(login).append(", password='").
                append(password).append(", name='").append(name).append(", surname='").append(surname).
                append(", phone=").append(phone).append(", roleId=").append(roleId).toString();
    }
}
