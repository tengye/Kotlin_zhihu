package com.teng.zhihu.ui

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import com.teng.zhihu.R
import com.teng.zhihu.adapter.MenuAdapter
import com.teng.zhihu.bean.DrawerMenuContent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private var actionBarDrawerToggle : ActionBarDrawerToggle? = null
    override var mToolBar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mToolBar = toolBar

        val content = DrawerMenuContent(this)
        drawerList.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
        drawerList.adapter = MenuAdapter(this, content.items)

        initToolBarAndDrawer()
    }

    private fun initToolBarAndDrawer(){
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, mToolBar, R.string.app_name, R.string.app_name)
        drawerLayout.addDrawerListener(actionBarDrawerToggle!!)
        mToolBar!!.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.action_settings -> {
                    Toast.makeText(applicationContext, "No Content", Toast.LENGTH_SHORT).show()
                }
                R.id.action_about -> {
                    Toast.makeText(applicationContext, "No Content", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle!!.syncState()
        mToolBar!!.setNavigationOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                closeDrawer()
            }else{
                openDrawer()
            }
        }
    }

    private fun closeDrawer() : Boolean {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START)
            return true
        }
        return false
    }

    private fun openDrawer() : Boolean {
        if (drawerLayout != null){
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }
        return false
    }
}
