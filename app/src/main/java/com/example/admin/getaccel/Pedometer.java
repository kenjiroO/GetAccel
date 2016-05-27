package com.example.admin.getaccel;


import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public abstract class Pedometer extends Activity implements SensorEventListener{
    private static SensorManager manager;
    private static TextView xTextView;
    private static TextView yTextView;
    private static TextView zTextView;
    private float count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        xTextView = (TextView)findViewById(R.id.textView);
        yTextView = (TextView)findViewById(R.id.textView2);
        zTextView = (TextView)findViewById(R.id.textView3);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            count = event.values[0];
        }
    }


}
