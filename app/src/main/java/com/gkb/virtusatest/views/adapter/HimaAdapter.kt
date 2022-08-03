package com.gkb.virtusatest.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.gkb.virtusatest.R
import com.gkb.virtusatest.model.*
import kotlinx.android.synthetic.main.item_hima_detail.view.*


class HimaAdapter(val context: Context, val userList:List<HimaResponseData>) : RecyclerView.Adapter<HimaAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {

            var tv_date:TextView
            var tv_fn:TextView
            var tv_avatar:ImageView
            var tv_ln:TextView
            var tv_email:TextView
            var tv_job_title:TextView
            var tv_fav_color:TextView
            var tv_id:TextView

            init {
                tv_date =binding.tv_date
                tv_fn =binding.tv_fn
                tv_avatar =binding.tv_avatar
                tv_ln =binding.tv_ln
                tv_email =binding.tv_email
                tv_job_title =binding.tv_job_title
                tv_fav_color =binding.tv_fav_color
                tv_id =binding.tv_id

            }






    }


    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_hima_detail, parent, false)

        return ViewHolder(inflater.rootView)
    }



    override fun onBindViewHolder(
            holder: ViewHolder,
            position: Int
    ) {

        holder.tv_date.text =userList[position].createdAt.toString()
        holder.tv_fn.text =userList[position].firstName.toString()
        Glide.with(this.context)
            .load(userList[position].avatar)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.bg_placeholder)
            .into(holder.tv_avatar)
        holder.tv_ln.text =userList[position].lastName.toString()
        holder.tv_email.text =userList[position].email.toString()
        holder.tv_job_title.text =userList[position].jobtitle.toString()
        holder.tv_fav_color.text =userList[position].favouriteColor.toString()
        holder.tv_id.setText(userList[position].id.toString())
    }


    override fun getItemCount(): Int {
        return userList.size
    }


}
