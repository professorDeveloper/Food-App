package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import com.azamovhudstc.loginandregisterroom.mvvm.view.adapter.FoodsAdapterUser
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment(), FoodsAdapterUser.OnFoodClick {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var database = AppDatabase.getInstance().getFoodDao().getAllUser()
        var adapter =
            FoodsAdapterUser(database as ArrayList<FoodEntity> ,this)
    }

    override fun showDialog(categoryEntity: FoodEntity) {
        var bottoshSheetDialog = BottomSheetDialog(requireContext())
        var view = LayoutInflater.from(requireContext()).inflate(R.layout.bottom_sheet, null, false)
        bottoshSheetDialog.setContentView(view)

        view.deleteFood.setImageResource(R.drawable.ic_baseline_shopping_cart_24)
        view.PriceFood.text = "Price : ${categoryEntity.price}"
        view.CountFood.text = "Soni : ${categoryEntity.dona}"
        view.CreateFood.text = "Chiqarilgan sana : ${categoryEntity.date}"
        view.CompanyFood.text = "Fabrika nomi : ${categoryEntity.company}"
        view.WorkDate.text = "Yaroqli muddati : ${categoryEntity.dateYaroq}"
        view.TitleFood.text = categoryEntity.name
        view.deleteFood.setOnClickListener {
            Toast.makeText(requireContext(), "Qo`shildi", Toast.LENGTH_SHORT).show()
        }
        view.imageView2.setOnClickListener {
            bottoshSheetDialog.dismiss()
        }
        bottoshSheetDialog.show()
    }

}