package comp3350.fitnesscompanion.logic;

import android.content.Context;

import comp3350.fitnesscompanion.Presistense.StepDataPersistence;
import comp3350.fitnesscompanion.Presistense.hsqldb.StepDataPersistenceHSQLDB;
import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.Presistense.hsqldb.UserPersistenceHSQLDB;
import comp3350.fitnesscompanion.Presistense.UserPersistenceSQLiteDB;
import comp3350.fitnesscompanion.Presistense.UserPersistenceSTUB;

public class AccessServices {

    private static UserPersistenceSQLiteDB sql1 = null;
    private static UserPersistence sql2 = null;
    private static UserPersistence sql3 = null;
    private static StepDataPersistence sql4 = null;

    public static synchronized UserPersistence getUserPersistenceSQLiteDB(Context context){
        if (sql1 == null && context != null) {
            sql1 = new UserPersistenceSQLiteDB(context);
        }
        return sql1;
    }

    public static synchronized UserPersistence getUserPersistenceSTUB(){
        if(sql2 == null){
            sql2 = new UserPersistenceSTUB();
        }
        return sql2;
    }

    public static synchronized UserPersistence getUserPersistenceHSQLDB(){
        if (sql3 == null) {
            sql3 = new UserPersistenceHSQLDB(Main.getDBPathName());
        }
        return sql3;
    }

    public static synchronized StepDataPersistence getStepDataPersistenceHSQLDB(){
        if (sql4 == null) {
            sql4 = new StepDataPersistenceHSQLDB(Main.getDBPathName());
        }
        return sql4;
    }

}
