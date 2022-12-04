package com.giftech.dicodinguser.data

import com.giftech.dicodinguser.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MainRepository {

    val dummyUser = listOf(
        User(
            id = 1,
            name = "John Doe",
            imageUrl = "https://randomuser.me/api/portraits/women/1.jpg",
            university = "University of California, Berkeley",
            numCertificationsCompleted = 5
        ),
        User(
            id = 2,
            name = "Jane Doe",
            imageUrl = "https://randomuser.me/api/portraits/men/1.jpg",
            university = "University of California, Los Angeles",
            numCertificationsCompleted = 3
        ),
        User(
            id = 3,
            name = "Alice Smith",
            imageUrl = "https://i.pravatar.cc/150?img=1",
            university = "Stanford University",
            numCertificationsCompleted = 7
        )
    )

    fun getUsers(): Flow<List<User>> {
        // Dummy data
        return flowOf(dummyUser)
    }

    fun getUserById(userId: Int): User? {
        return dummyUser.firstOrNull { it.id == userId }
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