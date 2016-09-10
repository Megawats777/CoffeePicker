package com.megawats.coffeepicker;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        // Store this activity
        ActivityManager.mainActivity = this;

        // If the order complete activity exists close it
        if (ActivityManager.orderComplete != null)
        {
            ActivityManager.orderComplete.finish();
        }

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

        // Display the orderamounts
        displayOrderAmounts(blackCoffeeOrderAmountText, OrderInfo.blackCoffeeOrderAmount);
        displayOrderAmounts(icedCoffeeOrderAmountText, OrderInfo.icedCoffeeOrderAmount);
        displayOrderAmounts(waterOrderAmountText, OrderInfo.waterOrderAmount);
        displayOrderAmounts(orangeJuiceOrderAmountText, OrderInfo.orangeJuiceOrderAmount);
    }

    /*--Black Coffee Functions--*/

    // Decrease the black coffee order amount
    public void decreaseBlackCoffeeOrderAmount(View view)
    {
        // If the black coffee order amount is greater than 0 decrease the amount
        if (OrderInfo.blackCoffeeOrderAmount > 0)
        {
            OrderInfo.blackCoffeeOrderAmount--;

            // Update the blackCoffeeOrderAmountText
            displayOrderAmounts(blackCoffeeOrderAmountText, OrderInfo.blackCoffeeOrderAmount);
        }
    }

    // Increase the black coffee order amount
    public void increaseBlackCoffeeOrderAmount(View view)
    {
        // If the order amount is less than the order item limit
        if (OrderInfo.blackCoffeeOrderAmount < OrderInfo.ordersPerItemLimit)
        {
            OrderInfo.blackCoffeeOrderAmount++;

            // Update the blackCoffeeOrderAmountText
            displayOrderAmounts(blackCoffeeOrderAmountText, OrderInfo.blackCoffeeOrderAmount);
        }
    }

    /*--Iced Coffee Functions--*/

    // Decrease the iced coffee order amount
    public void decreaseIcedCoffeeOrderAmount(View view)
    {
        // If the order amount is greater than 0 decrease the order amount
        if (OrderInfo.icedCoffeeOrderAmount > 0)
        {
            OrderInfo.icedCoffeeOrderAmount--;

            // Display the order amount
            displayOrderAmounts(icedCoffeeOrderAmountText, OrderInfo.icedCoffeeOrderAmount);
        }
    }

    // Increase the iced coffee order amount
    public void increaseIcedCoffeeOrderAmount(View view)
    {
        // If the order amount is less than the order item limit increase the order amount
        if (OrderInfo.icedCoffeeOrderAmount < OrderInfo.ordersPerItemLimit)
        {
            OrderInfo.icedCoffeeOrderAmount++;

            // Display the order amount
            displayOrderAmounts(icedCoffeeOrderAmountText, OrderInfo.icedCoffeeOrderAmount);
        }
    }

    /*--Water Functions--*/

    // Decrease the water order amount
    public void decreaseWaterOrderAmount(View view)
    {
        // If the order amount is greater than 0 decrease the order amount
        if (OrderInfo.waterOrderAmount > 0)
        {
            OrderInfo.waterOrderAmount--;

            // Display the order amount
            displayOrderAmounts(waterOrderAmountText, OrderInfo.waterOrderAmount);
        }
    }

    // Increase the water order amount
    public void increaseWaterOrderAmount(View view)
    {
        // If the order amount is less than the order item limit increase the order amount
        if (OrderInfo.waterOrderAmount < OrderInfo.ordersPerItemLimit)
        {
            OrderInfo.waterOrderAmount++;

            // Display the order amount
            displayOrderAmounts(waterOrderAmountText, OrderInfo.waterOrderAmount);
        }
    }


    /*--Orange Juice Functions--*/

    // Decrease the orange juice order amount
    public void decreaseOrangeJuiceOrderAmount(View view)
    {
        // If the order amount is greater than 0 decrease the order amount
        if (OrderInfo.orangeJuiceOrderAmount > 0)
        {
            OrderInfo.orangeJuiceOrderAmount--;

            // Display the order amount
            displayOrderAmounts(orangeJuiceOrderAmountText, OrderInfo.orangeJuiceOrderAmount);
        }
    }

    // Increase the orange juice order amount
    public void increaseOrangeJuiceOrderAmount(View view)
    {
        // If the order amount is less than the order item limit increase the order amount
        if (OrderInfo.orangeJuiceOrderAmount < OrderInfo.ordersPerItemLimit)
        {
            OrderInfo.orangeJuiceOrderAmount++;

            // Display the order amount
            displayOrderAmounts(orangeJuiceOrderAmountText, OrderInfo.orangeJuiceOrderAmount);
        }
    }

    // Display order amounts
    private void displayOrderAmounts(TextView textView, int amount)
    {
        // Convert the amount to string
        String displayedAmount = Integer.toString(amount);

        // Display the amount
        textView.setText(displayedAmount);
    }

    // Go to the checkout activity
    public void goToCheckout(View view)
    {
        // Calculate the total prices
        OrderInfo.calculatePrices();

        // Calculate the total order amount
        OrderInfo.calculateTotalOrderAmount();

        // Calulate the delivery time for the order
        OrderInfo.calculateTotalDeliveryTime();

        // If the total order amount is greater than 0
        if (OrderInfo.totalOrderAmount > 0)
        {
            // Mark that the user has finished selecting an order
            OrderInfo.hasFinishedSelectingItems = true;

            // Get the activity
            Intent intent = new Intent(this, OrderSummary.class);

            // Open the activity
            startActivity(intent);
        }

        // If the total order amount is 0 then show a toast message
        else if (OrderInfo.totalOrderAmount == 0)
        {
            // Get the application context
            Context appContext = getApplicationContext();

            // The message for the toast message
            String toastMessage = "No Items Were Selected";

            // The duration of the toast message
            int toastMessageDuration = Toast.LENGTH_SHORT;

            // Create the toast message
            Toast toast = Toast.makeText(appContext, toastMessage, toastMessageDuration);

            // Set the position of the toast message
            toast.setGravity(Gravity.BOTTOM,0, 220);

            // Show the toast message
            toast.show();
        }
    }
}
