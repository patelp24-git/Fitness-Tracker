package comp3350.fitnesscompanion;

import org.junit.Test;
import comp3350.fitnesscompanion.Presistense.FakeDatabase;
import comp3350.fitnesscompanion.objects.Data;

public class TestFakeDatabase {
	public static FakeDatabase fakeDatabase =  FakeDatabase.getInstance();
	
	@Test
	public void testCreateTable() {
		System.out.println("\n\n-----------Testing create table, retruns empty string on success-------------");
		//if created a database, result's length would be zero.
		String result =  fakeDatabase.createTable("Table112");
		System.out.println("TestCreateTable 1 : " + result);
		assert result.equals("") : result;
		String result2 = fakeDatabase.createTable("Table2");
		assert result2.equals("") : result2;
		System.out.println("TestCreateTable 2 : " + result2);
		String result3 = fakeDatabase.createTable("Table112");
		// if not created length would not be zero.
		assert !result3.equals("")  : result3;
		System.out.println("TestCreateTable 3 : " + result3);

	}//end test create table
	
	@Test
	public void testReadFromTable() {
		System.out.println("\n\n-----------Testing add element to table, retruns empty string on success-------------");

		String temp = fakeDatabase.createTable("Table70");
		String temp2 = fakeDatabase.addElementToTable("Table70" , new Data("some name" , "2000", "some value"));

		Object list = fakeDatabase.readFromTable("Table70");
		System.out.println("TestReadFromTable 1, reading from an existing table: " + list);
		assert list != null : "The list is null";

		Object list2 = fakeDatabase.readFromTable("Table880");
		System.out.println("TestReadFromTable 2, reading from an non-existing table: " + list2.toString());
		assert list2 != null : list2;
	}//end read from table

	@Test
	public void testReadFromKey() {
		System.out.println("\n\n-----------Testing delete table from DB, retruns empty string on success-------------");

		String temp = fakeDatabase.createTable("Table60");
		String temp2 = fakeDatabase.addElementToTable("Table60" , new Data("some name" , "2000", "some value"));

		Object object = fakeDatabase.readFromKey("name" , "Table60");
		System.out.println("TestReadFromKey 1, checking for existing table and existing row: " + object.toString() );
		assert object.equals("some name") : object.toString();

		Object object2 = fakeDatabase.readFromKey("name" , "Table68");
		System.out.println("TestReadFromKey 2, checking for non-existing table and an existing row: " + object2.toString() );
		assert object2.equals("The table Table68 does not exist. Please check the name and try again") : object2.toString();

		Object object3 = fakeDatabase.readFromKey("yay" , "Table60");
		System.out.println("TestReadFromKey 1, checking for existing table and non-existing row: " + object3.toString() );
		assert object3.equals("The key yay does not exist. Please check the key name and try again") : object3.toString();
	}//end test read from key 
	
	@Test
	public void testAddElementToTable() {
		System.out.println("\n\n-----------Testing delete table row from DB, retruns empty string on success-------------");

		String temp = fakeDatabase.createTable("Table1");

		String result = fakeDatabase.addElementToTable("Table1" , new Data("some name" , "2000" , "some value"));
		System.out.println("TestAddElementToTable 1, checking for existing tables: " + result );
		assert result.equals("") : result;

		String result2 = fakeDatabase.addElementToTable("Table24" , new Data("some name" , "2000" , "some value"));
		System.out.println("TestAddElementToTable 2, checking for non-existent tables: " + result2 );
		assert result2.length() != 0 : result2;

		String result3 = fakeDatabase.addElementToTable("Table1" , new Data("some name" , "2000" , "some value"));
		System.out.println("TestAddElementToTable 3, checking for several entries to the same table: " + result3 );
		assert result3.equals("") : result3;

	}//end test add element to table

	@Test
	public void testDeleteTable() {
		System.out.println("\n\n-----------Testing read from table row from DB, retruns a success string or a failure string-------------");

		String temp = fakeDatabase.createTable("Table30");

		String result = fakeDatabase.deleteTable("Table30");
		System.out.println("TestDeleteTable 1, checking for existing tables: " + result );
		assert result.equals("") : result;

		String result2 = fakeDatabase.deleteTable("Table30");
		System.out.println("TestDeleteTable 2, checking for an already deleted table: " + result2 );
		assert result2.length() != 0 : result2;

		String result3 = fakeDatabase.deleteTable("Table34");
		System.out.println("TestDeleteTable 3, checking for non-existent tables: " + result3 );
		assert result3.length() != 0 : result3;
	}//end test delete table
	
	@Test
	public void testDeleteValue () {
		System.out.println("\n\n-----------Testing read from table from DB, retruns a list on success and a string on failure-------------");

		String temp = fakeDatabase.createTable("Table50");
		String temp2 = fakeDatabase.addElementToTable("Table50" , new Data("some name" , "2000", "some value"));

		String result = fakeDatabase.deleteValue("Table50" , "name");
		System.out.println("TestDeleteValue 1, checking for an existing table and existing data set: " + result);
		assert result.equals("") : result;

		String result2 = fakeDatabase.deleteValue("Table49" , "steps");
		System.out.println("TestDeleteValue 2, checking for an non-existing table and existing data set: " + result2);
		assert result2.length() != 0 : result2;

		String result3 = fakeDatabase.deleteValue("Table50" , "name");
		System.out.println("TestDeleteValue 3, checking for an existing table and an already deleted data set: " + result3);
		assert result3.length() != 0 : result3;

		String result4 = fakeDatabase.deleteValue("Table50" , "yepee");
		System.out.println("TestDeleteValue 4, checking for an existing table and non-existing data set: " + result4);
		assert result4.length() != 0 : result4;
	}//end test delete value
}
