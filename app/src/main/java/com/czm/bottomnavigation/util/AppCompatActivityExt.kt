package com.czm.bottomnavigation.util

import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.czm.bottomnavigation.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

fun AppCompatActivity.setUpNavigation(drawer_layout: DrawerLayout) {
    val toggle = ActionBarDrawerToggle(
        this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
    )
    toggle.syncState()
    drawer_layout.addDrawerListener(object : DrawerLayout.DrawerListener {
        override fun onDrawerStateChanged(p0: Int) {
        }

        override fun onDrawerClosed(p0: View) {
        }

        override fun onDrawerOpened(p0: View) {
        }

        override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            //滑动过程中不断回调 slideOffset:0~1
            val content = drawer_layout.getChildAt(0)
            content.translationX = drawerView.measuredWidth * slideOffset
        }
    })
}