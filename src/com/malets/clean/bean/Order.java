package com.malets.clean.bean;

import java.io.Serializable;

public class Order extends Entity implements Serializable, Cloneable {
    private int orderId;
    private int clientId;
    private int cleanerId;
    private int serviceId;
    private String date;

    public Order() {
    }

    public Order(int orderId, int clientId, int cleanerId, int serviceId, String date) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.cleanerId = cleanerId;
        this.serviceId = serviceId;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
                clientId == guest.clientId &&
                cleanerId == guest.cleanerId &&
                serviceId == guest.serviceId &&
                (date == guest.date || (date != null && date.equals(guest.date)));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + orderId;
        result = prime * result + clientId;
        result = prime * result + cleanerId;
        result = prime * result + serviceId;
        result = prime * result + (date == null ? 0 : date.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Order{").append("orderId=").append(orderId).append(", clientId=").
                append(clientId).append(", cleanerId=").append(cleanerId).append(", serviceId=").append(serviceId).
                append(", date='").append(date).append('}').toString();
    }
}
