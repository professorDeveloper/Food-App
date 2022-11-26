package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
import com.azamovhudstc.loginandregisterroom.mvvm.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.fragment_users.*


class UsersFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    lateinit var adapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= UserAdapter(AppDatabase.getInstance().getUserDao().getAllUser() as ArrayList<UserEntity>,requireContext()
        )
        rv_user.adapter=adapter
        addUser.setOnClickListener {
            findNavController().navigate(R.id.addUser2)
        }

    }
    override fun onResume() {
        adapter.submitList(AppDatabase.getInstance().getUserDao().getAllUser() as ArrayList<UserEntity>)
        super.onResume()

    }
}