package com.trinitymirror.fabtobottomnavigationsample

import android.annotation.SuppressLint
import android.os.Build

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        return MyHolder(
                TextView(parent.context)
                        .apply {
                            layoutParams = ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT, 150)
                        }
        )
    }

    override fun getItemCount(): Int {
        return 150
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(position)
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {

            if (position % 2 == 0) {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.item_bg_1))
            } else {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.item_bg_2))
            }
            (itemView as TextView).apply {
                text = "Text #$position"
                gravity = Gravity.CENTER_VERTICAL
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setTextAppearance(android.R.style.TextAppearance_DeviceDefault_Small)
                }
            }
        }
    }
}
