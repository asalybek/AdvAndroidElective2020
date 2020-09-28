package com.example.mvvmemployeeapp.service.repository

import com.example.mvvmemployeeapp.service.model.EmployeeDBResponse
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeService {
    @GET("users/?per_page=12&page=1")
    fun getEmployees(): Call<EmployeeDBResponse>
}