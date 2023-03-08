package comp3350.fitnesscompanion.presentation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.R;
import comp3350.fitnesscompanion.logic.AccessServices;
import comp3350.fitnesscompanion.logic.Validate;
import comp3350.fitnesscompanion.objects.User;

public class RegistrationPage extends Activity {
    private Validate vldtr = new Validate();
    private Button backBttn1, backBttn2, signUpBtn, nextBttn;
    private LinearLayout layout0, layout1, layout2, layout3, layout4, layout5, layout6, layout7;
    private EditText regFirstName, regLastName, regEmail, regPassword, regAge, regHeight, regWeight;
    private String fName, lName, usrEmail, usrPwsd, usrAge, usrHeight, usrWeight;
    private UserPersistence help = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        help = AccessServices.getUserPersistenceHSQLDB();

        backBttn1 = findViewById(R.id.backToMain);
        backBttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMain = new Intent(RegistrationPage.this, MainActivity.class);
                startActivity(backToMain);



            }
        });

        backBttn2 = findViewById(R.id.backToPage1);
        backBttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backBttn2.setVisibility(View.GONE);
                backBttn1.setVisibility(View.VISIBLE);
                layout0 = findViewById(R.id.regIndex0);
                layout0.setVisibility(View.VISIBLE);
                layout1 = findViewById(R.id.regIndex1);
                layout1.setVisibility(View.VISIBLE);
                layout2 = findViewById(R.id.regIndex2);
                layout2.setVisibility(View.VISIBLE);
                layout3 = findViewById(R.id.regIndex3);
                layout3.setVisibility(View.VISIBLE);
                layout4 = findViewById(R.id.regIndex4);
                layout4.setVisibility(View.VISIBLE);
                layout5 = findViewById(R.id.regIndex5);
                layout5.setVisibility(View.GONE);
                layout6 = findViewById(R.id.regIndex6);
                layout6.setVisibility(View.GONE);
                layout7 = findViewById(R.id.regIndex7);
                layout7.setVisibility(View.GONE);
                nextBttn.setVisibility(View.VISIBLE);
                signUpBtn.setVisibility(View.GONE);
            }
        });

        signUpBtn = findViewById(R.id.signUpBttn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regAge = findViewById(R.id.regAge);
                usrAge = regAge.getText().toString().trim();
                regWeight = findViewById(R.id.regWeight);
                usrWeight = regWeight.getText().toString().trim();
                regHeight = findViewById(R.id.regHeight);
                usrHeight = regHeight.getText().toString().trim();
                if(vldtr.verifyNumber(usrAge)){
                    int temp1 = Integer.parseInt(usrAge);
                    if(vldtr.verifyNumber(usrHeight)){
                        int temp2 = Integer.parseInt(usrHeight);
                        if(vldtr.verifyNumber(usrWeight)){
                            int temp3 = Integer.parseInt(usrWeight);
                            User user = new User(usrEmail,usrPwsd,fName,lName,temp1,temp3,temp2);
                            boolean check = help.addUser(user);
                            if(check){
                                toastMessage("Registered Successfully!");
                                Intent home = new Intent(RegistrationPage.this, LandingPage.class);
                                home.putExtra("email",usrEmail);
                                edtTxtNull();
                                startActivity(home);
                            }else{
                                toastMessage("Something went wrong!");
                            }
                        }else{
                            regWeight.setHintTextColor(Color.parseColor("#ff0000"));
                            regWeight.setHint("Invalid Number*");
                        }
                    }else{
                        regHeight.setHintTextColor(Color.parseColor("#ff0000"));
                        regHeight.setHint("Invalid Number*");
                    }
                }else{
                    regAge.setHintTextColor(Color.parseColor("#ff0000"));
                    regAge.setHint("Invalid Number*");
                }

            }
        });



        nextBttn = findViewById(R.id.nextBttn);
        nextBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regFirstName = findViewById(R.id.regFirstName);
                fName = regFirstName.getText().toString().trim();
                regLastName = findViewById(R.id.regLastName);
                lName = regLastName.getText().toString().trim();
                regEmail = findViewById(R.id.regEmail);
                usrEmail = regEmail.getText().toString().toLowerCase().trim();
                regPassword = findViewById(R.id.regPassword);
                usrPwsd = regPassword.getText().toString().trim();
                if(vldtr.checkName(fName)){
                    if(vldtr.checkName(lName)){
                        if (vldtr.checkEmail(usrEmail) && !help.searchUser(usrEmail)){
                            if (vldtr.checkPassword(usrPwsd)){
                                backBttn2.setVisibility(View.VISIBLE);
                                backBttn1.setVisibility(View.GONE);
                                nextBttn.setVisibility(View.GONE);
                                layout0 = findViewById(R.id.regIndex0);
                                layout0.setVisibility(View.GONE);
                                layout1 = findViewById(R.id.regIndex1);
                                layout1.setVisibility(View.GONE);
                                layout2 = findViewById(R.id.regIndex2);
                                layout2.setVisibility(View.GONE);
                                layout3 = findViewById(R.id.regIndex3);
                                layout3.setVisibility(View.GONE);
                                layout4 = findViewById(R.id.regIndex4);
                                layout4.setVisibility(View.GONE);
                                layout5 = findViewById(R.id.regIndex5);
                                layout5.setVisibility(View.VISIBLE);
                                layout6 = findViewById(R.id.regIndex6);
                                layout6.setVisibility(View.VISIBLE);
                                layout7 = findViewById(R.id.regIndex7);
                                layout7.setVisibility(View.VISIBLE);
                                signUpBtn.setVisibility(View.VISIBLE);
                            }else{
                                regPassword.setText(null);
                                regPassword.setHint("Invalid Password*");
                                regPassword.setHintTextColor(Color.parseColor("#ff0000"));
                                Toast.makeText(RegistrationPage.this, "password should contain:\n" + "-at least 1 digit.\n" + "-no spaces\n" + "-at least 1 special character(&amp;@#$%^+=)\n" + "-at least 1 lower case letter:[a-z]\n" + "-at least 1 upper case letter:[A-Z]\n" + "-should be between 8 and 10 letters.", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            regEmail.setText(null);
                            Toast.makeText(RegistrationPage.this, "Invalid Email*:\n" + "-may be you are already registered.\n" + "-please check your email once again." , Toast.LENGTH_LONG).show();
                            regEmail.setHintTextColor(Color.parseColor("#ff0000"));
                        }
                    }else{

                        regLastName.setHint("Invalid last name*");
                        regLastName.setHintTextColor(Color.parseColor("#ff0000"));

                    }
                }else {
                    regFirstName.setHintTextColor(Color.parseColor("#ff0000"));
                    regFirstName.setHint("Invalid first name*");
                }
            }
        });
        }
    private void toastMessage(String toast){
        Toast.makeText(RegistrationPage.this, toast, Toast.LENGTH_LONG).show();
    }

    private void edtTxtNull(){
        regFirstName.setText(null);
        regLastName.setText(null);
        regEmail.setText(null);
        regPassword.setText(null);
        regAge.setText(null);
        regHeight.setText(null);
        regWeight.setText(null);;

    }

    }
