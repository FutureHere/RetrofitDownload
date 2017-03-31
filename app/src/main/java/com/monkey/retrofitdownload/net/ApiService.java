package com.monkey.retrofitdownload.net;

import com.monkey.retrofitdownload.entity.ResponseLoginEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hly on 16/3/30.
 * email hugh_hly@sina.cn
 */
public interface ApiService {
    @GET(URLHandler.LOGIN)
    Call<ResponseLoginEntity> login();

}
