package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
import com.azamovhudstc.loginandregisterroom.mvvm.view.adapter.CategoriesAdapter
import com.azamovhudstc.loginandregisterroom.utils.ConverterCategory
import kotlinx.android.synthetic.main.add_user.*
import kotlinx.android.synthetic.main.add_user.view.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.select_categorys.*
import kotlinx.android.synthetic.main.select_categorys.view.*

class AddUser : Fragment(), CategoriesAdapter.OnclickCat {

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
        var dao = AppDatabase.getInstance().getCategoryDao()
        var userDao = AppDatabase.getInstance().getUserDao()
        var foodDao = AppDatabase.getInstance().getFoodDao()
        addUserBtn.setOnClickListener {
            if (view.user_login.text.trim().isEmpty() || view.userName.text.trim()
                    .isEmpty() || view.userPassword.text.trim().isEmpty()
                ) {
                Toast.makeText(requireActivity(), "Maydonni to`ldiring", Toast.LENGTH_SHORT).show()
            }else if (dao.getAllCategory().isEmpty()){
                var alertView = LayoutInflater.from(requireContext())
                    .inflate(R.layout.add_category, container_categories, false)
                var dialog = AlertDialog.Builder(requireContext())

            }

            else {
                var cat = dao.getAllCategory()
                var adapter = CategoriesAdapter(cat as ArrayList<CategoryEntity>, this)

                var alertView = LayoutInflater.from(requireContext())
                    .inflate(R.layout.select_categorys, container_categories, false)
                var dialog = AlertDialog.Builder(requireContext())

                alertView.cat_Rv.adapter = adapter

                dialog.setView(alertView)

                dialog.setPositiveButton("Qo`shish"
                ) { dialog, which ->
                    if (adapter.checkedList!!.isEmpty()) {
                        Toast.makeText(
                            requireActivity(),
                            "Category tanlang !",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        var converter = ConverterCategory()
                        var list: String = converter.fromClothingToJSON(adapter.checkedList!!)
                        userDao.addUser(
                            UserEntity(
                                name = view.userName.text.toString(),
                                login = view.loginTxt.text.toString(),
                                password = view.passwordTxt.text.toString(),
                                listCategory = list,
                                img = R.drawable.man
                            )
                        )
                    }
                }
                dialog.show()
            }
        }
    }

    override fun onClick(categoryList: ArrayList<CategoryEntity>) {

    }
}