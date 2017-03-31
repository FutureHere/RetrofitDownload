package com.monkey.retrofitdownload;

import android.app.Application;

import com.monkey.retrofitdownload.net.ApiManager;

/**
 * Created by hly on 2016/11/4.
 * email hly910206@gmail.com
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiManager.getInstance().init(this);
    }
}
