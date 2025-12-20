package model;

public record User(String name, int phoneNumber, String password) { // User that just store the User information
    @Override
    public String toString() {
        return "User: " + name + "\n" + "Phone Number: " + phoneNumber + "\n";
    }
}
