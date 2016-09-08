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

        // Set the title for the activity
        setTitle("Order Complete");

    }

    // Open the home screen
    public void openHomeScreen(View view)
    {
        // Get the Order items activity
        Intent intent = new Intent(this, MainActivity.class);

        // Open the activity
        startActivity(intent);

        // Destroy this activity
        finish();
    }
}
