package ir.samanjafari.testmylibraries;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.Calendar;

import ir.samanjafari.easycountdowntimer.CountDownInterface;
import ir.samanjafari.easycountdowntimer.EasyCountDownTextview;

public class MainActivity extends AppCompatActivity {

    private EasyCountDownTextview easyCountDownTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easyCountDownTextview = findViewById(R.id.easyCountDownTextview);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 12);
        easyCountDownTextview.startTimer(calendar);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.iranyekanmediumfanum);
        easyCountDownTextview.setTypeFace(typeface);
    }

    public void startBtn_onClick(View view)
    {
        easyCountDownTextview.startTimer();
    }
}
