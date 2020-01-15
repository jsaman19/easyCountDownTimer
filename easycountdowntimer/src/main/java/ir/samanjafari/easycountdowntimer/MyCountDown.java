package ir.samanjafari.easycountdowntimer;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by saman on 8/17/2017 AD.
 */

public class MyCountDown extends CountDownTimer {


    private TextView dayTxt, hrTxt, minTxt, scndTxt;
    private CountDownInterface countDownInterface;

    public MyCountDown(long millisInFuture, long countDownInterval,
                       TextView dayTxt, TextView hrTxt, TextView minTxt,
                       TextView scndTxt, CountDownInterface countDownInterface) {
        super(millisInFuture, countDownInterval);
        this.dayTxt = dayTxt;
        this.hrTxt = hrTxt;
        this.minTxt = minTxt;
        this.scndTxt = scndTxt;
        this.countDownInterface = countDownInterface;
    }

    @Override
    public void onTick(long l) {
        printTime(l);
        countDownInterface.onTick(l);
    }

    @Override
    public void onFinish() {
        hrTxt.setText("0");
        minTxt.setText("0");
        scndTxt.setText("0");
        dayTxt.setText("0");
        countDownInterface.onFinish();
    }

    private void printTime(long time) {
        int minute, second, hours, days;
        long secMilSec = 1000;
        long minMilSec = 60 * secMilSec;
        long hourMilSec = 60 * minMilSec;
        long dayMilSec = 24 * hourMilSec;

        int d = Integer.parseInt(dayTxt.getText().toString().trim());
        int hr = Integer.parseInt(hrTxt.getText().toString().trim());
        int min  = Integer.parseInt(minTxt.getText().toString().trim());


        hours = 0;
        minute = 0;
        days = 0;

        if (time >= dayMilSec) {
            days = (int) (time / dayMilSec);
            hours = (int) ((time % dayMilSec) / hourMilSec);
            minute = (int) (((time % dayMilSec) % hourMilSec) / minMilSec);
            second = (int) ((((time % dayMilSec) % hourMilSec) % minMilSec) / secMilSec);

            if(minute == 59 && second == 56)
                Log.i("asd", "ads : " + (time / dayMilSec));

        }
        else if (time >= hourMilSec) {
            hours = (int) (time / hourMilSec);
            minute = (int) ((time % hourMilSec) / minMilSec);
            second = (int) (((time % hourMilSec) % minMilSec) / secMilSec);
        } else if (time >= minMilSec) {
            minute = (int) (time / minMilSec);
            second = (int) ((time % minMilSec) / secMilSec);
        } else {
            second = (int) (time / secMilSec);
        }

        if(d != days)
            dayTxt.setText(String.valueOf(days).length() == 1 ? "0" + days : String.valueOf(days));

        if (hr != hours)
            hrTxt.setText(String.valueOf(hours).length() == 1 ? "0" + hours : String.valueOf(hours));

        if (min != minute)
            minTxt.setText(String.valueOf(minute).length() == 1 ? "0" + minute : String.valueOf(minute));

        scndTxt.setText(String.valueOf(second).length() == 1 ? "0" + second : String.valueOf(second));
    }
}
