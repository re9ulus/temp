package com.example.re9ulus.multipleactivityproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        for (int idx = 0; idx < numbers.length; ++idx) {
            TextView numberTextView = new TextView(this);
            numberTextView.setText(numbers[idx]);
            numberTextView.setTextSize(16);
            currentLayout.addView(numberTextView);
        }
    }

    String[] numbers = {"one", "two", "three"};
}