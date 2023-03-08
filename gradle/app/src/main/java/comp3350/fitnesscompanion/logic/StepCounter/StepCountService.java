package comp3350.fitnesscompanion.logic.StepCounter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.annotation.Nullable;

import comp3350.fitnesscompanion.logic.BroadcastVariables;

/* Service class that runs in background, communicates data about
*  about step counter to UI and database.
* TODO: Make this a foreground service (allows user to know using
*  notification bar that something is running in background)
* */
public class StepCountService extends Service {
    private static final String TAG = "Step counter Service"; //for debug

    private BroadcastReceiver serviceReceiver;

    private StepDetector stepDetector;

    @Override
    public void onCreate() {
        super.onCreate();
        this.stepDetector = new StepDetector(this,0);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        setupReceiver();
        if(!stepDetector.startSensor()){ stopSelf(); }

        //loop here

        return START_STICKY;
    }

    private void setupReceiver() {
        serviceReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent){
                String action = intent.getAction();
                switch(action) {
                    case BroadcastVariables.ACTION_REQUEST_STEP_COUNT: //if UI explicitly ask for steps
                        stepDetector.sendStepsToUI();
                        break;
                    case BroadcastVariables.ACTION_UPDATE_STEP_DB:   //if UI asks to update db
                       sendStepCountToDb();
                        break;
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadcastVariables.ACTION_UPDATE_STEP_DB);
        intentFilter.addAction(BroadcastVariables.ACTION_REQUEST_STEP_COUNT);
        registerReceiver(serviceReceiver, intentFilter);
    }

    private void sendStepCountToDb(){    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        stepDetector.removeSensor();
        unregisterReceiver(serviceReceiver);
        super.onDestroy();
    }
}

