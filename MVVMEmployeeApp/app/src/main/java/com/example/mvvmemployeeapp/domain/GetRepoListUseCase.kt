package com.example.mvvmemployeeapp.domain

import androidx.lifecycle.LiveData
import com.example.mvvmemployeeapp.service.model.Employee

class GetRepoListUseCase(private val repoListRepository: RepoListRepository) {
    fun getRepoList(): LiveData<List<Employee>> {
        return repoListRepository.loadData()
    }
}