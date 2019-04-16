package com.android.mvvmkotlinusinglivedata.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField


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

        if ( username.get().equals("haithem")
            && userpass.get().equals("haithem") )
        {
            result = "Access"
        }else{
            result = "Denied"
        }

        resultdata.value = result

    }



    fun getResultLogin():MutableLiveData<String>
    {
        return resultdata
    }




}