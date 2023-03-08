package comp3350.fitnesscompanion.logic;

import android.util.Log;

public class BmiCalculatorImplementation {

    private int height;
    private int weight;

    public BmiCalculatorImplementation(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public String result(){


        double answer = bmi();
        double rent = this.height / 100.0;
        double weight1 = rent * rent * 18.5;
        double weight2 = rent * rent * 24.9;
        String temp = "good luck!";

        if(answer < 18.5){

            temp = "Your BMI is "+ String.format("%.1f",answer) +", indicating your weight is in the Underweight category for adults of your height. For your height, a normal weight range would be from "+ String.format("%.0f",weight1) +" to "+ String.format("%.0f",weight2) +" kilograms.";

        }else if( answer >= 18.5 && answer <= 24.9 ){

            temp = "Your BMI is "+ String.format("%.1f",answer) +", indicating your weight is in the Normal category for adults of your height. For your height, a normal weight range would be from "+ String.format("%.0f",weight1) +" to "+ String.format("%.0f",weight2) +" kilograms.";

        }else if(answer >= 25.0 && answer <= 29.9 ){

            temp = "Your BMI is "+ String.format("%.1f",answer) +", indicating your weight is in the Overweight category for adults of your height. For your height, a normal weight range would be from "+ String.format("%.0f",weight1) +" to "+ String.format("%.0f",weight2) +" kilograms.";

        }else if( answer >= 30.0 ){

            temp = "Your BMI is "+ String.format("%.1f",answer) +", indicating your weight is in the Obese category for adults of your height. For your height, a normal weight range would be from "+ String.format("%.0f",weight1) +" to "+ String.format("%.0f",weight2) +" kilograms.";

        }

        return temp;
    }

    private double bmi(){

        double result = 0;
        double temp = 0;

        temp = this.height / 100.0; // conversion in meters

        result = this.weight / ( temp * temp ); // bmi calculation

        return result;
    }



}
