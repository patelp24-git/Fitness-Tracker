package comp3350.fitnesscompanion.logic;

public class Main {
    private static String databasePathName = "UD";

    public static void main(String [] args){
        System.out.println("Testing my database connection!");
    }

    public static String getDBPathName() {
        return databasePathName;
    }

    public static void setDBPathName(String databaseName) {
            try {
                Class.forName("org.hsqldb.jdbcDriver").newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        System.out.println("Database Connection Successful!");
        Main.databasePathName = databaseName;
    }





}
