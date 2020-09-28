package com.example.mvvmemployeeapp.view.viewholder

import android.content.Intent
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmemployeeapp.BR
import com.example.mvvmemployeeapp.R
import com.example.mvvmemployeeapp.service.model.Employee
import com.example.mvvmemployeeapp.view.ui.DetailActivity
import com.example.mvvmemployeeapp.viewmodel.EmployeeListViewModel
import kotlinx.android.synthetic.main.employee_list_item.view.*

class EmployeeListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val repoListViewModel: EmployeeListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage: ImageView = itemView.ivPic
    fun setup(employeeData: Employee) {
        dataBinding.setVariable(BR.employeeData, employeeData)
        dataBinding.executePendingBindings()
        itemView.setOnClickListener {
            val context = itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("fullName", employeeData.firstName + " " + employeeData.lastName)
            intent.putExtra("pic", employeeData.avatar)
            intent.putExtra("email", employeeData.email)
            context.startActivity(intent)
        }
        Glide.with(avatarImage.context)
            .setDefaultRequestOptions(
                RequestOptions()
                    .circleCrop()
            )
            .load(employeeData.avatar)
            .placeholder(R.drawable.loading)
            .into(avatarImage)
    }
}