package com.udacity.sandwichclub.model;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication mContext;

    //This class is to have a context access in other classes

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = (MyApplication) getApplicationContext();
    }

    public static MyApplication getContext(){
        return mContext;
    }
}
