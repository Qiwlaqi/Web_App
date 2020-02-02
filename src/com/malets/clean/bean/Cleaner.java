package com.malets.clean.bean;

public class Cleaner extends User {
    private int cleanerId;
    private int salary;
    private int category;
    private int seniority;

    public Cleaner() {
    }

    public Cleaner(String login, String password, String name, String surname, int phone, int roleId, int cleanerId, int salary, int category, int seniority) {
        super(login, password, name, surname, phone, roleId);
        this.cleanerId = cleanerId;
        this.salary = salary;
        this.category = category;
        this.seniority = seniority;
    }

    public int getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Cleaner guest = (Cleaner) obj;
        return cleanerId == guest.cleanerId &&
                salary == guest.salary &&
                category == guest.category &&
                seniority == guest.seniority;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cleanerId;
        result = prime * result + salary;
        result = prime * result + category;
        result = prime * result + seniority;
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(" cleanerId=").append(cleanerId).append(", salary=").append(salary).
                append(", category=").append(category).append(", seniority=").append(seniority).append("}").toString();
    }
}
