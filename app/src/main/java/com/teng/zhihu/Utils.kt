package com.teng.zhihu

import com.teng.zhihu.api.ZhihuApi

/**
 * Created by teng on 18/1/26.
 */
object Utils  {
    // 单例用object

    fun getAuthorAvatarUrl(origin: String, userId: String, size: String): String {
        var origin = origin
        origin = origin.replace(ZhihuApi.TEMPLATE_ID, userId)
        return origin.replace(ZhihuApi.TEMPLATE_SIZE, size)
    }
}