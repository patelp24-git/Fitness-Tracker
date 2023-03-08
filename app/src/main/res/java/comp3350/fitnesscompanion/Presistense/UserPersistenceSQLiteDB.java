package comp3350.fitnesscompanion.Presistense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import comp3350.fitnesscompanion.objects.User;

public class UserPersistenceSQLiteDB extends SQLiteOpenHelper implements UserPersistence {


    private static final String dbName = "Delphi.db";
    private static final String tableName1 = "Users";

    public UserPersistenceSQLiteDB(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableName1 + " ( id int auto_increment, email text primary key, password text not null, fname text not null, lname text not null, age int not null, weight int not null, height int not null  );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName1 + ";");
        onCreate(db);
    }

    public boolean addUser(final User user) {
        SQLiteDatabase dbAdmin = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        values.put("fname", user.getFname());
        values.put("lname", user.getLname());
        values.put("age", user.getAge());
        values.put("weight", user.getWeight());
        values.put("height", user.getHeight());
        Log.d("DatabaseHelper", "Adding data" + user.getEmail() + " into table" + tableName1);
        long result = dbAdmin.insert(tableName1, null, values);
        if (result != -1) {
            return true;
        }
        return false;
    }

    public User getUser(final String email) {
        User result = null;
        SQLiteDatabase dbAdmin = this.getReadableDatabase();
        Cursor cursor = dbAdmin.rawQuery("select * from " + tableName1 + " where email = '" + email + "';", null);
        if (cursor.moveToFirst()) {
            result = new User(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7));
            cursor.close();
            dbAdmin.close();
        }
        return result;
    }

    public boolean searchUser(final String email) {
        SQLiteDatabase dbAdmin = this.getReadableDatabase();
        Cursor cursor = dbAdmin.rawQuery("select * from " + tableName1 + " where email = '" + email + "';", null);
        if (cursor.moveToFirst()) {
            return true;
        }
        return false;
    }

    public boolean deleteUser(final String email) {
        SQLiteDatabase dbAdmin = this.getWritableDatabase();
        Cursor cursor = dbAdmin.rawQuery("delete from " + tableName1 + " where email = '" + email + "';", null);
        if (cursor.moveToFirst()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user, String email) {
        return false;
    }


}
