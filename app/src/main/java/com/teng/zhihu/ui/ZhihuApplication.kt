package com.teng.zhihu.ui

import android.app.Application
import com.teng.zhihu.api.DataCenter

/**
 * Created by teng on 18/1/26.
 */
class ZhihuApplication : Application() {

    companion object {
        val mContext : ZhihuApplication
        get() = ZhihuApplication()
    }

    override fun onCreate() {
        super.onCreate()
        DataCenter.init(this, "zhuanlan.db")
    }
}