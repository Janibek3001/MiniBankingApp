package ui;

import java.util.Scanner;

public class ConsoleMenu {
    static Scanner in = new Scanner(System.in);
    public void start() {
        int choice;

        while (true) {
            panelUI();
            choice = inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> {

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
        System.out.println("Phone number: ");
        int phoneNumber;
        while (true) {
            phoneNumber = inputInt("+998 ");
            if (String.valueOf(Math.abs(phoneNumber)).length() != 9) {
                System.out.println("The length of phone number must be 9!");
                System.out.println("Try again!");
            } else {
                break;
            }
        }

    }

}
