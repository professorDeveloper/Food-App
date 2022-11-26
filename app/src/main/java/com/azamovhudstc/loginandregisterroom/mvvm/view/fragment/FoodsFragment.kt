package com.azamovhudstc.loginandregisterroom.mvvm.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.dao.FoodDao
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import com.azamovhudstc.loginandregisterroom.mvvm.view.adapter.FoodsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.add_user.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_foods.*
import kotlinx.android.synthetic.main.fragment_foods.view.*
import java.io.Serializable

class FoodsFragment : Fragment(R.layout.fragment_foods), FoodsAdapter.OnCategoriesClick {

    lateinit var roots: View


    var boolean = false

    lateinit var adapter: FoodsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var database = AppDatabase.getInstance()


        roots = view

        placeHolder(AppDatabase.getInstance().getFoodDao().getAllUser(), roots)

        addFood.setOnClickListener {
            var bundle = Bundle()
            findNavController().navigate(R.id.addFoods, bundle)
            adapter.submitList(
                AppDatabase.getInstance().getFoodDao()
                    .getAllUser() as ArrayList<FoodEntity>
            )

        }
        adapter = FoodsAdapter(
            database.getFoodDao()
                .getAllUser() as ArrayList<FoodEntity>,
            this
        )
        adapter.submitList(
            AppDatabase.getInstance().getFoodDao()
                .getAllUser() as ArrayList<FoodEntity>
        )
        placeHolder(AppDatabase.getInstance().getFoodDao().getAllUser(), roots)

        foods_rv.adapter = adapter
    }

    @SuppressLint("SetTextI18n")
    override fun showDialog(categoryEntity: FoodEntity) {
        var bottoshSheetDialog = BottomSheetDialog(requireContext())
        var view = LayoutInflater.from(requireContext()).inflate(R.layout.bottom_sheet, null, false)
        bottoshSheetDialog.setContentView(view)
        view.PriceFood.text = "Price : ${categoryEntity.price}"
        view.CountFood.text = "Soni : ${categoryEntity.dona}"
        view.CreateFood.text = "Chiqarilgan sana : ${categoryEntity.date}"
        view.CompanyFood.text = "Fabrika nomi : ${categoryEntity.company}"
        view.WorkDate.text = "Yaroqli muddati : ${categoryEntity.dateYaroq}"
        view.TitleFood.text = categoryEntity.name
        view.deleteFood.setOnClickListener {
          this@FoodsFragment.onDeleteClick(categoryEntity)
            bottoshSheetDialog.dismiss()
            Toast.makeText(requireContext(), "Ochirildi", Toast.LENGTH_SHORT).show()
        }
        view.imageView2.setOnClickListener {
            bottoshSheetDialog.dismiss()
        }
        bottoshSheetDialog.show()
    }

    override fun onEditClick(categoryEntity: FoodEntity) {
        var bundle = Bundle()
        bundle.putSerializable("food", categoryEntity)
        findNavController().navigate(R.id.editFood, bundle)
        placeHolder(AppDatabase.getInstance().getFoodDao().getAllUser(), roots)


    }

    override fun onClick(categoryEntity: FoodEntity) {

    }

    override fun onResume() {
        adapter.submitList(
            AppDatabase.getInstance().getFoodDao()
                .getAllUser() as ArrayList<FoodEntity>
        )

        placeHolder(AppDatabase.getInstance().getFoodDao().getAllUser(), roots)

        super.onResume()

    }

    fun placeHolder(database: FoodDao, id: Int, root: View) {
        if (database.getAllUser().isEmpty()) {
            root.placeHolder.visibility = View.VISIBLE
            root.foods_rv.visibility = View.INVISIBLE

        } else {
            root.placeHolder.visibility = View.INVISIBLE
            root.foods_rv.visibility = View.VISIBLE

        }
    }

    fun placeHolder(list: List<FoodEntity>, root: View) {
        if (list.isEmpty()) {
            root.placeHolder.visibility = View.VISIBLE
            root.foods_rv.visibility = View.INVISIBLE

        } else {
            root.placeHolder.visibility = View.INVISIBLE
            root.foods_rv.visibility = View.VISIBLE

        }
    }

    override fun onDeleteClick(categoryEntity: FoodEntity) {
        var appBase = AppDatabase.getInstance()
        appBase.getFoodDao().delete(categoryEntity)
        adapter.submitList(
            appBase.getFoodDao().getAllUser() as ArrayList<FoodEntity>
        )
        placeHolder(AppDatabase.getInstance().getFoodDao().getAllUser(), roots)

    }

}