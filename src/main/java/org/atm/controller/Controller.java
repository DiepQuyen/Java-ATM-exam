package org.atm.controller;

import org.atm.model.Customer;
import org.atm.model.CustomerService;

public class Controller {
    private CustomerService service;

    public Controller() {
        this.service = new CustomerService();
    }

    public void addCustomer(Customer customer) {
        boolean isSucess = service.addCustomer(customer);
        if (isSucess) {
            System.out.println("Thêm tài khoản thành công");
        } else {
            System.out.println("Thêm tài khoản thất bại");
        }
    }

    public void getBalance(String numberATM, String password) {
        String balance = service.getBalance(numberATM, password);
        if (balance != null) {
            System.out.println("Số dư của bạn là: " + balance);
        }
    }

    public void deposit(String numberATM, String password, double amount) {
        boolean isSucess = service.deposit(amount, numberATM, password);
        if (isSucess) {
            System.out.println("Nạp tiền thành công");
        } else {
            System.out.println("Nạp tiền thất bại");
        }
    }

    public void withdraw(String numberATM, String password, double amount) {
        boolean isSucess = service.withdraw(amount, numberATM, password);
        if (isSucess) {
            System.out.println("Rút tiền thành công");
        } else {
            System.out.println("Rút tiền thất bại");
        }
    }

    public void printAllCustomer() {
        service.printAllCustomer();
    }

    public void transfer(String numberATMSend, String numberATMReceive, String password, double amount) {
        boolean isSucess = service.transfer(numberATMSend, numberATMReceive, password, amount);
        if (isSucess) {
            System.out.println("Chuyển tiền thành công");
        } else {
            System.out.println("Chuyển tiền thất bại");
        }
    }
}
