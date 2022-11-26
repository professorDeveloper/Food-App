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

class FoodsAdapter(
    var arrayList: ArrayList<FoodEntity>,var clicked:OnCategoriesClick
) : RecyclerView.Adapter<FoodsAdapter.Wh>() {
    inner class Wh(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(categoryEntity: FoodEntity) {
            itemView.cart_food.setImageResource(R.drawable.ic_baseline_delete_24)
            itemView.food_img.setImageResource(R.drawable.img)
            itemView.cart_food.setOnClickListener {
                clicked.onDeleteClick(categoryEntity)

            }
            itemView.setOnClickListener {
             clicked.showDialog(categoryEntity)
            }
            itemView.tv_food.text=categoryEntity.name
            itemView.tv_food_compant.text=categoryEntity.company
            itemView.date_foood.text=categoryEntity.date
            itemView.setOnLongClickListener {
                clicked.onEditClick(categoryEntity)

                true
            }
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

    interface OnCategoriesClick {
        fun showDialog(categoryEntity: FoodEntity)
        fun onEditClick(categoryEntity: FoodEntity)
        fun onClick(categoryEntity: FoodEntity)
        fun onDeleteClick(categoryEntity: FoodEntity)
    }
}