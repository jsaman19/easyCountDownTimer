package ir.samanjafari.testmylibraries;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ir.samanjafari.easycountdowntimer.CountDownInterface;
import ir.samanjafari.easycountdowntimer.EasyCountDownTextview;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyCountDownTextview easyCountDownTextview = findViewById(R.id.easyCountDownTextview);
        easyCountDownTextview.setTime(0, 0, 1, 0);
        easyCountDownTextview.setOnTick(new CountDownInterface() {
            @Override
            public void onTick(long time) {

            }

            @Override
            public void onFinish() {

            }
        });
    }
}
