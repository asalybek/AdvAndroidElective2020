package com.example.mvvmemployeeapp.service.model

import com.google.gson.annotations.SerializedName

//data class Employee(
//    val avatar: String?,
//    val email: String?,
//    val first_name: String?,
//    val last_name: String?,
//    val id: Long?
//)
class Employee {
    @SerializedName("avatar")
    val avatar: String? = null

    @SerializedName("email")
    val email: String? = null

    @SerializedName("first_name")
    val firstName: String? = null

    @SerializedName("last_name")
    val lastName: String? = null

    @SerializedName("id")
    val id: Long? = null

}