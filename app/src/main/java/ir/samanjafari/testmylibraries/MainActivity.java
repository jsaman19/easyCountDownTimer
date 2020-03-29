package ir.samanjafari.testmylibraries;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ir.samanjafari.easycountdowntimer.CountDownInterface;
import ir.samanjafari.easycountdowntimer.EasyCountDownTextview;

public class MainActivity extends AppCompatActivity {

    private EasyCountDownTextview easyCountDownTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easyCountDownTextview = findViewById(R.id.easyCountDownTextview);
    }

    public void startBtn_onClick(View view)
    {
        easyCountDownTextview.startTimer();
    }
}
