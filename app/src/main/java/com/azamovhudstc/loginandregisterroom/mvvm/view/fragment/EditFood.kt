package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.edit_food.*
import kotlinx.android.synthetic.main.item_food.*
import java.util.*

class EditFood() : Fragment(R.layout.edit_food) {
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var foodEntity =arguments?.getSerializable("food") as FoodEntity
        super.onViewCreated(view, savedInstanceState)
        var data = ""
        var appDatabase = AppDatabase.getInstance()
        EditFoodNameTv.setText(foodEntity.name.toString())
        editFoodCompany.setText(foodEntity.company.toString())
        editFoodCount.setText(foodEntity.dona.toString())
        editFoodPrice.setText(foodEntity.price.toString())
        editFoodCreate.text = foodEntity.date
        editFoodWorkDate.setText(foodEntity.dateYaroq)

        editFoodCreate.setOnClickListener {
            val c: Calendar = Calendar.getInstance()
            val year1: Int = c.get(Calendar.YEAR)
            val month1: Int = c.get(Calendar.MONTH)
            val day: Int = c.get(Calendar.DAY_OF_MONTH)




            var datePickerDialog = DatePickerDialog(requireContext(),
                { view, year, month, dayOfMonth ->
                    editFoodCreate.setText("$dayOfMonth/$month/$year")
                    data = "$dayOfMonth/$month/$year"
                }, year1, month1, day
            )

            datePickerDialog.show()
        }
        backEdit.setOnClickListener {
            findNavController().popBackStack()
        }
        EditFoodBtn.setOnClickListener {
            var name = EditFoodNameTv.text.toString().trim().toString()
            var foodColor = edit_food_color.selectedItem.toString().trim()
            var foodCompany = editFoodCompany.text.toString().trim()
            var foodPrice = editFoodPrice.text.toString().trim()
            var countFood = editFoodCount.text.trim().toString()
            var foodWork = editFoodWorkDate.text.toString().trim()
            foodEntity.name=name
            foodEntity.company=foodCompany
            foodEntity.price=foodPrice
            foodEntity.dona=countFood
            foodEntity.dateYaroq=foodWork
            if (name.isEmpty() || foodColor.isEmpty() || foodCompany.isEmpty() ||
                foodPrice.isEmpty() || countFood.isEmpty() ||
                foodWork.isEmpty()
            ) {
                Toast.makeText(requireContext(), "Maydonlarni to`ldiring", Toast.LENGTH_SHORT)
                    .show()
            } else {
                appDatabase.getFoodDao().update(foodEntity)
                Snackbar.make(view,"Muffaqyatli qo`shildi",Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()

            }
        }
    }
}