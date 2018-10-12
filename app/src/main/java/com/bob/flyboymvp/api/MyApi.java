package com.bob.flyboymvp.api;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * @创建者 CSDN_LQR
 * @描述 server端api
 */

public interface MyApi {

    public static final String BASE_URL = "http://121.43.233.185/mavenwitlinkweb/";


    //登录
    @POST("userprivate/login.do")
    Observable<ResponseBody> login(@Body RequestBody body);

    //获取个人信息
    @POST("userprivate/retrieveall.do")
    Observable<ResponseBody> userAllInfo(@Body RequestBody body);

    //云录登录
    @POST("epuser/retrieveuser.do")
    Observable<ResponseBody> cloudLogin(@Body RequestBody body);


    //下载图片
    @GET
    Observable<ResponseBody> downloadPic(@Url String url);

    //获取树形列表数据
    @POST("tree/retrieve.do")
    Observable<ResponseBody> treeData(@Body RequestBody body);

}
