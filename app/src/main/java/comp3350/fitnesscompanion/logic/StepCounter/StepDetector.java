package comp3350.fitnesscompanion.logic.StepCounter;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import comp3350.fitnesscompanion.logic.BroadcastVariables;

/* Class that just counts number of steps using accelerometer sensor */

class StepDetector implements SensorEventListener {

    private final double threshHold = 3;

    private long previousTimeStamp;
    private double previousMagnitude;
    private int currSteps;
    private SensorManager sensorManager;
    private Sensor accelerometerStepCounter;
    private StepCountService service;
    private Context mContext;

    public StepDetector(Context context, int startingSteps){
        this.previousTimeStamp = System.currentTimeMillis();
        this.previousMagnitude = 0;
        this.currSteps = startingSteps;
        mContext = context;
        service = (StepCountService)mContext;
    }

    //returns false if it failed to start
    public Boolean startSensor(){
        sensorManager = (SensorManager) this.mContext.getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            this.accelerometerStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            this.sensorManager.registerListener(this,accelerometerStepCounter,SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            return false;
        }
        return true;
    }

    public void removeSensor(){
        sensorManager.unregisterListener(this, accelerometerStepCounter);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() != Sensor.TYPE_ACCELEROMETER) return;
        long currTimeStamp = System.currentTimeMillis();
        if(currTimeStamp >= (previousTimeStamp+100)) { //if 1 milliseconds has passed
            float accel_x = sensorEvent.values[0];
            float accel_y = sensorEvent.values[1];
            float accel_z = sensorEvent.values[2];

            double magnitude = Math.sqrt(accel_x * accel_y * accel_z);
            double deltaMag = magnitude - previousMagnitude;
            previousMagnitude = magnitude;

            if (deltaMag > threshHold) {
                this.currSteps++;
            }
            sendStepsToUI();
            previousTimeStamp = currTimeStamp;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {    }

    public void sendStepsToUI(){
        Intent NewIntent = new Intent();
        NewIntent.setAction(BroadcastVariables.ACTION_UPDATE_UI_STEP);
        NewIntent.putExtra(BroadcastVariables.KEY_STEP_INT, this.currSteps);
        mContext.sendBroadcast(NewIntent);
    }

    public int getSteps(){
        return currSteps;
    }
}
