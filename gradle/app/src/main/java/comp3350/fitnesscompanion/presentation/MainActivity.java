package comp3350.fitnesscompanion.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import comp3350.fitnesscompanion.Presistense.UserPersistence;
import comp3350.fitnesscompanion.R;
import comp3350.fitnesscompanion.logic.AccessServices;
import comp3350.fitnesscompanion.logic.Main;
import comp3350.fitnesscompanion.logic.Validate;
import comp3350.fitnesscompanion.objects.User;

public class MainActivity extends AppCompatActivity {

    private EditText email, password;
    private Button signIn, Register;
    private static UserPersistence database;
    private Validate val = new Validate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        copyDatabaseToDevice();

        database = AccessServices.getUserPersistenceHSQLDB();

        selectionMethod();

    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "database";

        String[] assetName;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetName = assetManager.list(DB_PATH);
            for (int i = 0; i < assetName.length; i++) {
                assetName[i] = DB_PATH + "/" + assetName[i];
            }

            copyAssetsToDirectory(assetName, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];
            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }

    private void selectionMethod() {

        signIn = findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = findViewById(R.id.edtTxtEmail);

                String inputEmail = email.getText().toString().toLowerCase().trim();
                if (val.checkEmail(inputEmail)) {
                    password = findViewById(R.id.edtTxtPassword);
                    String inputPassword = password.getText().toString().trim();
                        User temp = database.getUser(inputEmail);
                        if (database.searchUser(inputEmail) && temp != null) {
                            if(temp.getPassword().equalsIgnoreCase(inputPassword)) {
                                Intent myInt = new Intent(MainActivity.this, LandingPage.class);
                                myInt.putExtra("email", inputEmail);
                                startActivity(myInt);
                            }else{
                                password.setText(null);
                                password.setHint("Password do no match*");
                                password.setHintTextColor(Color.parseColor("#ff0000"));
                                Toast.makeText(MainActivity.this, "Password do not match in our records!", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            email.setText(null);
                            email.setHint("Email not found*");
                            email.setHintTextColor(Color.parseColor("#ff0000"));
                            Toast.makeText(MainActivity.this,"Email Not Found! please Register",Toast.LENGTH_LONG).show();
                        }
                } else {
                    email.setText(null);
                    email.setHint("Invalid Email*");
                    email.setHintTextColor(Color.parseColor("#ff0000"));
                }
            }
        });

        Register = findViewById(R.id.registerBttn);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(MainActivity.this, RegistrationPage.class);
                startActivity(myInt);
            }
        });

    }


}