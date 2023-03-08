package comp3350.fitnesscompanion.Presistense;

import comp3350.fitnesscompanion.objects.User;

public interface UserPersistence {

    public boolean addUser(final User user);

    public User getUser(final String email);

    public boolean searchUser(final String email);

    public boolean deleteUser(final String email);

   public boolean updateUser(final User user,final String email);

}
