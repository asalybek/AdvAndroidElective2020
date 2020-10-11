package com.example.mvvmemployeeapp.domain

import androidx.lifecycle.LiveData
import com.example.mvvmemployeeapp.service.model.Employee

interface RepoListRepository {
    fun loadData(): LiveData<List<Employee>>
}