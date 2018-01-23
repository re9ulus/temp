package com.example.re9ulus.multipleactivityproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        RenderNumbers();
    }

    void RenderNumbers() {
        LinearLayout currentLayout = (LinearLayout) findViewById(R.id.numbers_activity);
        for (String number : numbers) {
            TextView numberTextView = new TextView(this);
            numberTextView.setText(number);
            numberTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
            numberTextView.setGravity(Gravity.CENTER);
            currentLayout.addView(numberTextView);
        }
    }

    String[] numbers = {"one", "two", "three", "four", "five"};
}