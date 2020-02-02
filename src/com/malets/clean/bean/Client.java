package com.malets.clean.bean;

import java.io.Serializable;

public class Client extends User implements Serializable, Cloneable {
    private int clientId;
    private int discount;
    private int rooms;

    public Client() {
        super();
    }

    public Client(String login, String password, String name, String surname, int phone, int roleId, int clientId, int discount, int rooms) {
        super(login, password, name, surname, phone, roleId);
        this.clientId = clientId;
        this.discount = discount;
        this.rooms = rooms;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Client guest = (Client) obj;
        return clientId == guest.clientId &&
                discount == guest.discount &&
                rooms == guest.rooms;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + clientId;
        result = prime * result + discount;
        result = prime * result + rooms;
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(" clientId=").append(clientId).append(", discount=").append(discount).
                append(", rooms=").append(rooms).append("}").toString();
    }
}
