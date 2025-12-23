package ui;

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

                case 2 ->
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


    }
}


class MainMenu {

}
