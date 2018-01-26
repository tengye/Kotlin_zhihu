package com.teng.zhihu.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.teng.zhihu.R
import com.teng.zhihu.bean.DrawerMenuContent
import kotlinx.android.synthetic.main.layout_menu_item.view.*

/**
 * Created by teng on 18/1/19.
 */
class MenuAdapter(private var context: Context?, val data: MutableList<DrawerMenuContent.DrawerItem>?) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MenuViewHolder
            = MenuViewHolder(View.inflate(context, R.layout.layout_menu_item, null))


    override fun onBindViewHolder(holder: MenuViewHolder?, position: Int) {
        val item = data!![position]
        holder!!.itemView.iv_menu_icon.setImageResource(item.icon)
        holder.itemView.tv_menu_item.text = item.title
    }

    override fun getItemCount(): Int = data!!.size

    inner class MenuViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

}