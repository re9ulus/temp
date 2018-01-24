package com.example.re9ulus.multipleactivityproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        RenderNumbers();
    }

    void RenderNumbers() {
        ListView numbersView = (ListView) findViewById(R.id.numbers_activity);
        ArrayAdapter<String> numbersAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, numbers);
        numbersView.setAdapter(numbersAdapter);
    }

    String[] numbers = {"one", "two", "three", "four", "five"};
}