package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button =findViewById(R.id.button)
        button.setOnClickListener {
            val retrofit = Retrofit.Builder()
                     //设置根路径
                .baseUrl("http://12.0.2.2/")
                    //设置Retrofit在解析数据时所使用的转换库
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //这里通过create方法创建了这个接口的动态代理对象
            //然后我们就可以随意调用接口中的方法
            val appService = retrofit.create(AppService::class.java)
            //调用getAppData()方法，会返回一个Call<List<App>>对象
            //这时我们在调用一下他的enqueue方法，Retrofit会根据注解中配置的接口地址进行网络请求
            appService.getAppData().enqueue(object : Callback<List<App>>{
                //Retrofit的使用会自动切换线程
                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
                    val list=response.body()
                    if(list!=null){
                        for(app in list){
                            Log.d("MainActivity","id is ${app.id}")
                            Log.d("MainActivity","name is ${app.name}")
                            Log.d("MainActivity","version is ${app.version}")
                        }
                    }
                }

                override fun onFailure(call: Call<List<App>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }
}