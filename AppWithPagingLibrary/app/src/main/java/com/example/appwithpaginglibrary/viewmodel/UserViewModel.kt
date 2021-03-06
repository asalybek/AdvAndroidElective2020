package com.example.appwithpaginglibrary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.appwithpaginglibrary.model.User
import com.example.appwithpaginglibrary.model.UserDataSource
import com.example.appwithpaginglibrary.model.UserDataSourceFactory

class UserViewModel : ViewModel() {

    var userPagedList: LiveData<PagedList<User>>
    private var liveDataSource: LiveData<UserDataSource>

    init {
        val itemDataSourceFactory = UserDataSourceFactory()
        liveDataSource = itemDataSourceFactory.userLiveDataSource

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()

        userPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}