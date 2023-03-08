package comp3350.fitnesscompanion.logic;

import android.content.Context;

import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.Presistense.UserPersistenceSQLiteDB;
import comp3350.fitnesscompanion.Presistense.UserPersistenceSTUB;

public class AccessUser {

    private static UserPersistenceSQLiteDB sql1;
    private static UserPersistence sql2 = new UserPersistenceSTUB();

    public static UserPersistence getUserPersistenceSQLiteDB(Context context){
        sql1 = new UserPersistenceSQLiteDB(context);
        return sql1;
    }

    public static UserPersistence getUserPersistenceSTUB(){
        return sql2;
    }


}
