package com.malets.clean.bean;

import java.io.Serializable;

public class Order extends Entity implements Serializable, Cloneable {
    private int orderId;
    private String clientLogin;
    private String cleanerName;
    private String description;
    private String date;

    public Order() {
    }

    public Order(String cleanerName, String description, String date, String clientLogin) {
        this.cleanerName = cleanerName;
        this.description = description;
        this.date = date;
        this.clientLogin = clientLogin;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getCleanerName() {
        return cleanerName;
    }

    public void setCleanerName(String cleanerName) {
        this.cleanerName = cleanerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Order guest = (Order) obj;
        return orderId == guest.orderId &&
                (clientLogin == guest.clientLogin || (clientLogin != null && clientLogin.equals(guest.clientLogin)))&&
                (cleanerName == guest.cleanerName || (cleanerName != null && cleanerName.equals(guest.cleanerName)))&&
                (description == guest.description || (description != null && description.equals(guest.description)))&&
                (date == guest.date || (date != null && date.equals(guest.date)));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + orderId;
        result = prime * result + (clientLogin == null ? 0 : clientLogin.hashCode());
        result = prime * result + (cleanerName == null ? 0 : cleanerName.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (date == null ? 0 : date.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Order{").append("orderId=").append(orderId).append(", clientLogin=").
                append(clientLogin).append(", cleanerName=").append(cleanerName).append(", description=").append(description).
                append(", date='").append(date).append('}').toString();
    }
}
