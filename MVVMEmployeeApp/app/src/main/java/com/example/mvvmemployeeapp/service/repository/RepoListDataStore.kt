package com.example.mvvmemployeeapp.service.repository

import androidx.lifecycle.LiveData
import com.example.mvvmemployeeapp.domain.RepoListRepository
import com.example.mvvmemployeeapp.service.model.Employee

class RepoListDataStore(apiService: EmployeeService) : RepoListRepository, BaseDataStore(apiService) {

    override fun loadData(): LiveData<List<Employee>> {
        return fetchData { service.getEmployees() }
    }
}