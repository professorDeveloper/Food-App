package com.azamovhudstc.loginandregisterroom.mvvm.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import kotlinx.android.synthetic.main.category_item.view.*

class CategoriesAdapter(var list:ArrayList<CategoryEntity>,var onclickCat: OnclickCat):RecyclerView.Adapter<CategoriesAdapter.Wh>() {
    var checkedList:ArrayList<CategoryEntity> ?=null
    inner class Wh(view: View):RecyclerView.ViewHolder(view) {
        fun onBind(data:CategoryEntity){
            itemView.checkbox.text=data.name


            if (!itemView.checkbox.isChecked){
                checkedList?.remove(data)
            }else{
                checkedList?.add(data)

            }
            itemView.setOnClickListener {
                if (!itemView.checkbox.isChecked){
                    checkedList?.remove(data)
                }else{
                    checkedList?.add(data)

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
        return Wh(LayoutInflater.from(parent.context).inflate(R .layout.category_item,parent,false))
    }

    override fun onBindViewHolder(holder: Wh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface OnclickCat{
        fun onClick( categoryList:ArrayList<CategoryEntity>)
    }

}