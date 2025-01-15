package org.atm.view;

import org.atm.controller.Controller;
import org.atm.model.Customer;

import java.util.Scanner;

public class View {
    private Controller controller;
    private Scanner scanner;

    public View() {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== MENU ATM =====");
            System.out.println("1. Thêm tài khoản");
            System.out.println("2. Xem số dư");
            System.out.println("3. Nộp tiền vào tài khoản");
            System.out.println("4. Rút tiền");
            System.out.println("5. Chuyển tiền ");
            System.out.println("6. Xem tất cả tài khoản");
            System.out.println("7. Thoát");
            System.out.println("Chọn chức năng: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    getBalance();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    viewAll();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        }
    }

    //tạo tài khoản
    private void addCustomer() {
        //nhập tên
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        //nhập số tài khoản
        System.out.println("Nhập số tài khoản: ");
        String numberATM = scanner.nextLine();
        //nhập mật khẩu
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        //nhập số dư
        System.out.println("Nhập số dư: ");
        double balance;
        try {
            balance = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số dư không hợp lệ!");
            return;
        }
        //tạo đối tượng
        Customer customer = new Customer(name, numberATM, password, balance);
        //gọi hàm thêm tài khoản
        controller.addCustomer(customer);
    }

    //lấy số dư
    private void getBalance() {
        //nhập số tài khoản
        System.out.println("Nhập số tài khoản: ");
        String numberATM = scanner.nextLine();
        //nhập mật khẩu
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        //gọi hàm xem số dư
        controller.getBalance(numberATM, password);
    }

    //nạp tiền
    private void deposit() {
        //nhập số tài khoản
        System.out.println("Nhập số tài khoản: ");
        String numberATM = scanner.nextLine();
        //nhập mật khẩu
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        //nhập số tiền
        System.out.println("Nhập số tiền: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số tiền không hợp lệ!");
            return;
        }
        //gọi hàm nạp tiền
        controller.deposit(numberATM, password, amount);
    }

    //rút tiền
    private void withdraw() {
        //nhập số tài khoản
        System.out.println("Nhập số tài khoản: ");
        String numberATM = scanner.nextLine();
        //nhập mật khẩu
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        //nhập số tiền
        System.out.println("Nhập số tiền: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số tiền không hợp lệ!");
            return;
        }
        //gọi hàm rút tiền
        controller.withdraw(numberATM, password, amount);
    }

    //chuyển tiền
    private void transfer() {
        //nhập số tài khoản gửi
        System.out.println("Nhập số tài khoản gửi: ");
        String numberATMSend = scanner.nextLine();
        //nhập số tài khoản nhận
        System.out.println("Nhập số tài khoản nhận: ");
        String numberATMReceive = scanner.nextLine();
        //nhập mật khẩu
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        //nhập số tiền
        System.out.println("Nhập số tiền chuyển: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số tiền không hợp lệ!");
            return;
        }
        //gọi hàm chuyển tiền
        controller.transfer(numberATMSend, numberATMReceive, password, amount);
    }

    //in ra tất cả tài khoản
    private void viewAll() {
        controller.printAllCustomer();
    }
}
