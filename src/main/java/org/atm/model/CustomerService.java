package org.atm.model;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private Map<String, Customer> customers = new HashMap<>();

    public CustomerService() {
    }

    //thêm tài khoản
    public boolean addCustomer(Customer customer) {
        //kiểm tra tài khoản tồn tại không
        if (customers.containsKey(customer.getNumberATM())) {
            System.out.println("Số tài khoản đã tồn tại");
            return false;
        }
        customers.put(customer.getNumberATM(), customer);
        return true;
    }

    //kiểm tra số dư
    public String getBalance(String numberATM, String password) {
        //kiểm tra số tài khoản tồn tại không
        if (!customers.containsKey(numberATM)) {
            System.out.println("Số tài khoản không tồn tại");
            return null;
        }
        //kiểm tra mật khẩu nhập vào trùng mật khẩu số tài khoản không
        if (!customers.get(numberATM).getPassword().equals(password)) {
            System.out.println("Sai mật khẩu");
            return null;
        }
        double balance = customers.get(numberATM).getBalance();
        return String.format("%.2f", balance);
    }

    public boolean deposit(double amount, String numberATM, String password) {
        //kiểm tra số tài khoản tồn tại hay không
        if (!customers.containsKey(numberATM)) {
            System.out.println("Số tài khoản không tồn tại");
            return false;
        }
        //kiểm tra mật khẩu đúng không
        if (!customers.get(numberATM).getPassword().equals(password)) {
            System.out.println("Sai mật khẩu");
            return false;
        }
        //lấy số dư
        double balance = customers.get(numberATM).getBalance();
        //cộng tiền
        balance += amount;
        //cập nhật số dư
        customers.get(numberATM).setBalance(balance);
        return true;
    }

    public boolean withdraw(double amount, String numberATM, String password) {
        //kiểm tra số tài khoản tồn tại hay không
        if (!customers.containsKey(numberATM)) {
            System.out.println("Số tài khoản không tồn tại");
            return false;
        }
        //kiểm tra mật khẩu đúng không
        if (!customers.get(numberATM).getPassword().equals(password)) {
            System.out.println("Sai mật khẩu");
            return false;
        }
        //lấy số dư
        double balance = customers.get(numberATM).getBalance();
        //nếu số dư > 0 và số tiền rút <= số dư
        if (balance > 0 && amount <= balance) {
            //trừ tiền
            balance -= amount;
            //cập nhật số dư
            customers.get(numberATM).setBalance(balance);
            return true;
        } else {
            System.out.println("Số dư không đủ để rút");
        }
        return false;
    }

    public boolean transfer(String numberATMSend, String numberATMReceive, String password, double amount) {
        //kiểm tra số tài khoản gửi tồn tại hay không
        if (!customers.containsKey(numberATMSend)) {
            System.out.println("Số tài khoản gửi không tồn tại");
            return false;
        }
        //kiểm tra số tài khoản nhận tồn tại hay không
        if (!customers.containsKey(numberATMReceive)) {
            System.out.println("Số tài khoản nhận không tồn tại");
            return false;
        }
        //kiểm tra mật khẩu đúng không
        if (!customers.get(numberATMSend).getPassword().equals(password)) {
            System.out.println("Sai mật khẩu");
            return false;
        }
        //lấy số dư tài khoản gửi
        double balanceSend = customers.get(numberATMSend).getBalance();
        //nếu số dư > 0 và số tiền chuyển <= số dư
        if (balanceSend > 0 && amount <= balanceSend) {
            //trừ tiền tài khoản gửi
            balanceSend -= amount;
            //cập nhật số dư tài khoản gửi
            customers.get(numberATMSend).setBalance(balanceSend);
            //lấy số dư tài khoản nhận
            double balanceReceive = customers.get(numberATMReceive).getBalance();
            //cộng tiền tài khoản nhận
            balanceReceive += amount;
            //cập nhật số dư tài khoản nhận
            customers.get(numberATMReceive).setBalance(balanceReceive);
            return true;
        } else {
            System.out.println("Số dư không đủ để chuyển");
        }
        return false;
    }

    public void printAllCustomer() {
        //kiểm tra xem có tài khoản chưa, nếu chưa có thì in ra
        if (customers.isEmpty()) {
            System.out.println("Không có tài khoản nào");
            return;
        }
        //nếu có tài khoàn thì in ra
        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
