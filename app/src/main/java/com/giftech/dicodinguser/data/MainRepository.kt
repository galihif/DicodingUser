package com.giftech.dicodinguser.data

import com.giftech.dicodinguser.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MainRepository {

    val dummyUser = listOf(
        User(
            id = 1,
            name = "Samantha Taylor",
            imageUrl = "https://randomuser.me/api/portraits/women/1.jpg",
            university = "Universitas Indonesia",
            numCertificationsCompleted = 51
        ),
        User(
            id = 2,
            name = "Michael Johnson",
            imageUrl = "https://randomuser.me/api/portraits/men/2.jpg",
            university = "Institut Teknologi Bandung",
            numCertificationsCompleted = 32
        ),
        User(
            id = 3,
            name = "Jessica Anderson",
            imageUrl = "https://randomuser.me/api/portraits/women/3.jpg",
            university = "Universitas Padjadjaran",
            numCertificationsCompleted = 87
        ),
        User(
            id = 4,
            name = "David Williams",
            imageUrl = "https://randomuser.me/api/portraits/men/4.jpg",
            university = "Universitas Indonesia",
            numCertificationsCompleted = 6
        ),
        User(
            id = 5,
            name = "Emily Thompson",
            imageUrl = "https://randomuser.me/api/portraits/women/5.jpg",
            university = "Institut Teknologi Bandung",
            numCertificationsCompleted = 2
        ),
        User(
            id = 6,
            name = "Christopher Brown",
            imageUrl = "https://randomuser.me/api/portraits/men/6.jpg",
            university = "Universitas Diponegoro",
            numCertificationsCompleted = 54
        ),
        User(
            id = 7,
            name = "Sarah Moore",
            imageUrl = "https://randomuser.me/api/portraits/women/7.jpg",
            university = "Universitas Gadjah Mada",
            numCertificationsCompleted = 1
        ),
        User(
            id = 8,
            name = "John Davis",
            imageUrl = "https://randomuser.me/api/portraits/men/8.jpg",
            university = "Universitas Padjadjaran",
            numCertificationsCompleted = 47
        ),
        User(
            id = 9,
            name = "Rachel Johnson",
            imageUrl = "https://randomuser.me/api/portraits/women/9.jpg",
            university = "Universitas Gadjah Mada",
            numCertificationsCompleted = 23
        ),
        User(
            id = 10,
            name = "Matthew Thompson",
            imageUrl = "https://randomuser.me/api/portraits/men/10.jpg",
            university = "Universitas Diponegoro",
            numCertificationsCompleted = 2
        )
    )

    fun getUsers(): Flow<List<User>> {
        // Dummy data
        return flowOf(dummyUser)
    }

    fun getUserById(userId: Int): User {
        return dummyUser.first { it.id == userId }
    }

    companion object {
        @Volatile
        private var instance: MainRepository? = null

        fun getInstance(): MainRepository =
            instance ?: synchronized(this) {
                MainRepository().apply {
                    instance = this
                }
            }
    }
}