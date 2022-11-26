package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.data.Constant
import com.azamovhudstc.loginandregisterroom.mvvm.view.adapter.TaskSixAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class IntroFragment : Fragment(R.layout.fragment_intro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBack = view.findViewById<AppCompatImageView>(R.id.buttonBack)
        val buttonSkip = view.findViewById<AppCompatTextView>(R.id.buttonSkip)
        val buttonAction = view.findViewById<AppCompatTextView>(R.id.buttonAction)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = TaskSixAdapter(requireActivity())
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                Toast.makeText(this@MainActivity, "POSITION = $position", Toast.LENGTH_SHORT).show()
                when (position) {
                    0 -> {
                        buttonBack.visibility = View.INVISIBLE
                        buttonSkip.visibility = View.VISIBLE
                        buttonAction.text = "Next"
                    }
                    1 -> {
                        buttonBack.visibility = View.VISIBLE
                        buttonSkip.visibility = View.VISIBLE
                        buttonAction.text = "Next"
                    }
                    else -> {
                        buttonBack.visibility = View.VISIBLE
                        buttonSkip.visibility = View.INVISIBLE
                        buttonAction.text = "Start"
                    }
                }
            }
        })

//        viewPager.unregisterOnPageChangeCallback()
//        viewPager.isUserInputEnabled = false

        buttonBack.setOnClickListener {
            viewPager.currentItem --
        }

        buttonSkip.setOnClickListener {
            when(viewPager.currentItem){
                0->{
                    viewPager.currentItem+=2
                }

                1->{
                    viewPager.currentItem+=1
                }

            }
        }

        buttonAction.setOnClickListener {
            if (viewPager.currentItem != 2)
                viewPager.currentItem++
            else
                Constant.getInstance().setBool(false)
            if (Constant.getInstance().getLogin()) {
                findNavController().navigate(R.id.registerFragment)

            } else if (Constant.getInstance().getAdmin()) {
                findNavController().navigate(R.id.registerFragment)

            } else if (!Constant.getInstance().getLogin())
            {
                findNavController().navigate(R.id.usersFragment)
            }else if (!Constant.getInstance().getAdmin()){
                findNavController().navigate(R.id.adminFragment)

            }
            }

        val dots = view.findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)
        dots.attachTo(viewPager)
    }


}