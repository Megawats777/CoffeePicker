package com.megawats.coffeepicker;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// The order complete activity
public class OrderComplete extends AppCompatActivity {

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        // Store this activity
        ActivityManager.orderComplete = this;

        // Set the title for the activity
        setTitle("Order Complete");
    }

    // When the user presses back
    @Override
    public void onBackPressed()
    {

    }

    // Open the home screen
    public void openHomeScreen(View view)
    {
        // Mark that the user has not finished selecting items and has not accepted the order
        OrderInfo.hasFinishedSelectingItems = false;
        OrderInfo.hasAcceptedOrder = false;

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
