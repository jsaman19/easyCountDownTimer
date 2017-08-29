package ir.samanjafari.easycountdowntimer;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by saman on 8/18/2017 AD.
 */

public class EasyCountDownTextview extends LinearLayout {

    private TextView topHoursTxt, belowHoursTxt, hoursTxt, belowMinuteTxt, topMinuteTxt, minuteTxt, secondTxt, belowSecondTxt, topSecondTxt, colon1, colon2;
    private RelativeLayout hrLayout, minLayout, secLayout;
    private CountDownInterface countDownInterface, newCountDownInterface;

    public EasyCountDownTextview(Context context) {
        this(context, null, 0);
    }

    public EasyCountDownTextview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EasyCountDownTextview(final Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.view_textview, this);
        hoursTxt = (TextView) view.findViewById(R.id.hours_txt);
        belowHoursTxt = (TextView) view.findViewById(R.id.below_hours_txt);
        topHoursTxt = (TextView) view.findViewById(R.id.top_hours_txt);
        minuteTxt = (TextView) view.findViewById(R.id.minute_txt);
        belowMinuteTxt = (TextView) view.findViewById(R.id.below_minute_txt);
        topMinuteTxt = (TextView) view.findViewById(R.id.top_minute_txt);
        secondTxt = (TextView) view.findViewById(R.id.second_txt);
        belowSecondTxt = (TextView) view.findViewById(R.id.below_second_txt);
        topSecondTxt = (TextView) view.findViewById(R.id.top_second_txt);
        colon1 = (TextView) view.findViewById(R.id.colon1);
        colon2 = (TextView) view.findViewById(R.id.colon2);
        hrLayout = (RelativeLayout) view.findViewById(R.id.hours_layout);
        minLayout = (RelativeLayout) view.findViewById(R.id.minute_layout);
        secLayout = (RelativeLayout) view.findViewById(R.id.second_layout);


        this.countDownInterface = countDownInterface;

        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.EasyCountDownTextview, 0, 0);

        int hours = attr.getInteger(R.styleable.EasyCountDownTextview_hours, 0);
        int minute = attr.getInteger(R.styleable.EasyCountDownTextview_minute, 0);
        final int second = attr.getInteger(R.styleable.EasyCountDownTextview_second, 0);
        int color = attr.getColor(R.styleable.EasyCountDownTextview_textColor, 0xff000000);
        int size = attr.getDimensionPixelSize(R.styleable.EasyCountDownTextview_textSize, 0);
        boolean showHours = attr.getBoolean(R.styleable.EasyCountDownTextview_showHours, true);
        int colonColor = attr.getColor(R.styleable.EasyCountDownTextview_colonColor, 0xff000000);
        int digitBackgroundColor = -1;
        int digitBackgroundResource = attr.getResourceId(R.styleable.EasyCountDownTextview_digitBackground, -1);
        if (digitBackgroundResource <= 0)
            digitBackgroundColor = attr.getColor(R.styleable.EasyCountDownTextview_digitBackground, -1);
        boolean setAnim = attr.getBoolean(R.styleable.EasyCountDownTextview_setAnimation, false);

        long millisin = (hours * 3600000) + (minute * 60000) + (second * 1000);

        if (countDownInterface == null) {
            countDownInterface = new CountDownInterface() {
                @Override
                public void onTick(long time) {
                    newCountDownInterface.onTick(time);
                }

                @Override
                public void onFinish() {
                    newCountDownInterface.onFinish();
                }
            };
        }

        MyCountDown myCountDown = new MyCountDown(millisin, 1000, hoursTxt, minuteTxt, secondTxt,
                countDownInterface);
        myCountDown.start();

        if(setAnim) {
            hoursTxt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    Log.i("sddsf", charSequence.toString());

                    int digit = Integer.parseInt(charSequence.toString());
                    int newDigit = digit + 1;

                    topHoursTxt.setText(String.valueOf(newDigit));
                    belowHoursTxt.setText(String.valueOf(digit));

                    Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_up_out);
                    Animation animation1 = AnimationUtils.loadAnimation(context, R.anim.push_up_in);
                    topHoursTxt.startAnimation(animation);
                    belowHoursTxt.startAnimation(animation1);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            secondTxt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    int digit = Integer.parseInt(charSequence.toString());
                    int newDigit = 59;
                    if (digit > 0)
                        newDigit = digit - 1;

                    topSecondTxt.setText(String.valueOf(digit));
                    belowSecondTxt.setText(String.valueOf(newDigit));

                    Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_up_out);
                    Animation animation1 = AnimationUtils.loadAnimation(context, R.anim.push_up_in);
                    topSecondTxt.startAnimation(animation);
                    belowSecondTxt.startAnimation(animation1);

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    Log.i("sddsf", charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

            minuteTxt.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    Log.i("sddsf", charSequence.toString());

                    int digit = Integer.parseInt(charSequence.toString());
                    int newDigit = 0;
                    if (digit != 59)
                        newDigit = digit + 1;

                    topMinuteTxt.setText(String.valueOf(newDigit));
                    belowMinuteTxt.setText(String.valueOf(digit));

                    Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_up_out);
                    Animation animation1 = AnimationUtils.loadAnimation(context, R.anim.push_up_in);
                    topMinuteTxt.startAnimation(animation);
                    belowMinuteTxt.startAnimation(animation1);
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
        else {
            hoursTxt.setVisibility(VISIBLE);
            minuteTxt.setVisibility(VISIBLE);
            secondTxt.setVisibility(VISIBLE);
        }

        if (size > 0)
            setTextSize(size);

        setTextColor(color);
        setColonColor(colonColor);
        setShowHours(showHours);
        if(digitBackgroundResource > 0)
            setDigitBackgroundResource(digitBackgroundResource);
        else
            setDigitBackgroundColor(digitBackgroundColor);
    }

    public void setTextColor(int color) {

        hoursTxt.setTextColor(color);
        topHoursTxt.setTextColor(color);
        belowHoursTxt.setTextColor(color);
        minuteTxt.setTextColor(color);
        topMinuteTxt.setTextColor(color);
        belowMinuteTxt.setTextColor(color);
        secondTxt.setTextColor(color);
        topSecondTxt.setTextColor(color);
        belowSecondTxt.setTextColor(color);
    }

    public void setTextSize(int size) {
        hoursTxt.setTextSize(size);
        topHoursTxt.setTextSize(size);
        belowHoursTxt.setTextSize(size);
        minuteTxt.setTextSize(size);
        topMinuteTxt.setTextSize(size);
        belowMinuteTxt.setTextSize(size);
        secondTxt.setTextSize(size);
        topSecondTxt.setTextSize(size);
        belowSecondTxt.setTextSize(size);
        colon1.setTextSize(size);
        colon2.setTextSize(size);
    }

    public void setShowHours(boolean show) {
        if (!show) {
            hoursTxt.setVisibility(GONE);
            topHoursTxt.setVisibility(GONE);
            belowHoursTxt.setVisibility(GONE);
            colon1.setVisibility(GONE);
        } else {
            hoursTxt.setVisibility(VISIBLE);
            topHoursTxt.setVisibility(VISIBLE);
            belowHoursTxt.setVisibility(VISIBLE);
            colon1.setVisibility(VISIBLE);
        }
    }

    public void setColonColor(int color) {
        colon1.setTextColor(color);
        colon2.setTextColor(color);
    }

    public void setDigitBackgroundColor(int color) {
        hoursTxt.setBackgroundColor(color);
        topHoursTxt.setBackgroundColor(color);
        belowHoursTxt.setBackgroundColor(color);
        minuteTxt.setBackgroundColor(color);
        topMinuteTxt.setBackgroundColor(color);
        belowMinuteTxt.setBackgroundColor(color);
        secondTxt.setBackgroundColor(color);
        topSecondTxt.setBackgroundColor(color);
        belowSecondTxt.setBackgroundColor(color);
    }

    public void setDigitBackgroundResource(int resId) {
        hoursTxt.setBackgroundResource(resId);
        topHoursTxt.setBackgroundResource(resId);
        belowHoursTxt.setBackgroundResource(resId);
        minuteTxt.setBackgroundResource(resId);
        topMinuteTxt.setBackgroundResource(resId);
        belowMinuteTxt.setBackgroundResource(resId);
        secondTxt.setBackgroundResource(resId);
        topSecondTxt.setBackgroundResource(resId);
        belowSecondTxt.setBackgroundResource(resId);
    }

    public void setOnTick(CountDownInterface countDownInterface)
    {
        this.newCountDownInterface = countDownInterface;
    }
}
