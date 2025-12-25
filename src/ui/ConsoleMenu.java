package ui;

import core.Bank;
import model.User;
import core.BankService;
import validation.PasswordValidation;
import java.util.Scanner;

public class ConsoleMenu {
    private static final BankService service = new BankService();
    static PasswordValidation validate = new PasswordValidation();
    static Scanner in = new Scanner(System.in);
    public void start() {
        int choice;

        while (true) {
            panelUI();
            choice = inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> register();

                case 2 -> login();
                
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Try again!");
                }
            }
        }

    }
    public static void panelUI() {
        System.out.println("====Welcome to the Bank app====");
        System.out.println("\n1. Register" +
                "\n2. Login" +
                "\n0. Exit"
        );
    }
    public static int inputInt(String message) {
        System.out.print(message);
        int number;
        while (!in.hasNextInt()) {
            System.out.println("Input a number!");
            in.next();
        }

        number = in.nextInt();
        in.nextLine();
        return number;
    }

    public static void register() {
        System.out.println("Enter your name: ");
        String name = in.nextLine();
        int phoneNumber;

        while (true) {
            System.out.println("Phone number: ");
            phoneNumber = inputInt("+998 ");
            if (String.valueOf(Math.abs(phoneNumber)).length() != 9) {
                System.out.println("The length of phone number must be 9!");
                System.out.println("Try again!");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.println("Enter the password (a-z, 0-9):");
            password = in.nextLine();
            if (validate.hasDigit(password) && validate.checkLength(password) && validate.hasCharacter(password)) {
                break;
            } else {
                validate.errorShow(password);
            }
        }

        service.register(name, phoneNumber, password);
        System.out.println("User created!");
        System.out.println("Enter the balance to create an account!");
        System.out.print("Balance: ");
        double balance = in.nextDouble();
        in.nextLine();
        service.createAccount(new User(name, phoneNumber, password), balance);
    }

    public static void login() {
        int phoneNumber;
        String password;

        while (true) {
            System.out.println("Enter the phone number: ");
            phoneNumber = inputInt("+998 ");
            if (String.valueOf(Math.abs(phoneNumber)).length() != 9) {
                System.out.println("The length of phone number must be 9!");
                System.out.println("Try again!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Enter the password (a-z, 0-9):");
            password = in.nextLine();
            if (validate.hasDigit(password) && validate.checkLength(password) && validate.hasCharacter(password)) {
                break;
            } else {
                validate.errorShow(password);
            }
        }

        User user = service.login(phoneNumber, password);

        if (user == null) {
            return;
        } else {
            MainMenu.userMenu(user);
        }
    }
}


class MainMenu {
    private static final BankService service = new BankService();
    private static final Scanner in = new Scanner(System.in);

    public static void userMenu(User user) {
        while (true) {
            userUI(user);
            int choice = ConsoleMenu.inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> deposit(user);
                case 2 -> withDraw(user);
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Try again!");
                }
            }
        }
    }

    private static void userUI(User user) {
        System.out.printf("====Welcome %s====\n", user.name());
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("0. Exit");
    }
    public static void withDraw(User user) {
        System.out.print("Enter the amount: ");
        double amount = in.nextDouble();
        in.nextLine();
        service.withdraw(user, amount);
    }
    
    public static void deposit(User user) {
        System.out.print("Enter the amount: ");
        double amount = in.nextDouble();
        in.nextLine();
        service.deposit(user,amount);
    }
}
