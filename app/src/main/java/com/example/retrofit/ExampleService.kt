package com.example.retrofit

import android.provider.ContactsContract
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ExampleService {
    //在GET注解的接口地址当中，这里使用了一个{page}的占位符
    @GET("{page}/get_data.json")
    //然后又在getData方法中添加page参数，并使用Path注解来声明这个参数
    //这样当retrofit发起请求的时候，会自动替换这个参数
    fun getDta(@Path("page")page:Int): Call<App>



    //DELETE http://example.com/data/<id>
    //服务器提供了这种接口:意味着要根据id删除一条指定的数据，而我们在Retrofit当中就可以这么些
    @DELETE("data/{id}")
    fun deleteData(@Path("id")id:String):Call<ResponseBody>
    //因为这不是GET请求，删除服务器上的一条数据，我们并不在乎数据怎么样
    //这个时候使用ResponseBody表示Retrofit可以接收任意类型的响应数据


    //提交数据
    //POST http://example.com/data/create{"id":1,"content":"The description for this data."}
    @POST("data/create")
    fun createData(@Body data: ContactsContract.Contacts.Data):Call<ResponseBody>
    //这里在createData中声明一个Data类型的参数，并加上@Body注解
    //这样当Retrofit发出POST请求时，就会自动将Data对象中的数据转换成JSON格式的文本，并放到HTTP请求的body部分
    //同样的写法也可以用来给PUT，PATCH，DELETE类型的请求提交数据
}