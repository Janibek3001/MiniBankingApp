package model;

public record User(String name, int phoneNumber, String password) { // User that just store the User information
    public boolean checkPassword(String input) {
        return password.equals(input);
    }
}
