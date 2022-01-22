package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        /*quantity = quantity + 1;
        displayQuantity(quantity);*/

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:47.6, -122.3"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checked);
//        boolean haswhippedCream =whippedCreamCheckBox.isChecked();
//       int price = calculatePrice();
//       String priceMessage =createOrderSummary(price,haswhippedCream);
//       displayMessage(priceMessage);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:47.6, -122.3"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

    }

    /**
     * Calculates the price of the order.
     *
     * @return is the number of cups of coffee ordered
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }


    private String createOrderSummary(int price,boolean haswhippedCream){
        String priceMessage = "Name : varun";
        priceMessage = priceMessage + "\nQuantity" + quantity;
        priceMessage += "add whpped cream" + haswhippedCream;
        priceMessage = priceMessage + "\nTotal : $" + price;
        priceMessage = priceMessage + "\n Thank You";
        displayMessage(priceMessage);
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView)
                findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.orderSummaryTextView);
        OrderSummaryTextView.setText(message);
    }

    }
