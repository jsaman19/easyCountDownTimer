package ir.samanjafari.easycountdowntimer;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by saman on 8/17/2017 AD.
 */

public class MyCountDown extends CountDownTimer {


    private TextView hrTxt, minTxt, scndTxt;
    private CountDownInterface countDownInterface;

    public MyCountDown(long millisInFuture, long countDownInterval, TextView hrTxt, TextView minTxt,
                       TextView scndTxt, CountDownInterface countDownInterface) {
        super(millisInFuture, countDownInterval);
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
        countDownInterface.onFinish();
    }

    private void printTime(long time) {
        int min = 0;
        int second;
        int hours = 0;
        if (time >= 3600000) {
            hours = (int) (time / 3600000);
            min = (int) ((time % 3600000) / 60000);
            second = (int) (((time % 3600000) % 60000) / 1000);
        } else if (time >= 60000) {
            min = (int) (time / 60000);
            second = (int) ((time % 60000)) / 1000;
        } else {
            second = (int) (time / 1000);
        }

        String hr = hrTxt.getText().toString().trim();
        String hr2 = String.valueOf(hours);
        if (!hr.equals(hr2))
            hrTxt.setText(String.valueOf(hours));

        if (!minTxt.getText().toString().trim().equals(String.valueOf(min)))
            minTxt.setText(String.valueOf(min));

        scndTxt.setText(String.valueOf(second));
    }
}
