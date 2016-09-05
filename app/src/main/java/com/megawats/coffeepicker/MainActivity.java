package com.megawats.coffeepicker;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Displays the screen to order coffee
public class MainActivity extends AppCompatActivity {

    // The background of the checkout button
    RelativeLayout checkoutButtonBackground;

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the background of the checkout button
        checkoutButtonBackground  = (RelativeLayout) findViewById(R.id.checkoutButtonBackground);

        // Set the opacity of the checkout button background
        checkoutButtonBackground.getBackground().setAlpha(150);

        // Set the title for the activity
        setTitle("Order Items");
    }
}
