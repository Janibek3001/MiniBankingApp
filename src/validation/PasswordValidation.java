package validation;

import java.util.regex.Pattern;

public class PasswordValidation {
    public boolean hasDigit(String password) {
        int count = 0;
        for (int i = 0; i  < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count > 2;
    }

    public boolean hasCharacter(String password) {
        boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLowerCase = Pattern.compile("[a-z]").matcher(password).find();

        return hasUpperCase || hasLowerCase;
    }

    public boolean checkLength(String password) {
        return password.length() >= 8;
    }

    public void errorShow(String password) {
        if (!hasDigit(password)) {
            System.out.println("Password must contain at least two numbers");
        }
        if (!hasCharacter(password)) {
            System.out.println("Password must contain characters!");
        }
        if (!checkLength(password)) {
            System.out.println("Password length must be at least 8");
        }
    }
}
