package com.example.re9ulus.testinputapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateView(View view) {
        displayCoffeeCups();
        displayPrice(number_of_coffee_cups);
    }

    public void increment(View view) {
        if (number_of_coffee_cups < 10) {
            number_of_coffee_cups += 1;
            updateView(view);
        }
    }

    public void decrement(View view) {
        if (number_of_coffee_cups > 0) {
            number_of_coffee_cups -= 1;
            updateView(view);
        }
    }

    private void displayCoffeeCups() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number_of_coffee_cups);
    }

    private void displayPrice(int number_of_cups) {
        displayMessage(getRegionalPriceRepresentation(computeOrderPrice()));
    }

    private String getRegionalPriceRepresentation(double price) {
        return NumberFormat.getCurrencyInstance().format(price);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private double computeOrderPrice() {
        return price_for_cup * number_of_coffee_cups;
    }

    public void order(View view) {
        if (number_of_coffee_cups > 0) {
            String message = "Total: " + computeOrderPrice() + " for " +
                    number_of_coffee_cups + " cups. Enjoy!";
            displayMessage(message);
        }
    }

    private double price_for_cup = 2.5;
    private int number_of_coffee_cups = 0;
}
