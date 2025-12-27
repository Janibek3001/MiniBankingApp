package ui;

import core.Bank;
import exception.NotEnoughFoundException;
import model.Transaction;
import model.User;
import core.BankService;
import validation.PasswordValidation;
import java.util.Scanner;

public class ConsoleMenu {
    private static final BankService service = new BankService();
    static PasswordValidation validate = new PasswordValidation();
    static Scanner in = new Scanner(System.in);
    public void start() throws NotEnoughFoundException {
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
        System.out.println();
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

    public static double inputDouble(String message) {
        System.out.print(message);
        double number;
        while (!in.hasNextDouble()) {
            System.out.println("Input a number!");
            in.next();
        }

        number = in.nextDouble();
        in.nextLine();
        return number;
    }

    public static void register() {
        System.out.println();
        System.out.println("Enter your name: ");
        String name = in.nextLine();
        int phoneNumber;

        while (true) {
            System.out.println("Phone number: ");
            phoneNumber = inputInt("+998 ");

            if (service.hasNumber(phoneNumber)) {
                System.out.println("User with this account already exist");
                System.out.println();
                continue;
            }

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

        User newUser = service.register(name, phoneNumber, password);
        System.out.println("User created!");
        System.out.println("Enter the balance to create an account!");
        double balance = inputDouble("Balance: ");
        in.nextLine();
        service.createAccount(newUser, balance);
        System.out.println("Account created!");
        System.out.println();
    }

    public static void login() throws NotEnoughFoundException {
        int phoneNumber;
        String password;
        System.out.println();

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
            System.out.println("Number or password is incorrect!");
            System.out.println();
            return;
        } else {
            MainMenu.userMenu(user, service, in);
        }
    }
}


class MainMenu {
    public static void userMenu(User user, BankService service, Scanner in) throws NotEnoughFoundException {
        System.out.println();
        while (true) {
            userUI(user);
            int choice = ConsoleMenu.inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> {
                    service.showBalance(user);
                    System.out.println();
                }
                case 2 -> deposit(user, service, in);
                case 3 -> withDraw(user, service, in);
                case 4 -> transactionHistory(user, service);
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
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. History");
        System.out.println("0. Exit");
    }

    public static void transactionHistory(User user, BankService service) {
        for (Transaction t : service.getAccount(user).getTransactions()) {
            System.out.println(t);
        }
    }

    public static void withDraw(User user, BankService service, Scanner in) throws NotEnoughFoundException {
        System.out.println();
        double amount = ConsoleMenu.inputDouble("Enter the amount: ");
        in.nextLine();
        try {
            service.withdraw(user, amount);
            System.out.println("Withdraw successfully");
            System.out.println();
        } catch (NotEnoughFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }
    }
    
    public static void deposit(User user, BankService service, Scanner in) {
        System.out.println();
        double amount = ConsoleMenu.inputDouble("Enter the amount: ");
        in.nextLine();
        service.deposit(user,amount);
        System.out.println("Deposit successfully");
        System.out.println();
    }
}
