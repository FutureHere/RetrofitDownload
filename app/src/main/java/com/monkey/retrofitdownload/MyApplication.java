package com.monkey.retrofitdownload;

import android.app.Application;

import com.hly.easyretrofit.retrofit.KKNetWorkRequest;

/**
 * Created by hly on 2016/11/4.
 * email hly910206@gmail.com
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        KKNetWorkRequest.getInstance().init(this, "http://test.kuaikuaikeji.com/kas/");
    }
}
