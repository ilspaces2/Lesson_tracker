package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User findUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                findUser = user;
                break;
            }
        }
        if (findUser == null) {
            throw new UserNotFoundException("User not found");
        }
        return findUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("User invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            User[] users = {new User("Pet", true)};
            User user = findUser(users, "Pet");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
    }
}