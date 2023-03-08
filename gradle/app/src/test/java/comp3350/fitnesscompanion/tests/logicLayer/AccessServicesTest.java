package comp3350.fitnesscompanion.tests.logicLayer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp3350.fitnesscompanion.Presistense.UserPersistenceSTUB;
import comp3350.fitnesscompanion.Presistense.hsqldb.StepDataPersistenceHSQLDB;
import comp3350.fitnesscompanion.Presistense.hsqldb.UserPersistenceHSQLDB;
import comp3350.fitnesscompanion.logic.AccessServices;

public class AccessServicesTest {



    @Test
    public void Test(){
        Assert.assertEquals(AccessServices.getStepDataPersistenceHSQLDB()instanceof StepDataPersistenceHSQLDB,true);
        Assert.assertEquals(AccessServices.getUserPersistenceHSQLDB()instanceof UserPersistenceHSQLDB,true);
        Assert.assertEquals(AccessServices.getUserPersistenceSTUB()instanceof UserPersistenceSTUB,true);
        Assert.assertEquals(AccessServices.getUserPersistenceSQLiteDB(null),null);
    }

}
