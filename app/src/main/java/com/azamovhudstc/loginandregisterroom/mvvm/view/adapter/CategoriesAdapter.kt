package com.azamovhudstc.loginandregisterroom.mvvm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import kotlinx.android.synthetic.main.category_item.view.*

class CategoriesAdapter(
    var arrayList: ArrayList<CategoryEntity>,
    var onCategoriesClick: OnCategoriesClick
) : RecyclerView.Adapter<CategoriesAdapter.Wh>() {
    inner class Wh(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(categoryEntity: CategoryEntity) {
            itemView.categories_name.text = categoryEntity.name
            itemView.setOnClickListener {
                onCategoriesClick.onClick(categoryEntity)
            }
            itemView.setOnLongClickListener {
                onCategoriesClick.onEditClick(categoryEntity)
                true
            }
            itemView.delete_Category.setOnClickListener {
                onCategoriesClick.onDeleteClick(categoryEntity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
        return Wh(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Wh, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun submitList(submitList: ArrayList<CategoryEntity>) {
        arrayList.clear()
        arrayList.addAll(submitList)
        notifyDataSetChanged()
    }

    interface OnCategoriesClick {
        fun onEditClick(categoryEntity: CategoryEntity)
        fun onClick(categoryEntity: CategoryEntity)
        fun onDeleteClick(categoryEntity: CategoryEntity)
    }
}