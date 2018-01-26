package com.teng.zhihu.adapter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by teng on 18/1/26.
 */
abstract class SimpleCallback<T> : Callback<T> {

    override fun onResponse(call: Call<T>?, response: Response<T>?) = if (response!!.isSuccessful){
        onResponse(response.body(), response.code(), response.message())
    }else{
        onResponseFail()
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) = Unit

    abstract fun onResponse(result:T, code:Int, msg:String)

    fun onResponseFail() = Unit
}