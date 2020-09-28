package com.example.mvvmemployeeapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmemployeeapp.databinding.EmployeeListItemBinding
import com.example.mvvmemployeeapp.service.model.Employee
import com.example.mvvmemployeeapp.view.viewholder.EmployeeListViewHolder
import com.example.mvvmemployeeapp.viewmodel.EmployeeListViewModel

class EmployeeListAdapter(private val repoListViewModel: EmployeeListViewModel) :
    RecyclerView.Adapter<EmployeeListViewHolder>() {
    var employeeList: List<Employee> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = EmployeeListItemBinding.inflate(inflater, parent, false)
        return EmployeeListViewHolder(
            dataBinding,
            repoListViewModel
        )
    }

    override fun getItemCount() = employeeList.size

    override fun onBindViewHolder(holder: EmployeeListViewHolder, position: Int) {
        holder.setup(employeeList[position])
    }

    fun updateRepoList(employeeList: List<Employee>) {
        this.employeeList = employeeList
        notifyDataSetChanged()
    }
}