package comp3350.fitnesscompanion.Presistense.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.objects.User;



public class UserPersistenceHSQLDB implements UserPersistence {

    private final String databasePath;

    public UserPersistenceHSQLDB(final String dbPath) {
        this.databasePath = dbPath;
    }

    public Connection connection() throws SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath + ";shutdown=true", "SA", "");
    }

    @Override
    public boolean addUser(final User user) {
        if(user != null) {
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("INSERT INTO user VALUES(?, ?, ?, ?, ?, ?, ?)");
                st.setString(1, user.getEmail());
                st.setString(2, user.getPassword());
                st.setString(3, user.getFname());
                st.setString(4, user.getLname());
                st.setInt(5, user.getAge());
                st.setInt(6, user.getWeight());
                st.setInt(7, user.getHeight());

                st.executeUpdate();
                return true;
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        }
        return false;
    }

    @Override
    public User getUser(final String email) {
        if(!email.isEmpty() || email.length() == 0){
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE email=?");
                st.setString(1,email);

                final ResultSet rs = st.executeQuery();
                User temp = null;
                while (rs.next()){
                     temp = fromResult(rs);

                }
                return temp;
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        }
        return null;
    }

    @Override
    public boolean searchUser( final String email) {
        if(!email.isEmpty() || email.length() == 0){
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("SELECT * FROM user WHERE email=?");
                st.setString(1,email);

                final ResultSet rs = st.executeQuery();
                User temp = null;
                while(rs.next()){
                    temp = fromResult(rs);
                }
                rs.close();
                st.close();
                if (temp != null && temp.getEmail().equalsIgnoreCase(email)){
                 return true;
                }
            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(final String email) {
        if(!email.isEmpty() || email.length() == 0){
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("DELETE FROM user WHERE email=?");
                st.setString(1,email);
                st.executeUpdate();

                return true;

            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(User user, String email) {
        if(!email.isEmpty() || email.length() == 0){
            try (final Connection c = connection()) {
                final PreparedStatement st = c.prepareStatement("UPDATE user SET password = ?, fname = ?, lname = ?, age = ?, weight = ?, height = ?  WHERE email=?");
                st.setString(1, user.getPassword());
                st.setString(2, user.getFname());
                st.setString(3, user.getLname());
                st.setInt(4, user.getAge());
                st.setInt(5, user.getWeight());
                st.setInt(6, user.getHeight());
                st.setString(7,email);
                st.executeUpdate();

                return true;

            } catch (final SQLException e) {
                throw new PersistenceException(e);
            }
        }
        return false;
    }

    /**********************************************

     This sections contains all private methods used by the interface methods

    **********************************************/

    private User fromResult(final ResultSet rs) throws SQLException{
        final String email = rs.getString("email");
        final String password = rs.getString("password");
        final String fname = rs.getString("fname");
        final String lname = rs.getString("lname");
        final int age = rs.getInt("age");
        final int weight = rs.getInt("weight");
        final int height = rs.getInt("height");

        return new User(email,password,fname,lname,age,weight,height);

    }


}
