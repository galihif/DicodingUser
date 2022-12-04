package com.giftech.dicodinguser.di

import com.giftech.dicodinguser.data.MainRepository


object Injection {
    fun provideRepository(): MainRepository {
        return MainRepository.getInstance()
    }
}