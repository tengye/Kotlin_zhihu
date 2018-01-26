package com.teng.zhihu.api

import com.teng.zhihu.bean.Post
import com.teng.zhihu.bean.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by teng on 18/1/26.
 */
interface Api {
    companion object {
        const val KEY_LIMIT = "limit"
        const val KEY_OFFSET = "offset"
    }

    @GET("/api/columns/{id}/posts")
    abstract fun getPosts(@Path("id") id: String, @Query(KEY_LIMIT) limit: Int, @Query(KEY_OFFSET) offset: Int): Call<List<Post>>

    @GET("/api/columns/{id}")
    abstract fun getUser(@Path("id") id: String): Call<User>

}