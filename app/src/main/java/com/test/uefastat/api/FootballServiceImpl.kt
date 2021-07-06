package com.test.uefastat.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.uefastat.adapter.StatisticJsonAdapter
import com.test.uefastat.model.Statistic
import com.test.uefastat.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FootballServiceImpl {
    fun provideFootballService(): FootballService {
        val client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val original: Request = chain.request()

                val request: Request = original.newBuilder()
                    .header("X-Auth-Token", "e8c7c58102804a96b47f61891d97fa7c")
                    .build()

                return chain.proceed(request)
            }
        }).build()

        val gson: Gson = GsonBuilder()
            .registerTypeAdapter(Statistic::class.java, StatisticJsonAdapter())
            .create()

        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.FOOTBALL_BASE_URL)
            .build()

        return retrofit.create(FootballService::class.java)
    }
}