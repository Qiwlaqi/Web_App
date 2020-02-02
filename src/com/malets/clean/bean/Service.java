package com.malets.clean.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Service extends Entity implements Serializable, Cloneable {
    private int serviceId;
    private BigDecimal price;
    private ServiceType description;

    public Service() {
    }

    public Service(int serviceId, BigDecimal price, ServiceType description) {
        this.serviceId = serviceId;
        this.price = price;
        this.description = description;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ServiceType getDescription() {
        return description;
    }

    public void setDescription(ServiceType description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Service guest = (Service) obj;
        return serviceId == guest.serviceId && price == guest.price && description == guest.description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + serviceId;
        result = prime * result + price.hashCode();
        result = prime * result + description.hashCode();
        return result;
    }



    @Override
    public String toString() {
        return new StringBuilder().append("Service{").append("serviceId=").append(serviceId).append(", price=").
                append(price).append(", description=").append(description).append("}").toString();
    }
}
