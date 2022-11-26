package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.view.adapter.ViewPager2Adapter
import com.azamovhudstc.loginandregisterroom.mvvm.view.adapter.ViewPager2AdapterUser
import kotlinx.android.synthetic.main.fragment_admin.view.*
import kotlinx.android.synthetic.main.fragment_user_screen.view.*
import kotlinx.android.synthetic.main.fragment_users.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AdminFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserScreenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var root:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_user_screen, container, false)
        var adapter= ViewPager2AdapterUser(requireActivity())
        root.container_user.adapter=adapter
        root.bottom_menu_user.setItemSelected(R.id.home)
        root.bottom_menu_user.setOnItemSelectedListener {
            when(it){
                R.id.home ->{
                    root.container_user.currentItem=0
                }
                R.id.history ->{
                    root.container_user.currentItem=1
                }
            }
        }
        root.container_user.setOnTouchListener(null);
        root.container_user.isUserInputEnabled = false

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        var adapter= ViewPager2AdapterUser(requireActivity())
        root.container_user.adapter=adapter

    }

}