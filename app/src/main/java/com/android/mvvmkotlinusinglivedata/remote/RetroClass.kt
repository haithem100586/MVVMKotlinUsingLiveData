package com.android.mvvmkotlinusinglivedata.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroClass
{

    private val BASE_URL = "http://172.20.10.3:8888";

    private fun getRetroInstance():Retrofit
    {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create(gson)).build()
    }

    fun getAPIInstance():APIService
    {
        return getRetroInstance().create(APIService::class.java)
    }

}