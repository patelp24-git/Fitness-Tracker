package comp3350.fitnesscompanion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.fitnesscompanion.presentation.BMIActivityTest;
import comp3350.fitnesscompanion.presentation.MainActivityTest;
import comp3350.fitnesscompanion.presentation.PersonalInformationUpdateActivityTest;
import comp3350.fitnesscompanion.presentation.RegisterActivityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
      BMIActivityTest.class,
        MainActivityTest.class,
        RegisterActivityTest.class,
        PersonalInformationUpdateActivityTest.class
        //add more as needed
})
public class AllAcceptanceTests
{}
