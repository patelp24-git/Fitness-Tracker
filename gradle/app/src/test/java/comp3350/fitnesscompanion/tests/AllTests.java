package comp3350.fitnesscompanion.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import comp3350.fitnesscompanion.logic.AccessServices;
import comp3350.fitnesscompanion.logic.Main;
import comp3350.fitnesscompanion.logic.Validate;
import comp3350.fitnesscompanion.tests.logicLayer.AccessServicesTest;
import comp3350.fitnesscompanion.tests.logicLayer.BmiCalculatorImplementationTest;
import comp3350.fitnesscompanion.tests.logicLayer.MainTest;
import comp3350.fitnesscompanion.tests.logicLayer.ValidateDataTest;
import comp3350.fitnesscompanion.tests.objects.StepDataTest;
import comp3350.fitnesscompanion.tests.objects.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StepDataTest.class,
        UserTest.class,
        ValidateDataTest.class,
        MainTest.class,
        AccessServicesTest.class,
        BmiCalculatorImplementationTest.class
        //add more as needed
})
public class AllTests
{}

