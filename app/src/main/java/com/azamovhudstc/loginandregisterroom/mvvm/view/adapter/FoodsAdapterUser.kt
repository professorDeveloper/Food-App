package com.azamovhudstc.loginandregisterroom.mvvm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.item_food.view.*

class FoodsAdapterUser(
    var arrayList: ArrayList<FoodEntity>,var clicked:OnFoodClick
) : RecyclerView.Adapter<FoodsAdapterUser.Wh>() {
    inner class Wh(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(categoryEntity: FoodEntity) {
            itemView.food_img.setImageResource(R.drawable.img)

            itemView.setOnClickListener {
             clicked.showDialog(categoryEntity)
            }
            itemView.tv_food.text=categoryEntity.name
            itemView.tv_food_compant.text=categoryEntity.company
            itemView.date_foood.text=categoryEntity.date

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
        return Wh(
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Wh, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun submitList(submitList: ArrayList<FoodEntity>) {
        arrayList.clear()
        arrayList.addAll(submitList)
        notifyDataSetChanged()
    }

    interface OnFoodClick {
        fun showDialog(categoryEntity: FoodEntity)
    }
}