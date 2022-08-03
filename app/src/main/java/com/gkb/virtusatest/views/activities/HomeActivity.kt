package com.gkb.virtusatest.views.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gkb.virtusatest.R
import kotlinx.android.synthetic.main.fragment_more_dashboard.*


class HomeActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_more_dashboard)

        cl_7.setOnClickListener {
                val intent = Intent(this, HimaActivity::class.java)
               startActivity(intent)
        }
        cl_8.setOnClickListener {
                val intent = Intent(this, HimaDetailsActivity::class.java)
                startActivity(intent)
        }

    }

}