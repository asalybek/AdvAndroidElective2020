package com.example.mvvmemployeeapp.view.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmemployeeapp.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_detail)
        val textName: TextView = findViewById(R.id.tvFullName2)
        val textEmail: TextView = findViewById(R.id.tvEmail2)
        val image: ImageView = findViewById(R.id.ivPic2)
        textName.text = intent.getStringExtra("fullName")
        textEmail.text = intent.getStringExtra("email")
        Glide.with(image.context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .circleCrop()
            )
            .load(intent.getStringExtra("pic"))
            .placeholder(R.drawable.loading)
            .into(image)
    }
}