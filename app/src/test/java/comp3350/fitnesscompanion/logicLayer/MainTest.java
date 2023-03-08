package comp3350.fitnesscompanion.tests.logicLayer;

import org.junit.Assert;
import org.junit.Test;

import comp3350.fitnesscompanion.logic.Main;

public class MainTest {

    @Test
    public void Test(){
        Main.setDBPathName("database");
        Assert.assertEquals("database",Main.getDBPathName());
    }

}
