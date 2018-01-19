package com.teng.zhihu.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {

    open var mToolBar : Toolbar? = null

    private fun initToolBar(){
        setSupportActionBar(mToolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initToolBar()
    }

    protected fun setTitle(title : String){
        supportActionBar!!.setTitle(title)
    }


}
