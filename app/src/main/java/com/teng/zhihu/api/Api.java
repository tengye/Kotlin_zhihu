package com.teng.zhihu.api;

import com.teng.zhihu.bean.Post;
import com.teng.zhihu.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xuebin on 15/12/19.
 */
public interface Api {

    public static final String KEY_LIMIT = "limit";
    public static final String KEY_OFFSET = "offset";

    @GET("/api/columns/{id}/posts")
    Call<List<Post>> getPosts(@Path("id") String id, @Query(KEY_LIMIT) int limit, @Query(KEY_OFFSET) int offset);

    @GET("/api/columns/{id}")
    Call<User> getUser(@Path("id") String id);

}
