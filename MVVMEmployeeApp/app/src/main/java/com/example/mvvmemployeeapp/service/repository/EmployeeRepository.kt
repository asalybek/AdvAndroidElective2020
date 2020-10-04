package com.example.mvvmemployeeapp.service.repository


import com.example.mvvmemployeeapp.service.model.EmployeeDBResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepository(val service : EmployeeService) {
    fun getMutableLiveData(onResult: (isSuccess: Boolean, response: EmployeeDBResponse?) -> Unit) {
        service.getEmployees().enqueue(object : Callback<EmployeeDBResponse> {
            override fun onResponse(
                call: Call<EmployeeDBResponse>?,
                response: Response<EmployeeDBResponse>?
            ) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<EmployeeDBResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }
}