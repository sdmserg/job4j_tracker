package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found: " + login);
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid()
            && user.getUsername().length() > 3) {
            return true;
        }
        throw new UserInvalidException("User is invalid.");
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println("User is invalid.");
        } catch (UserNotFoundException un) {
            System.out.println("User not found.");
        }
    }
}
