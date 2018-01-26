package com.teng.zhihu.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.util.ArrayMap
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.teng.zhihu.R
import com.teng.zhihu.adapter.PeopleListAdapter
import com.teng.zhihu.adapter.SimpleCallback
import com.teng.zhihu.api.DataCenter
import com.teng.zhihu.api.ZhihuApi
import com.teng.zhihu.bean.User
import com.teng.zhihu.bean.UserEntity
import kotlinx.android.synthetic.main.common_list.*

/**
 * Created by teng on 18/1/22.
 */
class PeopleListFragment : Fragment() {

    private var mAdapter: PeopleListAdapter? = null

    var data: MutableList<UserEntity> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater!!.inflate(R.layout.common_list, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = PeopleListAdapter(activity , data)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        getUser()
    }

    fun getUser(){

        val ids = activity.resources.getStringArray(R.array.people_ids)
        val map = ArrayMap<String, UserEntity>()
        val list = DataCenter.instance().queryAll(UserEntity::class.java)

        for (entity in list){
            map.put(entity.slug , entity)
        }

        for(id in ids){
            val entity = map[id]
            if (entity != null) {
                data.add(entity)
            }else{
                makeRequest(id)
            }
        }
        mAdapter!!.notifyDataSetChanged()
    }

    private fun makeRequest(id: String) {
        val api = ZhihuApi.zhuanlanApi
        api.getUser(id).enqueue(object : SimpleCallback<User>() {
            override fun onResponse(user: User, code: Int, msg: String) {
                data.add(user.toUserEntity())
                mAdapter!!.notifyDataSetChanged()
                DataCenter.instance().save(user.toUserEntity())
            }
        })
    }

}