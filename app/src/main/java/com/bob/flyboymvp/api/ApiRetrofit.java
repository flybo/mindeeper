package com.bob.flyboymvp.api;

import com.bob.flyboymvp.api.base.BaseApiRetrofit;
import com.bob.flyboymvp.model.response.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * @创建者 CSDN_LQR
 * @描述 使用Retrofit对网络请求进行配置
 */
public class ApiRetrofit extends BaseApiRetrofit {

    public MyApi mApi;
    public static ApiRetrofit mInstance;

    private ApiRetrofit() {
        super();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //在构造方法中完成对Retrofit接口的初始化
        mApi = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(MyApi.class);
    }

    public static ApiRetrofit getInstance() {
        if (mInstance == null) {
            synchronized (ApiRetrofit.class) {
                if (mInstance == null) {
                    mInstance = new ApiRetrofit();
                }
            }
        }
        return mInstance;
    }

    private RequestBody getRequestBody(Map<String, String> maps) {
        MultipartBody.Builder builder=  new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (String key : maps.keySet()) {
            builder.addFormDataPart(key, maps.get(key));
        }
        RequestBody body=builder.build();
        return body;
    }


    private RequestBody  getRequestBody(Map<String, String> maps, ArrayList<String> files){
        MultipartBody.Builder builder=  new MultipartBody.Builder().setType(MultipartBody.FORM);
        if(maps!=null){
            for (String key : maps.keySet()) {
                builder.addFormDataPart(key, maps.get(key));
            }
        }
        if(files!=null && files.size()>0) {
            files.forEach(s -> {
                File file = new File(s);
                if (file.exists()) {
                    builder.addFormDataPart("image", file.getName(), RequestBody.create(MediaType.parse("image/jpg"), file));
                }
            });

        }
        RequestBody body=builder.build();
        return   body;

    }

    //登录
    public Observable<ResponseBody> login(Map<String, String> maps) {
        return mApi.login(getRequestBody(maps));
    }
    //获取个人信息
    public Observable<ResponseBody> userAllInfo(Map<String, String> maps) {
        return mApi.userAllInfo(getRequestBody(maps));
    }
    //云录登录
    public Observable<ResponseBody> cloudLogin(Map<String, String> maps) {
        return mApi.cloudLogin(getRequestBody(maps));
    }

    //树形列表数据
    public Observable<ResponseBody> treeData(Map<String, String> maps) {
        return mApi.treeData(getRequestBody(maps));
    }

}
