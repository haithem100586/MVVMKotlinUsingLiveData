package com.android.mvvmkotlinusinglivedata.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.android.mvvmkotlinusinglivedata.remote.RetroClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel
{

    var username = ObservableField("")
    var userpass = ObservableField("")
    var resultdata = MutableLiveData<String>()

    constructor() : super()


    fun loginCall(usernameP:String, userpassP:String)
    {
        var result:String = ""
        username.set(usernameP)
        userpass.set(userpassP)

        val apiService = RetroClass().getAPIInstance()
        val logincall = apiService.userLogin(usernameP,userpassP)

        logincall.enqueue(object : Callback<String> {

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                println("aaaaaaaaaaa0:"+response!!.body())
                result = response!!.body()
                resultdata.value = result
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                println("aaaaaaaaaaa1:"+t!!.message.toString())
            }

        })

       /* if ( username.get().equals("haithem")
            && userpass.get().equals("haithem") )
        {
            result = "Access"
        }else{
            result = "Denied"
        }*/

    }



    fun getResultLogin():MutableLiveData<String>
    {
        return resultdata
    }




}