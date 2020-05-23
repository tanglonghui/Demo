package com.example.administrator.demo.open_source_framework.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2019/5/5.
 */

public class Api {
    interface TestApi{
        @GET("/test/")
        Call<String> TestApi(@QueryMap Map<String,String> map);
    }
}
