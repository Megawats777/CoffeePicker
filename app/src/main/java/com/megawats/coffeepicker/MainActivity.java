package com.megawats.coffeepicker;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

// Displays the screen to order coffee
public class MainActivity extends AppCompatActivity {

    // The background of the checkout button
    RelativeLayout checkoutButtonBackground;

    /*--Item text views--*/
    private TextView blackCoffeeOrderAmountText;
    private TextView icedCoffeeOrderAmountText;
    private TextView waterOrderAmountText;
    private TextView orangeJuiceOrderAmountText;

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the background of the checkout button
        checkoutButtonBackground  = (RelativeLayout) findViewById(R.id.checkoutButtonBackground);

        // Get the order amount text views
        blackCoffeeOrderAmountText = (TextView) findViewById(R.id.blackCoffeeOrderAmountText);
        icedCoffeeOrderAmountText = (TextView) findViewById(R.id.icedCoffeeOrderAmountText);
        waterOrderAmountText = (TextView) findViewById(R.id.waterOrderAmountText);
        orangeJuiceOrderAmountText = (TextView) findViewById(R.id.orangeJuiceOrderAmountText);

        // Set the opacity of the checkout button background
        checkoutButtonBackground.getBackground().setAlpha(150);

        // Set the title for the activity
        setTitle("Order Items");
    }
}
