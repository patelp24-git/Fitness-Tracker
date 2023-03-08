package comp3350.fitnesscompanion.Presistense;

import java.util.List;

import comp3350.fitnesscompanion.objects.StepData;
import comp3350.fitnesscompanion.objects.User;

public interface StepDataPersistence {

    public boolean addSteps(final StepData user);

    public List<StepData> getSteps(final String email);

}
