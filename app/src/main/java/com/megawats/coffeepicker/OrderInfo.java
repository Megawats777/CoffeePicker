package com.megawats.coffeepicker;

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


    // Reset order amounts
    public static void resetOrderAmounts()
    {
        blackCoffeeOrderAmount = 0;
        icedCoffeeOrderAmount = 0;
        waterOrderAmount = 0;
        orangeJuiceOrderAmount = 0;
    }
}

