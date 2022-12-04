package com.giftech.dicodinguser.model

data class User(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val university: String,
    val numCertificationsCompleted: Int
)