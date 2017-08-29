package ir.samanjafari.testmylibraries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ir.samanjafari.easycountdowntimer.CountDownInterface;
import ir.samanjafari.easycountdowntimer.EasyCountDownTextview;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyCountDownTextview countDownTextview = (EasyCountDownTextview) findViewById(R.id.easyCountDownTextview);
        countDownTextview.setOnTick(new CountDownInterface() {
            @Override
            public void onTick(long time) {
                Log.i("sdds", "sdsd");
            }

            @Override
            public void onFinish() {
                Log.i("sdds", "sdsd");
            }
        });
    }
}
