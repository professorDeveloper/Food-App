package com.azamovhudstc.loginandregisterroom.mvvm.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.azamovhudstc.loginandregisterroom.mvvm.view.page.FirstPage
import com.azamovhudstc.loginandregisterroom.mvvm.view.page.SecondPage
import com.azamovhudstc.loginandregisterroom.mvvm.view.page.ThirdPage

class TaskSixAdapter(fmActivity: FragmentActivity) : FragmentStateAdapter(fmActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstPage()
            1 -> SecondPage()
            else -> ThirdPage()
        }
    }
}