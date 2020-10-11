package com.example.mvvmemployeeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmemployeeapp.domain.GetRepoListUseCase
import com.example.mvvmemployeeapp.service.model.Employee

class EmployeeListViewModel(private val getRepoListUseCase: GetRepoListUseCase) : BaseViewModel() {
    fun fetchEmployeeList(): LiveData<List<Employee>> {
        return getRepoListUseCase.getRepoList()
    }
}