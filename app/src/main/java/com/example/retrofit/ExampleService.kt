package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ExampleService {
    //在GET注解的接口地址当中，这里使用了一个{page}的占位符
    @GET("{page}/get_data.json")
    //然后又在getData方法中添加page参数，并使用Path注解来声明这个参数
    //这样当retrofit发起请求的时候，会自动替换这个参数
    fun getDta(@Path("page")page:Int): Call<App>
}