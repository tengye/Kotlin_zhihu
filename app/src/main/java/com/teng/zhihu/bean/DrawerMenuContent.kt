package com.teng.zhihu.bean

import android.content.Context
import android.support.annotation.DrawableRes
import com.teng.zhihu.R

/**
 * Created by teng on 18/1/18.
 */
class DrawerMenuContent (context : Context){

    val items: MutableList<DrawerItem>
    private val activities: MutableList<Class<*>>

    companion object {
        // 类似java的static
        private val DRAWER_MENU_COUNT : Int = 3
        private val FIELD_TITLE = "title"
        private val FIELD_ICON = "icon"
    }

    init {
        activities = ArrayList(DRAWER_MENU_COUNT)
        items = ArrayList(DRAWER_MENU_COUNT)

//        activities[0] = SearchActivity::class.java
        items.add(DrawerItem(R.id.menu_search,"搜索",
                R.drawable.ic_search_black_18dp))

    }

    class DrawerItem (var id:Int, var title:String, @param:DrawableRes var icon:Int)
}