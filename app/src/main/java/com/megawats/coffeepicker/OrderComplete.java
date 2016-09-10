package com.megawats.coffeepicker;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// The order complete activity
public class OrderComplete extends AppCompatActivity {

    /*--The delivery time text--*/
    private TextView deliveryTimeText;

    /*--The order number text--*/
    private TextView orderNumberText;

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        // Store this activity
        ActivityManager.orderComplete = this;

        // Set the title for the activity
        setTitle("Order Complete");

        // Get the delivery time text
        deliveryTimeText = (TextView) findViewById(R.id.orderCompleteDeliveryTimeText);

        // Get the order number text
        orderNumberText = (TextView) findViewById(R.id.orderNumberText);

        // Display the delivery time
        displayDeliveryTime();

        // Display the order number
        displayOrderNumber();
    }

    // When the user presses back
    @Override
    public void onBackPressed()
    {
        // Do nothing
    }

    // Display the delivery time
    private void displayDeliveryTime()
    {
        // The string version of the delivery time
        String deliveryTimeStr = Integer.toString(OrderInfo.deliveryTime);

        // Set the value of the delivery time text
        deliveryTimeText.setText(deliveryTimeStr + " Seconds");
    }

    // Display the order number
    private void displayOrderNumber()
    {
        // The string version of the order number
        String orderNumberStr = Integer.toString(OrderInfo.orderNumber);

        // Set the value of the order number text
        orderNumberText.setText(orderNumberStr);
    }

    // Open the home screen
    public void openHomeScreen(View view)
    {
        // Mark that the user has not finished selecting items and has not accepted the order
        OrderInfo.hasFinishedSelectingItems = false;
        OrderInfo.hasAcceptedOrder = false;

        // Reset the order amounts
        OrderInfo.resetOrderAmounts();

        // Close the main activity
        ActivityManager.mainActivity.finish();

        // Close the order summary activity
        ActivityManager.orderSummary.finish();

        // Get the Order items activity
        Intent intent = new Intent(this, MainActivity.class);

        // Open the activity
        startActivity(intent);
    }
}
