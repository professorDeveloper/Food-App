package com.azamovhudstc.loginandregisterroom.mvvm.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.azamovhudstc.loginandregisterroom.mvvm.view.fragment.CartsFragment
import com.azamovhudstc.loginandregisterroom.mvvm.view.fragment.FoodsFragment
import com.azamovhudstc.loginandregisterroom.mvvm.view.fragment.UserFragment
import com.azamovhudstc.loginandregisterroom.mvvm.view.fragment.UsersFragment

class ViewPager2AdapterUser(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UserFragment()
            else -> CartsFragment()
        }
    }
}