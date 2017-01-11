package com.example.dhruvishah.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by DhruviShah on 26-12-2016.
 */

public class PreferenceUtils {

    private static final String PREFERENCE_KEY = "android_";
    private static final String PREFERENCES_NAME = "GOTSKILLS";
    private static final String EMAIL = "EMAIL_KEY";
    private static final String IS_REGISTERED = "IsRegistered";
    private static void putString(Context context , String key, String value){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    private static String getString(Context context,String key){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return mSharedPreferences.getString(key, "");
    }
    private static void putBoolean(Context context , String key, Boolean value){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    private static Boolean getBoolean(Context context,String key){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return mSharedPreferences.getBoolean(key, false);
    }

    public static void setEmail(Context context,String email){
        putString(context,EMAIL,email);
    }
    public static String getEmail(Context context){
        return  getString(context,EMAIL);
    }

    public static void setIsRegistered(Context context,Boolean isRegistered){
        putBoolean(context,IS_REGISTERED,isRegistered);
    }
    public static Boolean isRegistered(Context context){
        return  getBoolean(context,IS_REGISTERED);
    }
}
