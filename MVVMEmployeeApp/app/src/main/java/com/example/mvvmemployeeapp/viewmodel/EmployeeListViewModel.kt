package com.example.mvvmemployeeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mvvmemployeeapp.service.model.Employee
import com.example.mvvmemployeeapp.service.repository.EmployeeRepository

class EmployeeListViewModel(val repoListRepository: EmployeeRepository) : BaseViewModel() {
    val employeeListLive = MutableLiveData<List<Employee>>()

    fun fetchEmployeeList() {
        dataLoading.value = true
        repoListRepository.getMutableLiveData() { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                employeeListLive.value = response?.data
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}