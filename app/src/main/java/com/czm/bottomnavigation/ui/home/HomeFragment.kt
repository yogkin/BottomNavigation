package com.czm.bottomnavigation.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.czm.bottomnavigation.R
import com.czm.bottomnavigation.ui.base.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel

    override val layoutId: Int
        get() = R.layout.home_fragment

    override fun onInit(savedInstanceState: Bundle?) {

    }

    override fun lazyInitData() {
        viewModel = getViewModel()
        
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}
