package com.example.mvvmemployeeapp.service.model

data class EmployeeDBResponse(
    val page: Int,
    val total: Int,
    val data: MutableList<Employee>

)