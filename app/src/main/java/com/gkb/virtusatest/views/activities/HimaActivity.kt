package com.gkb.virtusatest.views.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gkb.virtusatest.R
import com.gkb.virtusatest.contract.HimaContract
import com.gkb.virtusatest.model.HimaResponseData
import com.gkb.virtusatest.presenter.HimaPresenter
import com.gkb.virtusatest.views.adapter.HimaAdapter
import kotlinx.android.synthetic.main.activity_hima.*


class HimaActivity: AppCompatActivity(),HimaContract{

    private var adapter: HimaAdapter? = null
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hima)


        rv_hima_details.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        rv_hima_details.layoutManager = layoutManager
        HimaPresenter(this).getMyData()

    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onSuccess(list: List<HimaResponseData>) {

        if (list.isNotEmpty()){
            val responseBody = list
            adapter = HimaAdapter(baseContext, responseBody)
            adapter!!.notifyDataSetChanged()
            rv_hima_details.adapter = adapter
            intent.putExtra("kasjbc", list.get(0).id)

            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this, "Data not available", Toast.LENGTH_LONG).show()

        }

        }

    override fun onFailure(message: String) {
        Toast.makeText(this, "Data not available", Toast.LENGTH_LONG).show()
    }

}