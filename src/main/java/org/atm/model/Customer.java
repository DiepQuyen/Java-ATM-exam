package org.atm.model;

public class Customer {
    private String name;
    private String numberATM;
    private String password;
    private double balance;

    public Customer(String name, String numberATM, String password, double balance) {
        this.name = name;
        this.numberATM = numberATM;
        this.password = password;
        this.balance = balance;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberATM() {
        return numberATM;
    }

    public void setNumberATM(String numberATM) {
        this.numberATM = numberATM;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", numberATM='" + numberATM + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance;
    }
}
