package com.megawats.coffeepicker;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by jedse on 2016-09-08.
 */

// Manages all the activities in the app
public class ActivityManager
{
    /*--The main activity intent--*/
    public static Activity mainActivity = null;

    /*--The order summary intent--*/
    public static Activity orderSummary = null;

    /*--The order complete intent--*/
    public static Activity orderComplete = null;
}
