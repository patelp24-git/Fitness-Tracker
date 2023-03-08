package comp3350.fitnesscompanion.Presistense.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.fitnesscompanion.Presistense.StepDataPersistence;
import comp3350.fitnesscompanion.objects.StepData;

public class StepDataPersistenceHSQLDB implements StepDataPersistence {

    public final String databasePath;

    public StepDataPersistenceHSQLDB(String databasePath){
        this.databasePath = databasePath;
    }

    private Connection connection() throws SQLException{
        return DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath + ";shutdown=true","SA","");
    }

    @Override
    public boolean addSteps(StepData data) {
        if(data != null){
            try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("INSERT INTO stepdata VALUES(?,?,?)");
            st.setString(1,data.getEmail());
            st.setString(2,data.getDate());
            st.setInt(3,data.getSteps());


            st.executeUpdate();

            }catch(SQLException e){
                throw new PersistenceException(e);
            }
        }
        return false;
    }

    @Override
    public List<StepData> getSteps(String email) {
        try(final Connection c = connection()){
            final PreparedStatement st = c.prepareStatement("SELECT * FROM stepdata WHERE email=?");
            st.setString(1, email);

            final ResultSet rs = st.executeQuery();
            List<StepData> temp = new ArrayList<>();
            while(rs.next()){
                temp.add(fromResult(rs));
            }

            rs.close();
            st.close();

            if(!temp.isEmpty() && temp.size() != 0){
                return temp;
            }

        }catch(SQLException e){
            throw new PersistenceException(e);
        }
        return null;
    }

    private StepData fromResult(final ResultSet rs) throws SQLException{
        final String email = rs.getString("email");
        final String date = rs.getString("actualdate");
        final int steps = rs.getInt("steps");

        return new StepData(email,date,steps);
    }

}
