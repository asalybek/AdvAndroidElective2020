package com.example.mvvmemployeeapp.di

import android.content.SharedPreferences
import com.example.mvvmemployeeapp.domain.GetRepoListUseCase
import com.example.mvvmemployeeapp.service.repository.RepoListDataStore
import com.example.mvvmemployeeapp.service.repository.RetrofitClient
import com.example.mvvmemployeeapp.viewmodel.EmployeeListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EmployeeListViewModel(get()) }
}
val useCaseModule = module {
    single { GetRepoListUseCase(get<RepoListDataStore>()) }
}


val repositoryModule = module {
    single { RepoListDataStore(get()) }
}

val networkModule = module {
    single { RetrofitClient.create(okHttpClient = get()) }
    single { RetrofitClient.getOkHttpClient(authInterceptor = get()) }
    single { RetrofitClient.getAuthInterceptor(sharedPreferences = get()) }
}

val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("fefault", android.content.Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("fefault", android.content.Context.MODE_PRIVATE)
            .edit()
    }
}


