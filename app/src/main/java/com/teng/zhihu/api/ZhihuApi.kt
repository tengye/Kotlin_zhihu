package com.teng.zhihu.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by teng on 18/1/22.
 */
class ZhihuApi private constructor(){

    private val retrofit : Retrofit ?

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(ZHUAN_LAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {
        public val DEFAULT_COUNT : Int = 10
        public val KEY_POSTS : String = "/posts"
        public val KTY_OFFSET : String = "offset"
        public val KEY_RATING : String = "rating"

        public val ZHUAN_LAN_URL : String = "https://zhuanlan.zhihu.com"
        public val API_BASE : String = ZHUAN_LAN_URL + "/api/columns/%s"

        public val PIC_SIZE_XL : String = "xl"
        public val PIC_SIZE_XS : String = "xs"

        public val TEMPLATE_ID : String = "{id}"
        public val TEMPLATE_SIZE : String = "{size}"


        val zhuanlanApi : Api
            get() = api(Api::class.java)

        fun <T> api(clazz: Class<T>) : T = Inner.instance.retrofit!!.create(clazz)

    }
    private object Inner {
        val instance = ZhihuApi()

    }


}