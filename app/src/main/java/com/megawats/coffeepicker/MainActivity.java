package com.megawats.coffeepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

// Displays the screen to order coffee
public class MainActivity extends AppCompatActivity {

    // The number of coffee items ordered
    private int orderedCoffeeAmount = 0;

    // The price per coffee
    private int pricePerCoffee = 5;

    // The price of the user's order
    private int totalOrderPrice = 0;

    // Reference to the quantity text object
    private TextView quantityText;

    // Reference to the price text object
    private TextView priceText;

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the quantity text object
        quantityText = (TextView) findViewById(R.id.quantityText);

        // Reference to the price text object
        priceText = (TextView) findViewById(R.id.priceText);
    }

    // Submit an order
    public void submitOrder(View view)
    {
        // Calculate the price
        calcalulatePrice();
    }

    // Increase the order amount
    public void increaseOrderAmount(View view)
    {
        // Increase the ordered coffee amount
        orderedCoffeeAmount++;

        // Display the quantity amount
        displayQuantityAmount(orderedCoffeeAmount);
    }

    // Decrease the order amount
    public void decreaseOrderAmount(View view)
    {
        // If the ordered coffee amount is greater than 0 then decrease the ordered coffee amount
        if (orderedCoffeeAmount > 0)
        {
            orderedCoffeeAmount--;

            // Display the quantity amount
            displayQuantityAmount(orderedCoffeeAmount);
        }
    }

    // Calculate the price
    private void calcalulatePrice()
    {
        // To get the total price take the number of coffee items ordered and multiply the by the pricePerCoffee value
        totalOrderPrice = orderedCoffeeAmount * pricePerCoffee;

        // Display the price
        displayPrice(totalOrderPrice);
    }


    // Display the quantity amount
    private void displayQuantityAmount(int amount)
    {
        // Convert the given amount to string
        String newTextChar = Integer.toString(amount);

        // Set the text for the quantity text
        quantityText.setText(newTextChar);
    }

    // Display the price
    private void displayPrice(int num)
    {
        // Convert the given number to string
        String newPriceChar = Integer.toString(num);

        // Set the text for the priceText
        priceText.setText("$" + newPriceChar + ".00");
    }
}
