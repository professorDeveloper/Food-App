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
import kotlinx.android.synthetic.main.add_food.*
import java.util.*

class AddFood : Fragment(R.layout.add_food) {
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var data = ""
        var appDatabase = AppDatabase.getInstance()
        food_create_date.setOnClickListener {
            val c: Calendar = Calendar.getInstance()
            val year1: Int = c.get(Calendar.YEAR)
            val month1: Int = c.get(Calendar.MONTH)
            val day: Int = c.get(Calendar.DAY_OF_MONTH)

            var datePickerDialog = DatePickerDialog(requireContext(),
                { view, year, month, dayOfMonth ->
                    food_create_date.setText("$dayOfMonth/$month/$year")
                    data = "$dayOfMonth/$month/$year"
                }, year1, month1, day
            )

            datePickerDialog.show()
        }
        back.setOnClickListener {
            findNavController().popBackStack()
        }
        addFoodBtn.setOnClickListener {
            var name = foodNameTv.text.toString().trim().toString()
            var foodColor = food_color.selectedItem.toString().trim()
            var foodCompany = foodCompany.text.toString().trim()
            var foodPrice = food_price.text.toString().trim()
            var countFood = foodCount.text.trim().toString()
            var foodWork = food_work_date.text.toString().trim()
            if (name.isEmpty() || foodColor.isEmpty() || foodCompany.isEmpty() ||
                foodPrice.isEmpty() || countFood.isEmpty() || data.isEmpty() ||
                foodWork.isEmpty()
            ) {
                Toast.makeText(requireContext(), "Maydonlarni to`ldiring", Toast.LENGTH_SHORT)
                    .show()
            } else {
                appDatabase.getFoodDao().add(
                    FoodEntity(
                        name = name, date = data,
                        dateYaroq = foodWork, company = foodCompany,
                        price = foodPrice, dona = countFood, category_id = 0)
                )
                Snackbar.make(view,"Muffaqyatli qo`shildi",Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()

            }
        }
    }
}