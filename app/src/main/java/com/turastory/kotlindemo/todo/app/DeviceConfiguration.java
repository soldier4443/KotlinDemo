package com.turastory.kotlindemo.todo.app;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Util class - Extension functions
 */
public class DeviceConfiguration {
    public static boolean isTablet(Context context) {
        boolean xlarge = screenConfig(context) == Configuration.SCREENLAYOUT_SIZE_XLARGE;
        boolean large = screenConfig(context) == Configuration.SCREENLAYOUT_SIZE_LARGE;
        return xlarge || large;
    }
    
    private static int screenConfig(Context context) {
        return config(context).screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
    }
    
    private static Configuration config(Context context) {
        return context.getApplicationContext().getResources().getConfiguration();
    }
}