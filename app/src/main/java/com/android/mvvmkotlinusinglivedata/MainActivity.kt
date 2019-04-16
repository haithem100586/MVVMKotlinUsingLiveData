package com.android.mvvmkotlinusinglivedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.mvvmkotlinusinglivedata.databinding.ActivityMainBinding
import com.android.mvvmkotlinusinglivedata.presenter.Presenter
import com.android.mvvmkotlinusinglivedata.viewmodel.LoginViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var activityMainBinding:ActivityMainBinding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //Kotlin : LoginViewModel::class.java vs Java : LoginViewModel.class
        var viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        activityMainBinding.loginmodel = viewModel
        activityMainBinding.setLifecycleOwner(this)

        viewModel.getResultLogin().observe(this, Observer {

            showToast(""+it)

        })



        activityMainBinding!!.presenter = object : Presenter {
            override fun logIn() {
                var name :String = activityMainBinding.usernametxt.text.toString()
                var pass :String = activityMainBinding.userpasstxt.text.toString()

                viewModel.loginCall(name,pass)
            }
        }

    }




    fun showToast(msg:String)
    {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show()
    }
}
