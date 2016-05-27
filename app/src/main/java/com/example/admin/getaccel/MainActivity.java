package com.example.admin.getaccel;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener{
    private static SensorManager manager;
    private static TextView xTextView;
    private static TextView yTextView;
    private static TextView zTextView;
    private static TextView count;
    //float count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        xTextView = (TextView)findViewById(R.id.textView);
        yTextView = (TextView)findViewById(R.id.textView2);
        zTextView = (TextView)findViewById(R.id.textView3);
       count = (TextView)findViewById(R.id.countText);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            xTextView.setText("x : " + event.values[0]);
            yTextView.setText("y : " + event.values[1]);
            zTextView.setText("z : " + event.values[2]);
        }

        if(event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            count.setText("count : " + event.values[0]);
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        manager.unregisterListener(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        List<Sensor> sensors = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(sensors.size() > 0){
            Sensor s = sensors.get(0);
            manager.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
