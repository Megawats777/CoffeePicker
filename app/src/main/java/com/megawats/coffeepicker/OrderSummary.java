package com.megawats.coffeepicker;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

// The order summary screen
public class OrderSummary extends AppCompatActivity {

    /*--Item quantity text objects--*/
    private TextView blackCoffeeAmountText;
    private TextView icedCoffeeAmountText;
    private TextView waterAmountText;
    private TextView orangeJuiceAmountText;

    /*--Total Order price text object--*/
    private TextView totalOrderPriceText;

    /*--Total item price text objects--*/
    private TextView blackCoffeeTotalPriceText;
    private TextView icedCoffeeTotalPriceText;
    private TextView waterTotalPriceText;
    private TextView orangeJuicePriceText;

    /*--Item display groups--*/
    private LinearLayout blackCoffeeDisplayGroup;
    private LinearLayout icedCoffeeDisplayGroup;
    private LinearLayout waterDisplayGroup;
    private LinearLayout orangeJuiceDisplayGroup;

    /*--Delivery time text object*/
    private TextView deliveryTimeText;

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        // Store this activity
        ActivityManager.orderSummary = this;

        // Get the item display groups
        blackCoffeeDisplayGroup = (LinearLayout) findViewById(R.id.blackCoffeeGroup);
        icedCoffeeDisplayGroup = (LinearLayout) findViewById(R.id.icedCoffeeGroup);
        waterDisplayGroup = (LinearLayout) findViewById(R.id.waterGroup);
        orangeJuiceDisplayGroup = (LinearLayout) findViewById(R.id.orangeJuiceGroup);

        // Get the item quantity text objects
        blackCoffeeAmountText = (TextView) findViewById(R.id.blackCoffeeAmountText);
        icedCoffeeAmountText = (TextView) findViewById(R.id.icedCoffeeAmountText);
        waterAmountText = (TextView) findViewById(R.id.waterAmountText);
        orangeJuiceAmountText = (TextView) findViewById(R.id.orangeJuiceAmountText);

        // Get the total item price text objects
        blackCoffeeTotalPriceText = (TextView) findViewById(R.id.blackCoffeeTotalPriceText);
        icedCoffeeTotalPriceText = (TextView) findViewById(R.id.icedCoffeeTotalPriceText);
        waterTotalPriceText = (TextView) findViewById(R.id.waterTotalPriceText);
        orangeJuicePriceText = (TextView) findViewById(R.id.orangeJuiceTotalPriceText);

        // Get the total order price text object
        totalOrderPriceText = (TextView) findViewById(R.id.totalOrderPriceText);

        // Get the delivery time text object
        deliveryTimeText = (TextView) findViewById(R.id.deliveryTimeText);

        // Display the item quantity
        displayItemQuantity();

        // Display total item price
        displayTotalItemPrice();

        // Display the delivery time
        displayDeliveryTime();

        // Set the title for the activity
        setTitle("Order Summary");
    }

    // Display the item quantity
    private void displayItemQuantity()
    {
        // The string version of the item amounts
        String blackCoffeeAmountStr = Integer.toString(OrderInfo.blackCoffeeOrderAmount);
        String icedCoffeeAmountStr = Integer.toString(OrderInfo.icedCoffeeOrderAmount);
        String waterAmountStr = Integer.toString(OrderInfo.waterOrderAmount);
        String orangeJuiceAmountStr = Integer.toString(OrderInfo.orangeJuiceOrderAmount);

        // Set the values of the item quantity text objects
        blackCoffeeAmountText.setText("x" + blackCoffeeAmountStr);
        icedCoffeeAmountText.setText("x" + icedCoffeeAmountStr);
        waterAmountText.setText("x" + waterAmountStr);
        orangeJuiceAmountText.setText("x" + orangeJuiceAmountStr);
    }

    // Display total item price
    private void displayTotalItemPrice()
    {
        // The string version of the total order price
        String totalOrderPriceStr = Integer.toString(OrderInfo.totalOrderPrice);

        // The string versions of the total item prices
        String blackCoffeeOrderPriceStr = Integer.toString(OrderInfo.totalBlackCoffeePrice);
        String icedCoffeeOrderPriceStr = Integer.toString(OrderInfo.totalIcedCoffeePrice);
        String waterOrderPriceStr = Integer.toString(OrderInfo.totalWaterPrice);
        String orangeJuiceOrderPriceStr = Integer.toString(OrderInfo.totalOrangeJuicePrice);

        // Set the value of the total order price text object
        totalOrderPriceText.setText("$" + totalOrderPriceStr + ".00");

        // Set the values of the total item price text objects
        blackCoffeeTotalPriceText.setText("$" + blackCoffeeOrderPriceStr + ".00");
        icedCoffeeTotalPriceText.setText("$" + icedCoffeeOrderPriceStr+ ".00");
        waterTotalPriceText.setText("$" + waterOrderPriceStr + ".00");
        orangeJuicePriceText.setText("$" + orangeJuiceOrderPriceStr + ".00");
    }

    // Display the delivery time
    private void displayDeliveryTime()
    {
        // The string version of the delivery time
        String deliveryTimeStr = Integer.toString(OrderInfo.deliveryTime);

        // If the total order amount is greater than 1 show the delivery time
        if (OrderInfo.totalOrderAmount > 1)
        {
            // Set the value of the delivery time text
            deliveryTimeText.setText(deliveryTimeStr + " Seconds");

        }

        // Show the delivery time with "Second" if the total order amount is 1
        else if (OrderInfo.totalOrderAmount == 1)
        {
            // Set the value of the delivery time text
            deliveryTimeText.setText(deliveryTimeStr + " Second");
        }

        // If the total order amount is 0 show a warning message
        else if (OrderInfo.totalOrderAmount == 0)
        {
            // Set the value of the delivery time text
            deliveryTimeText.setText("NO ORDERED ITEMS");
        }
    }

    // Open the order complete activity
    public void openOrderComplete(View view)
    {
        // Mark that the user has accepted the order
        OrderInfo.hasAcceptedOrder = true;

        // Generate a random order number
        OrderInfo.generateOrderNumber();

        // Get the activity
        Intent intent = new Intent(this, OrderComplete.class);

        // Open the activity
        startActivity(intent);
    }
}
