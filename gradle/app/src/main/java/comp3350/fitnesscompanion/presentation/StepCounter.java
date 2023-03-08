package comp3350.fitnesscompanion.presentation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import comp3350.fitnesscompanion.Presistense.StepDataPersistence;
import comp3350.fitnesscompanion.R;
import comp3350.fitnesscompanion.logic.AccessServices;
import comp3350.fitnesscompanion.logic.BroadcastVariables;
import comp3350.fitnesscompanion.logic.StepCounter.StepCountService;
import comp3350.fitnesscompanion.objects.StepData;

// step counter activity UI class
public class StepCounter extends Activity {
    public String TAG = "StepActivity"; //for debug
    private TextView tv_stepNumber;
    private Button serviceStartBtn;
    private Button serviceStopBtn;
    private Intent myIntent;
    private BroadcastReceiver activityReceiver;
    private StepDataPersistence stepData;
    private String email= null;
    private List<StepData> history = null;
    private int stepCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_counter);
        email = getIntent().getStringExtra("email");

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //keep screen on
        tv_stepNumber = (TextView) findViewById(R.id.tvStepNumber);
        serviceStartBtn = (Button) findViewById(R.id.startBtn);
        serviceStopBtn = (Button) findViewById(R.id.stopBtn);

        stepData = AccessServices.getStepDataPersistenceHSQLDB();

        updateStepDataTable();


        serviceStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(myIntent = new Intent(StepCounter.this, StepCountService.class));
                serviceStartBtn.setEnabled(false);
            }
        });
        serviceStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myIntent != null) stopService(myIntent);
                else myIntent = null;
                serviceStartBtn.setEnabled(true);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupReceiver();
        sendIntent(BroadcastVariables.ACTION_REQUEST_STEP_COUNT);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(activityReceiver);
        sendIntent(BroadcastVariables.ACTION_UPDATE_STEP_DB);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        sendIntent(BroadcastVariables.ACTION_UPDATE_STEP_DB);
        if (myIntent != null) stopService(myIntent);
        super.onDestroy();
    }

    public void sendIntent(String action) {
        Intent NewIntent = new Intent();
        NewIntent.setAction(action);
        sendBroadcast(NewIntent);
    }

    public void setupReceiver(){
        activityReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {updateVisual(intent);}
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadcastVariables.ACTION_UPDATE_UI_STEP);
        registerReceiver(activityReceiver, intentFilter);
    }

    private void updateVisual(Intent intent){
        if (intent.getAction().equals(BroadcastVariables.ACTION_UPDATE_UI_STEP)) {
            int stepCount = intent.getIntExtra(BroadcastVariables.KEY_STEP_INT, 0);
            tv_stepNumber.setText(String.valueOf(stepCount));
        }
    }

    private void updateStepDataTable(){

        history = stepData.getSteps(email);

        if(history != null && !history.isEmpty()) {
            int index = history.size();
            if (index != 0) {
                if (index >= 1) {
                    StepData temp1 = history.get(index - 1);
                    TextView date1 = findViewById(R.id.stepDate1);
                    TextView num1 = findViewById(R.id.stepNumber1);
                    date1.setText(temp1.getDate());
                    num1.setText("" + temp1.getSteps());
                }
                if (index >= 2) {
                    TextView date2 = findViewById(R.id.stepDate2);
                    TextView num2 = findViewById(R.id.stepNumber2);
                    StepData temp2 = history.get(index - 2);
                    date2.setText(temp2.getDate());
                    num2.setText("" + temp2.getSteps());
                }
                if (index == 3) {
                    StepData temp3 = history.get(index - 3);
                    TextView date3 = findViewById(R.id.stepDate3);
                    TextView num3 = findViewById(R.id.stepNumber3);
                    date3.setText(temp3.getDate());
                    num3.setText("" + temp3.getSteps());
                }
            }
        }






    }

}
