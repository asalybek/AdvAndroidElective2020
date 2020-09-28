package com.example.mvvmemployeeapp.service.repository


import com.example.mvvmemployeeapp.service.model.EmployeeDBResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepository() {
    fun getMutableLiveData(onResult: (isSuccess: Boolean, response: EmployeeDBResponse?) -> Unit) {
        RetrofitClient.instance.getEmployees().enqueue(object : Callback<EmployeeDBResponse> {
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

    companion object {
        private var INSTANCE: EmployeeRepository? = null
        fun getInstance() = INSTANCE
            ?: EmployeeRepository().also {
                INSTANCE = it
            }
    }
}