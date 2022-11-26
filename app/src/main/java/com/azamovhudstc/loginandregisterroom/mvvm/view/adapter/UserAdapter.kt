package com.azamovhudstc.loginandregisterroom.mvvm.view.adapter

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.loginandregisterroom.R
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.item_food.view.*
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(
    var arrayList: ArrayList<UserEntity>, var context: Context
) : RecyclerView.Adapter<UserAdapter.Wh>() {
    inner class Wh(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(categoryEntity: UserEntity) {
            itemView.userNameTxt.text = categoryEntity.name
            itemView.profile_imageImg.setImageResource(categoryEntity.img)
            itemView.userLoginTvt.text = categoryEntity.login
            itemView.setOnLongClickListener {
                var dialog = AlertDialog.Builder(context)
                dialog.setTitle("User o`chirish !")
                dialog.setPositiveButton("Ha", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        var appDatabase = AppDatabase.getInstance()
                        appDatabase.getUserDao().deleteUser(categoryEntity)
                        Toast.makeText(context, "User o`chirildi !", Toast.LENGTH_SHORT).show()
                        submitList(
                            appDatabase.getUserDao()
                                .getAllUser() as ArrayList<UserEntity>
                        )
                    }
                })
                dialog.setNegativeButton("Yo`q", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(context, "Bekor qilindi !", Toast.LENGTH_SHORT).show()

                    }
                })
                dialog.setMessage("Haqiqatdan o`chirishni xoxlaysizmi ?")
                dialog.show()
                true

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
        return Wh(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Wh, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun submitList(submitList: ArrayList<UserEntity>) {
        arrayList.clear()
        arrayList.addAll(submitList)
        notifyDataSetChanged()
    }


}