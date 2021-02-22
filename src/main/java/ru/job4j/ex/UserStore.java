package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                return users[i];
            }
        }
            throw new UserNotFoundException("user is not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("user invalid");
        }
            return true;
        }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Mark Blinkov", true)
            };
            User user = findUser(users, "Mark Blinkov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException iv) {
            iv.printStackTrace();
        } catch (UserNotFoundException nf) {
            nf.printStackTrace();
        }
    }
}