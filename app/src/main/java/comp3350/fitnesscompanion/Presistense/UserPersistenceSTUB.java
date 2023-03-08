package comp3350.fitnesscompanion.Presistense;

import java.util.ArrayList;
import java.util.List;

import comp3350.fitnesscompanion.objects.User;

public class UserPersistenceSTUB implements UserPersistence {

    private static List<User> list;

    public UserPersistenceSTUB() {
        list = new ArrayList<User>();
    }

    @Override
    public boolean addUser(User user) {
        if (user != null) {
            list.add(user);
            return true;
        }
        return false;
    }

    @Override
    public User getUser(final String email) {
        User user = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equalsIgnoreCase(email)) {
                user = list.get(i);
            }
        }
        return user;
    }

    @Override
    public boolean searchUser(final String email) { // email is primary key
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equalsIgnoreCase(email)) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public boolean deleteUser(final String email) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equalsIgnoreCase(email)) {
                index = i;
            }
        }
        if (index != -1) {
            list.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user, String email) {
        return false;
    }
}
