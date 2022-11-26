package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.loginBtn.setOnClickListener {
            if (loginTxt.text.toString() == "admin" && passwordTxt.text.toString() == "123") {
              findNavController().navigate(R.id.adminFragment)

                return@setOnClickListener
            } else if (loginTxt.text.toString().isEmpty() || passwordTxt.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(requireContext(), "Maydonni To`ldiring !", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {


                if (AppDatabase.getInstance().getUserDao().getAllUser().isNotEmpty()) {
                    var isHave=false
                    for (i in AppDatabase.getInstance().getUserDao().getAllUser()) {
                        Log.d("!@#", "onViewCreated: ${i.login } ||| ${i.password}")
                        if (loginTxt.text.toString()==i.login.toString() &&  passwordTxt.text.toString()==i.password)
                        {
                            isHave=true
                            break
                        }

                    }
                    if (isHave){
                        findNavController().navigate(R.id.usersFragment)

                    }
                } else {
                    Toast.makeText(requireContext(), "Noto`g`ri kiritildi ", Toast.LENGTH_SHORT)
                        .show()
                }
            }


        }
    }
}