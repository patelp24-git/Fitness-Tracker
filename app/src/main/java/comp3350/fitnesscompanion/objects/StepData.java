package comp3350.fitnesscompanion.objects;

public class StepData {

    private final String email;
    private String date;
    private int steps;

    public StepData(String email ,String date, int steps) {
        this.email = email;
        this.date = date;
        this.steps = steps;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
