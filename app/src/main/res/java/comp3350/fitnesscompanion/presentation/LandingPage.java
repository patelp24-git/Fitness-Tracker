package comp3350.fitnesscompanion.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.R;
import comp3350.fitnesscompanion.logic.AccessServices;
import comp3350.fitnesscompanion.objects.User;

public class LandingPage extends Activity {

    private ImageButton stepcounter,personalInfo,bmiCalculator;
    private Button logOut;
    private String email;
    private TextView txt1;
    private UserPersistence database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        database = AccessServices.getUserPersistenceHSQLDB();

        email = getIntent().getStringExtra("email");
        txt1 = findViewById(R.id.usrName);
        User user = database.getUser(email);
        if(user != null){
            txt1.setText("Hello "+user.getFname());
        }


        logOut = findViewById(R.id.logOutBtn);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(LandingPage.this, MainActivity.class);
                startActivity(home);
            }
        });
        stepcounter = findViewById(R.id.stepCounter);
        stepcounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(LandingPage.this, StepCounter.class);
                home.putExtra("email", email);
                startActivity(home);
            }
        });
        personalInfo = findViewById(R.id.userInformation);
        personalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(LandingPage.this, PersonalInformation.class);
                home.putExtra("email", email);
                startActivity(home);
            }
        });
        bmiCalculator = findViewById(R.id.bmiCalculator);
        bmiCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(LandingPage.this, BmiCalculator.class);
                home.putExtra("email", email);
                startActivity(home);
            }
        });
    }

    }




