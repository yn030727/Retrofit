package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExampleService2 {
    @GET("get_data.json")
    fun getData(@Query("u")user:String ,@Query("t")token:String): Call<App>
    //getData方法中添加了两个参数user和token（他们都被Query注解修饰）
    //当发起网络请求的时候，Retrofit就会自动按照带参数GET请求的格式将在这两个参数构建到请求地址当中
}