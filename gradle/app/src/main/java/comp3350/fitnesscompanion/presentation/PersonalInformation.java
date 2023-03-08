package comp3350.fitnesscompanion.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.R;
import comp3350.fitnesscompanion.logic.AccessServices;
import comp3350.fitnesscompanion.logic.Validate;
import comp3350.fitnesscompanion.objects.User;

public class PersonalInformation extends AppCompatActivity {

    private Validate vldtr = new Validate();
    private UserPersistence database;
    private EditText regFirstName, regLastName, regPassword, regAge, regHeight, regWeight;
    private User userNew;
    private TextView regEmail;
    private Button updtButton;
    private String email, fName, lName, usrEmail, usrPwsd, usrAge, usrHeight, usrWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information);

        database = AccessServices.getUserPersistenceHSQLDB();
        regFirstName = findViewById(R.id.regFirstName);
        regLastName = findViewById(R.id.regLastName);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        regAge = findViewById(R.id.regAge);
        regWeight = findViewById(R.id.regWeight);
        regHeight = findViewById(R.id.regHeight);
        updtButton = findViewById(R.id.updateBttn);

        email = getIntent().getStringExtra("email");
        User user = database.getUser(email);

        if (user != null) {
            regFirstName.setText(user.getFname());
            regLastName.setText(user.getLname());
            regEmail.setText(user.getEmail());
            regPassword.setText(user.getPassword());
            regAge.setText(""+user.getAge());
            regWeight.setText(""+user.getWeight());
            regHeight.setText(""+user.getHeight());

        }

        updtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = regFirstName.getText().toString().trim();
                lName = regLastName.getText().toString().trim();
                usrEmail = regEmail.getText().toString().trim();
                usrPwsd = regPassword.getText().toString().trim();
                usrAge = regAge.getText().toString().trim();
                usrWeight = regWeight.getText().toString().trim();
                usrHeight = regHeight.getText().toString().trim();
                if (vldtr.checkName(fName)) {
                    if (vldtr.checkName(lName)) {
                        if (vldtr.checkEmail(usrEmail)) {
                            if (vldtr.checkPassword(usrPwsd)) {
                                if (vldtr.verifyNumber(usrAge)) {
                                    int temp1 = Integer.parseInt(usrAge);
                                    if (vldtr.verifyNumber(usrHeight)) {
                                        int temp2 = Integer.parseInt(usrHeight);
                                        if (vldtr.verifyNumber(usrWeight)) {
                                            int temp3 = Integer.parseInt(usrWeight);
                                            userNew = new User(usrEmail, usrPwsd, fName, lName, temp1, temp3, temp2);
                                            boolean checkUD = database.updateUser(userNew, email);
                                            if(checkUD){
                                                Toast.makeText(PersonalInformation.this,"Update Successfully!",Toast.LENGTH_LONG).show();
                                            }else{
                                                Toast.makeText(PersonalInformation.this,"Update not Successful!",Toast.LENGTH_LONG).show();
                                            }
                                        } else {
                                            regWeight.setHintTextColor(Color.parseColor("#ff0000"));
                                            regWeight.setHint("Invalid Number*");
                                        }
                                    } else {
                                        regHeight.setHintTextColor(Color.parseColor("#ff0000"));
                                        regHeight.setHint("Invalid Number*");
                                    }
                                } else {
                                    regAge.setHintTextColor(Color.parseColor("#ff0000"));
                                    regAge.setHint("Invalid Number*");
                                }
                            } else {
                                regPassword.setText(null);
                                regPassword.setHint("Invalid Password*");
                                regPassword.setHintTextColor(Color.parseColor("#ff0000"));
                                Toast.makeText(PersonalInformation.this, "password should contain:\n" + "-at least 1 digit.\n" + "-no spaces\n" + "-at least 1 special character(&amp;@#$%^+=)\n" + "-at least 1 lower case letter:[a-z]\n" + "-at least 1 upper case letter:[A-Z]\n" + "-should be between 8 and 10 letters.", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            regEmail.setHintTextColor(Color.parseColor("#ff0000"));
                        }
                    } else {
                        regLastName.setHintTextColor(Color.parseColor("#ff0000"));
                        regLastName.setHint("Invalid last name*");
                    }
                } else {
                    regFirstName.setHintTextColor(Color.parseColor("#ff0000"));
                    regFirstName.setHint("Invalid first name*");
                }
            }
        });


        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent home = new Intent(PersonalInformation.this, LandingPage.class);
        home.putExtra("email", email);
        startActivity(home);
    }
}

