package comp3350.fitnesscompanion.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.R;
import comp3350.fitnesscompanion.logic.AccessServices;
import comp3350.fitnesscompanion.logic.BmiCalculatorImplementation;
import comp3350.fitnesscompanion.logic.Validate;
import comp3350.fitnesscompanion.objects.User;

public class BmiCalculator extends AppCompatActivity {

    private TextView bmiInfo, bmiResult;
    private Button bmiButton, bmiCalcButton;
    private UserPersistence database;
    private LinearLayout layout0, layout1, layout2;
    private String email,usrWeight,usrHeight;
    private BmiCalculatorImplementation res;
    private EditText height,weight;
    private Validate vldtr = new Validate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

        database = AccessServices.getUserPersistenceHSQLDB();
        bmiInfo = findViewById(R.id.bmiInfo);
        bmiButton = findViewById(R.id.bmiButton);
        bmiCalcButton = findViewById(R.id.bmiCalcButton);
        bmiResult = findViewById(R.id.currentBMI);
        layout0 = findViewById(R.id.bmiHeight);
        layout1 = findViewById(R.id.bmiWeight);
        layout2 = findViewById(R.id.bmiTable);
        height = findViewById(R.id.regHeight);
        weight = findViewById(R.id.regWeight);

        email = getIntent().getStringExtra("email");
        User user = database.getUser(email);
        if(user != null){
            res = new BmiCalculatorImplementation(user.getHeight(),user.getWeight());
            bmiResult.setText(res.result());
        }

        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bmiInfo.setVisibility(View.GONE);
                bmiButton.setVisibility(View.GONE);
                bmiResult.setVisibility(View.VISIBLE);
                layout0.setVisibility(View.VISIBLE);
                layout1.setVisibility(View.VISIBLE);
                bmiCalcButton.setVisibility(View.VISIBLE);

            }
        });

        bmiCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = findViewById(R.id.regWeight);
                usrWeight = weight.getText().toString().trim();
                height = findViewById(R.id.regHeight);
                usrHeight = height.getText().toString().trim();
                    if(vldtr.verifyNumber(usrHeight)){
                        int temp2 = Integer.parseInt(usrHeight);
                        if(vldtr.verifyNumber(usrWeight)){
                            int temp3 = Integer.parseInt(usrWeight);
                            res = new BmiCalculatorImplementation(temp2,temp3);
                            bmiResult.setText(res.result());
                            layout0.setVisibility(View.GONE);
                            layout1.setVisibility(View.GONE);
                            layout2.setVisibility(View.VISIBLE);
                            bmiCalcButton.setVisibility(View.GONE);
                        }else{
                            weight.setHintTextColor(Color.parseColor("#ff0000"));
                            weight.setHint("Invalid Number*");
                        }
                    }else{
                        height.setHintTextColor(Color.parseColor("#ff0000"));
                        height.setHint("Invalid Number*");
                    }
                }

        });

    }
}