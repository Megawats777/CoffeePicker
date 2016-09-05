package com.megawats.coffeepicker;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// The order summary screen
public class OrderSummary extends AppCompatActivity {

    // Create the class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        // Set the title for the activity
        setTitle("Order Summary");
    }

    // Go to the order complete activity
    public void openOrderCompleteActivity(View view)
    {
        // Get the activity
        Intent intent = new Intent(this, OrderComplete.class);

        // Open the activity
        startActivity(intent);
    }

}
