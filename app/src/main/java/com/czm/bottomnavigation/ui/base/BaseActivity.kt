/*
 * Copyright 2018 Bakumon. https://github.com/Bakumon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.czm.bottomnavigation.ui.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.czm.bottomnavigation.util.StatusBarUtil
import com.czm.bottomnavigation.DefaultSPHelper
import com.czm.bottomnavigation.Injection

/**
 * 1.日间夜间模式
 * 2.沉浸式状态栏
 *
 * @author Bakumon
 * @date 18-1-17
 */
abstract class BaseActivity : AppCompatActivity() {

    init {
        DefaultSPHelper.initTheme()
    }

    /**
     * 子类必须实现，用于创建 view
     *
     * @return 布局文件 Id
     */
    @get:LayoutRes
    protected abstract val layoutId: Int

    /**
     * 是否已经设置了沉浸式状态栏
     */
    private var isSetupImmersive: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        onInitView(savedInstanceState)
    }

    @SuppressLint("MissingSuperCall")
    override fun onSaveInstanceState(outState: Bundle) {
        // 一个不太好的方案
        // 解决 AddRecordActivity 长时间处于后台，被系统回收后，重新打开恢复 AddRecordActivity 后
        // RecordTypeFragment#getType() 方法 view typePage 为空的问题
        // 也就是 RecordTypeFragment getView 为空
    }

    /**
     * 初始化 view
     * 比 onInit 早执行
     *
     * @param savedInstanceState 保存的 Bundle
     */
    protected abstract fun onInitView(savedInstanceState: Bundle?)

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        onInit(savedInstanceState)
    }

    /**
     * 初始化
     */
    protected abstract fun onInit(savedInstanceState: Bundle?)

    /**
     * 设置沉浸式状态栏
     */
    private fun setImmersiveStatus() {
        val views = setImmersiveView()
        if (views.isEmpty()) {
            return
        }
        StatusBarUtil.immersive(this)
        if (isChangeStatusColor() && AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
            StatusBarUtil.darkMode(this)
        }
        for (view in views) {
            StatusBarUtil.setPaddingSmart(this, view)
        }
    }

    open fun isChangeStatusColor(): Boolean {
        return true
    }

    /**
     * 子类可以重写该方法设置沉浸式状态栏
     *
     * @return view[]大小为0,则不启用沉浸式
     */
    open fun setImmersiveView(): Array<View> {
        // 默认使用第一个子 View
        val contentView: ViewGroup = this.findViewById(android.R.id.content)
        val rootView = contentView.getChildAt(0) as ViewGroup
        return arrayOf(rootView.getChildAt(0))
    }

    override fun onResume() {
        super.onResume()
        if (!isSetupImmersive) {
            setImmersiveStatus()
            isSetupImmersive = true
        }
    }

    /**
     * 实例化 BaseViewModel 子类
     */
    inline fun <reified T : BaseViewModel> getViewModel(): T {
        val viewModelFactory = Injection.provideViewModelFactory()
        return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
    }

    ////////////////////
    //////////菜单 start
    ////////////////////

    @MenuRes
    open fun getMenuRes(): Int {
        return 0
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (getMenuRes() != 0) {
            menuInflater.inflate(getMenuRes(), menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(menuItem: MenuItem?): Boolean {
        when (menuItem?.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    ////////////////////
    //////////菜单 end
    ////////////////////



    override fun onDestroy() {
        super.onDestroy()
        // 存在问题：因为在 finish 后，onDestroy 不会及时执行，导致关闭锁屏界面后，迅速打开app，会直接进入应用
        createCount--
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_KEYGUARD, REQUEST_CODE_CUSTOMER ->
                // 系统解锁界面 or 自定义指纹解锁
                if (resultCode != Activity.RESULT_OK) {
                    // 解锁失败
                    finish()
                }
        }
    }

    companion object {
        // activity 数量
        private var createCount = 0
        private const val REQUEST_CODE_KEYGUARD = 12
        private const val REQUEST_CODE_CUSTOMER = 13
    }
}