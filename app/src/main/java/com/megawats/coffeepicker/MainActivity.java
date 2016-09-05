package com.megawats.coffeepicker;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

// Displays the screen to order coffee
public class MainActivity extends AppCompatActivity {

    // The number of black coffee items ordered
    private int orderedBlackCoffeeAmount = 0;

    // The number of iced coffee items ordered
    private int orderedIcedCoffeeAmount = 0;

    // The price of each individual black coffee item
    private int blackCoffeeItemPrice = 5;

    // The price of each individual iced coffee
    private int icedCoffeeItemPrice = 1;

    // The total price of the order
    private int totalOrderPrice = 0;

    // Opacity of the black coffee and iced coffee backgrounds
    private int quantityBackgroundOpacity = 200;

    // Reference to the black coffee and iced coffee backgrounds
    private LinearLayout blackCoffeeAmountBackground;
    private LinearLayout icedCoffeeAmountBackground;

    // Reference to the black coffee and iced coffee amount text objects
    private TextView blackCoffeeAmountText;
    private TextView icedCoffeeAmountText;

    // Get the order pice text object
    private TextView orderPriceText;

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the title for the activity
        setTitle("Order Items");

        // Get to the black coffee and iced coffee amount text objects
        blackCoffeeAmountText = (TextView) findViewById(R.id.blackCoffeeAmountText);
        icedCoffeeAmountText = (TextView) findViewById(R.id.icedCoffeeAmountText);

        // Get the order pice text object
        orderPriceText = (TextView) findViewById(R.id.priceText);

        // Get the black coffee and iced coffee backgrounds
        blackCoffeeAmountBackground = (LinearLayout) findViewById(R.id.blackCoffeeAmountBackground);
        icedCoffeeAmountBackground = (LinearLayout) findViewById(R.id.icedCoffeeAmountBackground);

        // Set the opacity of the black coffee and iced coffee backgrounds
        blackCoffeeAmountBackground.getBackground().setAlpha(quantityBackgroundOpacity);
        icedCoffeeAmountBackground.getBackground().setAlpha(quantityBackgroundOpacity);
    }

    /*--Black Coffee amount functions--*/

    // Decrease the black coffee amount
    public void decreaseBlackCoffeeAmount(View view)
    {
        // If the number of black coffee is greater than 0 then decrease the amount of black coffee
        if (orderedBlackCoffeeAmount > 0)
        {
            orderedBlackCoffeeAmount--;

            // Display the coffee amount
            displayCoffeeAmount(blackCoffeeAmountText, orderedBlackCoffeeAmount);

            // Calculate the total price
            calculateTotalPrice();
        }
    }

    // Increase the black coffee amount
    public void increaseBlackCoffeeAmount(View view)
    {
        orderedBlackCoffeeAmount++;

        // Display the coffee amount
        displayCoffeeAmount(blackCoffeeAmountText, orderedBlackCoffeeAmount);

        // Calculate the total price
        calculateTotalPrice();
    }

    /*--Iced Coffee amount functions--*/

    // Decrease the iced coffee amount
    public void decreaseIcedCoffeeAmount(View view)
    {
        // If the number of iced coffee is greater than 0 then decrease the amount of iced coffee
        if (orderedIcedCoffeeAmount > 0)
        {
            orderedIcedCoffeeAmount--;

            // Display the coffee amount
            displayCoffeeAmount(icedCoffeeAmountText, orderedIcedCoffeeAmount);

            // Calculate the total price
            calculateTotalPrice();
        }
    }

    // Increase the iced coffee amount
    public void increaseIcedCoffeeAmount(View view)
    {
        orderedIcedCoffeeAmount++;

        // Display the coffee amount
        displayCoffeeAmount(icedCoffeeAmountText, orderedIcedCoffeeAmount);

        // Calculate the total price
        calculateTotalPrice();
    }

    // Display the coffee amount
    private void displayCoffeeAmount(TextView textView,int num)
    {
        // Convert the number to string
        String newCharDisplay = Integer.toString(num);

        textView.setText(newCharDisplay);
    }


    // Calculate the total price
    private void calculateTotalPrice()
    {
        // The total price for all black coffee items ordered
        int blackCoffeeTotalPrice = orderedBlackCoffeeAmount * blackCoffeeItemPrice;

        // The total price for all iced coffee items ordered
        int icedCoffeeTotalPrice = orderedIcedCoffeeAmount * icedCoffeeItemPrice;

        // Add the two prices to make up the total order price
        totalOrderPrice = blackCoffeeTotalPrice + icedCoffeeTotalPrice;

        // Display the total price
        displayTotalPriceText(totalOrderPrice);
    }


    // Display the total price
    private void displayTotalPriceText(int num)
    {
        String displayedPrice = Integer.toString(num);
        orderPriceText.setText("$" + displayedPrice + ".00");
    }


    // Go to checkout screen
    public void goToCheckout(View view)
    {
        // Get the order summary activity
        Intent intent = new Intent(this, OrderSummary.class);

        // Open the activity
        startActivity(intent);
    }

}
