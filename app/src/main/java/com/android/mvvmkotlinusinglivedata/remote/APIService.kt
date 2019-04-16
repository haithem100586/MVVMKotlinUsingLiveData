package com.android.mvvmkotlinusinglivedata.remote

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService
{

    @FormUrlEncoded
    @POST("/loginview/logintab.php")

    fun userLogin(@Field("username") username:String, @Field("userpass") userpass:String ) : Call<String>


}