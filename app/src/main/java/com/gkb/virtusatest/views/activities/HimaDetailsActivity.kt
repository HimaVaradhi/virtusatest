package com.gkb.virtusatest.views.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gkb.virtusatest.R
import com.gkb.virtusatest.contract.HimaDetailsContract
import com.gkb.virtusatest.model.HimaDetailsResponse
import com.gkb.virtusatest.presenter.HImaDetailsPresenter
import com.gkb.virtusatest.views.adapter.HimaDetailAdapter
import kotlinx.android.synthetic.main.activity_hima_details.*



class HimaDetailsActivity: AppCompatActivity(),HimaDetailsContract{

    private var adapter: HimaDetailAdapter? = null
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hima_details)


        rv_room_details.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        rv_room_details.layoutManager = layoutManager
        HImaDetailsPresenter(this).getMyRoomData()

    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onSuccess(list: List<HimaDetailsResponse>) {

        if (list.isNotEmpty()){
            val responseBody = list
            adapter = HimaDetailAdapter(baseContext, responseBody)
            adapter!!.notifyDataSetChanged()
            rv_room_details.adapter = adapter
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this, "Data not available", Toast.LENGTH_LONG).show()

        }

    }

    override fun onFailure(message: String) {
        Toast.makeText(this, "Data not available", Toast.LENGTH_LONG).show()
    }

}