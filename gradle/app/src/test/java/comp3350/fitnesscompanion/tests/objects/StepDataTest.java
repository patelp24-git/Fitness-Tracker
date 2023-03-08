package comp3350.fitnesscompanion.tests.objects;
import org.junit.Assert;
import org.junit.Test;

import comp3350.fitnesscompanion.objects.StepData;

public class StepDataTest {

    @Test
    public void testStepData(){
        StepData sdt;

        System.out.println("\nStarting StepDataTest");

        sdt = new StepData("jon.boisvert@myumn.ca","17-12-2021",7000);
        Assert.assertNotNull("Check if object is actually created",sdt);
        Assert.assertEquals("Check if email matches","jon.boisvert@myumn.ca", sdt.getEmail());
        Assert.assertEquals("Check if date matches","17-12-2021",sdt.getDate());
        Assert.assertEquals("Check if steps match",7000,sdt.getSteps());

        System.out.println("\nEnding StepDataTest");

    }

}
