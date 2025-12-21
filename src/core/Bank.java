package core;

import model.User;
import model.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Account> accounts = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // We search the accounts by the User, when we login into acc, it will check, whether he has an acc or not
    // if he doent have any accs, we will suggest him to create one
    // after the login with User, we also suggest create and account and if he does not create an account, we warn them that
    // they cannot use without the account creation
    public Account findAccount(User user) {
        for (Account acc : accounts) {
            if (acc.getOwner().equals(user)) {
                return acc;
            }
        }
        return null;
    }

    // If we have the User in the registration form, it should go to the login page
    // And also if user not found in the login, it will say to create the user
    public User findUser(int phoneNumber) {
        for (User u : users) {
            if (u.phoneNumber() == phoneNumber) {
                return u;
            }
        }
        return null;
    }
}
