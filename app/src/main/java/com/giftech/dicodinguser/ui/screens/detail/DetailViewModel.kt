package com.giftech.dicodinguser.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giftech.dicodinguser.data.MainRepository
import com.giftech.dicodinguser.model.User
import com.giftech.dicodinguser.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: MainRepository
) :ViewModel(){
    private val _uiState: MutableStateFlow<UiState<User>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<User>>
        get() = _uiState

    fun getUserById(userId:Int){
        viewModelScope.launch {
            _uiState.value =UiState.Loading
            _uiState.value = UiState.Success(repository.getUserById(userId))
        }
    }
}