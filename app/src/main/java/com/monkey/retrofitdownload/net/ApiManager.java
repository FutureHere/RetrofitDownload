package com.monkey.retrofitdownload.net;

import android.content.Context;

import com.hly.easyretrofit.retrofit.NetWorkRequest;
import com.monkey.retrofitdownload.config.AppConfig;


/**
 * Created by hly on 16/7/27.
 * email hugh_hly@sina.cn
 */
public class ApiManager {
    private ApiService mApiService;

    private ApiManager() {
    }

    private static ApiManager sApiManager;

    public static ApiManager getInstance() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
        }
        return sApiManager;
    }


    public void init(Context context) {
        NetWorkRequest.getInstance().init(context, AppConfig.APP_ROOT_URL);
        mApiService = NetWorkRequest.getInstance().create(ApiService.class);
    }

    public ApiService getApiService() {
        return mApiService;
    }
}
