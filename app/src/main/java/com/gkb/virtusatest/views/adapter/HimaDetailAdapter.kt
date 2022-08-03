package com.gkb.virtusatest.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gkb.virtusatest.R
import com.gkb.virtusatest.model.*
import kotlinx.android.synthetic.main.item_room_detail.view.*


class HimaDetailAdapter(val context: Context, val userList:List<HimaDetailsResponse>) : RecyclerView.Adapter<HimaDetailAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {

        var tv_Create_date:TextView
        var tv_is_occupied:TextView
        var tv_max_occupancy:TextView
        var tv_id2:TextView

        init {
            tv_Create_date =binding.tv_Create_date
            tv_is_occupied =binding.tv_is_occupied
            tv_max_occupancy =binding.tv_max_occupancy
            tv_id2 =binding.tv_id2

        }






    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room_detail, parent, false)

        return ViewHolder(inflater.rootView)
    }



    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        holder.tv_Create_date.text =userList[position].createdAt.toString()
        holder.tv_is_occupied.text = userList[position].isOccupied.toString()
        holder.tv_max_occupancy.setText(userList[position].maxOccupancy.toString())
        holder.tv_id2.setText(userList[position].id.toString())
    }


    override fun getItemCount(): Int {
        return userList.size
    }


}
