package com.example.mvvmemployeeapp.service.repository

import com.example.mvvmemployeeapp.service.model.EmployeeDBResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeService {
    @GET("users/?per_page=12&page=1")
    fun getEmployees(): Deferred<Response<EmployeeDBResponse>>
}