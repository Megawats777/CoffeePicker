package com.megawats.coffeepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

// Displays the screen to order coffee
public class MainActivity extends AppCompatActivity {

    // Opacity of the black coffee and iced coffee backgrounds
    private int quantityBackgroundOpacity = 200;

    // Reference to the black coffee and iced coffee backgrounds
    private LinearLayout blackCoffeeAmountBackground;
    private LinearLayout icedCoffeeAmountBackground;

    // Create the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the black coffee and iced coffee backgrounds
        blackCoffeeAmountBackground = (LinearLayout) findViewById(R.id.blackCoffeeAmountBackground);
        icedCoffeeAmountBackground = (LinearLayout) findViewById(R.id.icedCoffeeAmountBackground);

        // Set the opacity of the black coffee and iced coffee backgrounds
        blackCoffeeAmountBackground.getBackground().setAlpha(quantityBackgroundOpacity);
        icedCoffeeAmountBackground.getBackground().setAlpha(quantityBackgroundOpacity);
    }



}
