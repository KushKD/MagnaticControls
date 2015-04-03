package com.kailash.magnet.magnaticcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

import com.kailash.magnet.uicontrols.BaseUIActivity;

public class MainActivityWear extends BaseUIActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_wear);
        mTextView = (TextView)findViewById(R.id.t1);


        int x = add(34,132);
        Log.d("The addition is",Integer.toString(x));
        mTextView.setText(Integer.toString(x));

        /**
         * Kush kumar Dhawan Working with Git
         */

    }
}
