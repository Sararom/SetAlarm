package com.romero.setalarm;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    int hour = -1;
    int minutes= -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker h_np = (NumberPicker) findViewById(R.id.hour_wll);
        NumberPicker m_np = (NumberPicker) findViewById(R.id.minute_wll);


        h_np.setMinValue(0);
        m_np.setMinValue(0);

        h_np.setMaxValue(23);
        m_np.setMaxValue(59);

        h_np.setWrapSelectorWheel(true);
        m_np.setWrapSelectorWheel(true);

            h_np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker2, int oldVal, int newValh){
                    //Display the newly selected number from picker
                    hour=newValh;
                }
            });
            m_np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker2, int oldVal, int newValm){
                    //Display the newly selected number from picker
                    minutes=newValm;
                }
            });

    }

    public void createAlarm(View v) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, ((EditText)findViewById(R.id.msg)).getText().toString())
                .putExtra(AlarmClock.EXTRA_HOUR,hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);

            Log.d("SISALE",hour+" "+minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}
