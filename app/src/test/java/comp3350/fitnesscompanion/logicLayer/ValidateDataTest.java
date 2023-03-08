package comp3350.fitnesscompanion.tests.logicLayer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import comp3350.fitnesscompanion.logic.Validate;

public class ValidateDataTest {

    private Validate vldtr;

    @Before
    public void intialize(){
        vldtr = new Validate();
    }

    @Test
    public void Test(){
        Assert.assertTrue("test if email is valid",vldtr.checkEmail("john.example@ddd.com"));
        Assert.assertTrue("test if email is valid",!vldtr.checkEmail("john.exampleddd.com"));
        Assert.assertTrue("test if password is valid",vldtr.checkPassword("#1Manitoba"));
        Assert.assertTrue("test if password is valid",!vldtr.checkPassword("1mamansda"));
        Assert.assertTrue("test if name is valid",vldtr.checkName("John"));
        Assert.assertTrue("test if name is valid",!vldtr.checkName("21"));
        Assert.assertTrue("test if name is valid",vldtr.verifyNumber("52"));
        Assert.assertTrue("test if name is valid",!vldtr.verifyNumber("ab"));

    }

    @After
    public void end(){
        vldtr = null;
    }

}
