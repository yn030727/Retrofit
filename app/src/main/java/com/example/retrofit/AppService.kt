package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface AppService {
    //这是一条@GET注解，表示当调用getAppData()方法时Retrofit会发起一条GET请求
    //请求的地址就是@GET注解中传入的具体参数(注解属性)
    @GET("get_data.json")
    //getData返回值必须声明成Retrofit中内置的Call类型，通过泛型指定服务器响应应该转换成什么类型
    fun getAppData():Call<List<App>>
}