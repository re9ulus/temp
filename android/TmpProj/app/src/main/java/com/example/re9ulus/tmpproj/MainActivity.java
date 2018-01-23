package com.example.re9ulus.tmpproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        TextView textView = new TextView(this);
        textView.setText("Hello world!");
        textView.setTextSize(32);

        setContentView(textView);
    }
}
