package com.teng.zhihu.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.teng.zhihu.R
import com.teng.zhihu.Utils
import com.teng.zhihu.api.ZhihuApi
import com.teng.zhihu.bean.UserEntity
import com.teng.zhihu.databinding.PeopleInfoBinding
import kotlinx.android.synthetic.main.people_info.view.*
/**
 * Created by teng on 18/1/23.
 */
class PeopleListAdapter(private var context: Context, var data: MutableList<UserEntity>) : RecyclerView.Adapter<PeopleListAdapter.PeopleViewHolder>() {


    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PeopleViewHolder{
        val binding = DataBindingUtil.inflate<PeopleInfoBinding>(LayoutInflater.from(context), R.layout.people_info, parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder?, position: Int) {
        val userEntity = data[position]
        holder!!.binding!!.user = userEntity
        val picUrl:String  = Utils.getAuthorAvatarUrl(userEntity.avatarTemplate,
        userEntity.avatarId, ZhihuApi.PIC_SIZE_XL)
        Glide.with(context).load(picUrl).crossFade().into(holder.itemView.avatar)
        holder.itemView.avatar.setTag(R.id.key_slug, userEntity.slug)
        holder.itemView.avatar.setTag(R.id.key_name, userEntity.zhuanlanName)
    }

    inner class PeopleViewHolder(binding: ViewDataBinding) :RecyclerView.ViewHolder(binding.root){
        var binding : PeopleInfoBinding? = null
        init {
            this.binding = binding as PeopleInfoBinding
        }
    }

}