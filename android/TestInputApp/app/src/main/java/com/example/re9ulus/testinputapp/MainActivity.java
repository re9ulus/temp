package com.example.re9ulus.testinputapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
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
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private double computeOrderPrice() {
        return price_for_cup * number_of_coffee_cups;
    }

    private String createOrderSummary() {
        String summary = "Total: " + computeOrderPrice() + "\nFor " +
                number_of_coffee_cups + " cups\n";

        if (is_chocolate_topping || is_whipped_cream_topping) {
            summary += "Toppings:\n";
            if (is_chocolate_topping) {
                summary += "chocolate\n";
            }
            if (is_whipped_cream_topping) {
                summary += "whipped_cream\n";
            }
        }

        summary += "Enjoy";
        if (!username.isEmpty()) {
            summary += ", " + username + "!";
        } else {
            summary += "!";
        }
        return summary;
    }

    public void order(View view) {
        if (number_of_coffee_cups > 0) {
            is_chocolate_topping = ((CheckBox) findViewById(R.id.chocolate_checkbox)).isChecked();
            is_whipped_cream_topping = ((CheckBox) findViewById(R.id.whipped_cream_checkbox)).isChecked();
            username = ((EditText) findViewById(R.id.name_edit_text)).getText().toString();
            displayMessage(createOrderSummary());

            Intent intent = new Intent(Intent.ACTION_SENDTO)
                    .putExtra(Intent.EXTRA_SUBJECT, "Test Order!")
                    .putExtra(Intent.EXTRA_TEXT, createOrderSummary());
            intent.setType("*/*");
            intent.setData(Uri.parse("mailto:"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }

    private double price_for_cup = 2.5;
    private int number_of_coffee_cups = 0;
    private boolean is_chocolate_topping = false;
    private boolean is_whipped_cream_topping = false;
    private String username = "";
}
