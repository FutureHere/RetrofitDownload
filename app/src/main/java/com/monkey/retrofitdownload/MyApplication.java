package com.monkey.retrofitdownload;

import android.app.Application;

import com.hly.easyretrofit.retrofit.NetWorkRequest;

/**
 * Created by hly on 2016/11/4.
 * email hly910206@gmail.com
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkRequest.getInstance().init(this, "http://test.kuaikuaikeji.com/kas/");
    }
}
