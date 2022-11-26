package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.data.Constant

class SplashFragment : Fragment() {
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_splash, container, false)

       Handler().postDelayed({
           if (Constant.getInstance().getBool()) {
              findNavController().navigate(R.id.introFragment)
           }else
               if (Constant.getInstance().getLogin()) {
                   findNavController().navigate(R.id.registerFragment)

               } else if (Constant.getInstance().getAdmin()) {
                   findNavController().navigate(R.id.registerFragment)

               } else if (!Constant.getInstance().getLogin())
               {
                   findNavController().navigate(R.id.userScreenFragment)
               }else if (!Constant.getInstance().getAdmin()){
                   findNavController().navigate(R.id.adminFragment)

               }
       },1000)

       return view
   }


}