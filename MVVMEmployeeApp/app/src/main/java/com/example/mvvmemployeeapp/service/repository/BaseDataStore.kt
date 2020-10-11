package com.example.mvvmemployeeapp.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmemployeeapp.service.model.Employee
import com.example.mvvmemployeeapp.service.model.EmployeeDBResponse
import kotlinx.coroutines.*
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber

abstract class BaseDataStore(@PublishedApi internal val service: EmployeeService) {

    abstract fun loadData(): LiveData<List<Employee>>


    inline fun fetchData(crossinline call: (EmployeeService) -> Deferred<Response<EmployeeDBResponse>>): LiveData<List<Employee>> {
        val result = MutableLiveData<List<Employee>>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = call(service)
            withContext(Dispatchers.Main) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {
                        result.value = response.body()?.data
                    } else {
                        Timber.d("Error occurred with code ${response.code()}")
                    }
                } catch (e: HttpException) {
                    Timber.d("Error: ${e.message()}")
                } catch (e: Throwable) {
                    Timber.d("Error: ${e.message}")
                }
            }
        }

        return result
    }


}