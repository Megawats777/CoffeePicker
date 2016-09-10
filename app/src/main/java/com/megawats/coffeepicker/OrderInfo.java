package com.megawats.coffeepicker;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Random;

/**
 * Created by jedse on 2016-09-05.
 */

// Holds information for the user's order
public class OrderInfo
{
    /*--The total order price--*/
    public static int totalOrderPrice;

    /*--The total price per item order--*/
    public static int totalBlackCoffeePrice = 0;
    public static int totalIcedCoffeePrice = 0;
    public static int totalWaterPrice = 0;
    public static int totalOrangeJuicePrice;

    /*--The Price of the items--*/
    public static int blackCoffeePrice = 5;
    public static int icedCoffeePrice = 2;
    public static int waterPrice = 1;
    public static int orangeJuicePrice = 2;

    /*--The number of orders per item and in total--*/
    public static int totalOrderAmount = 0;
    public static int blackCoffeeOrderAmount = 0;
    public static int icedCoffeeOrderAmount = 0;
    public static int waterOrderAmount = 0;
    public static int orangeJuiceOrderAmount = 0;

    /*--The limit on the amount of orders per item*/
    public static int ordersPerItemLimit = 5;

    /*--The delivery time for the order--*/
    public static int deliveryTime = 0;

    /*--The user's order number--*/
    public static int orderNumber = 0;

    /*--Has the user finished selecting items--*/
    public static boolean hasFinishedSelectingItems = false;

    /*--Has the user accepted the order--*/
    public static boolean hasAcceptedOrder = false;

    // Calculate prices
    public static void calculatePrices()
    {
        // Calculate the total prices per item
        totalBlackCoffeePrice = blackCoffeeOrderAmount * blackCoffeePrice;
        totalIcedCoffeePrice = icedCoffeeOrderAmount * icedCoffeePrice;
        totalWaterPrice = waterOrderAmount * waterPrice;
        totalOrangeJuicePrice = orangeJuiceOrderAmount * orangeJuicePrice;

        // Calculate the total order price
        totalOrderPrice = totalBlackCoffeePrice + totalIcedCoffeePrice + totalWaterPrice + totalOrangeJuicePrice;
    }

    // Calculate total order amount
    public static void calculateTotalOrderAmount()
    {
        totalOrderAmount = blackCoffeeOrderAmount + icedCoffeeOrderAmount + waterOrderAmount + orangeJuiceOrderAmount;
    }

    // Reset order amounts
    public static void resetOrderAmounts()
    {
        blackCoffeeOrderAmount = 0;
        icedCoffeeOrderAmount = 0;
        waterOrderAmount = 0;
        orangeJuiceOrderAmount = 0;
    }

    // Calculate the total delivery time
    public static void calculateTotalDeliveryTime()
    {
        // Set the delivery time the same as the total order amount
       deliveryTime = totalOrderAmount;
    }

    // Generate order number
    public static void generateOrderNumber()
    {
        // The randomizer object
        Random rngGenerator = new Random();

        // Generate a random order number between 1 and 100
        orderNumber = 0 + rngGenerator.nextInt(100);
    }
}

