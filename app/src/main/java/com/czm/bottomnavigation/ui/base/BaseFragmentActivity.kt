package com.czm.bottomnavigation.ui.base

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.czm.bottomnavigation.R
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.layout_tool_bar.view.*

abstract class BaseFragmentActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_content

    override fun onInitView(savedInstanceState: Bundle?) {
        toolbarLayout.tvTitle.text = setTitle()
        setSupportActionBar(toolbarLayout as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onInit(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, setFragment())
            .commit()
    }

    /**
     * 设置 title
     */
    protected abstract fun setTitle(): String

    /**
     * 内嵌的 fragment
     */
    protected abstract fun setFragment(): Fragment

}
