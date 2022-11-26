package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.add_user.*
import kotlinx.android.synthetic.main.add_user.view.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.select_categorys.*
import kotlinx.android.synthetic.main.select_categorys.view.*

class AddUser : Fragment() {
    var boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        man.setOnClickListener {
            man.borderWidth = 12

            boolean = false
            woman.borderWidth = 0
        }
        woman.setOnClickListener {
            woman.borderWidth = 12
            boolean = true
            man.borderWidth = 0
        }
        backUser.setOnClickListener {
            findNavController().popBackStack()
        }
        addUserBtn.setOnClickListener {
            var login = user_login.text.toString().trim()
            var password = userPassword.text.toString().trim()
            var userName = userName.text.toString().trim()
            if (login.isEmpty() || password.isEmpty() || userName.isEmpty()) {
                Toast.makeText(requireContext(), "Maydonlar to`ldirilmagan", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var appDatabase = AppDatabase.getInstance()
                appDatabase.getUserDao().addUser(
                    UserEntity(
                        name = userName,
                        login = login,
                        password = password,
                        img =  if (boolean) R.drawable.women else R.drawable.man
                    )
                )
                Snackbar.make(view, "Muffaqyatli qo`shildi !", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()

            }
        }
        backUser.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}

