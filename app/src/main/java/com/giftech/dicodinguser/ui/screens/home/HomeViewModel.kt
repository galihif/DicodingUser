package com.giftech.dicodinguser.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giftech.dicodinguser.data.MainRepository
import com.giftech.dicodinguser.model.User
import com.giftech.dicodinguser.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MainRepository
) :ViewModel(){

    private val _uiState: MutableStateFlow<UiState<List<User>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<User>>>
        get() = _uiState

    fun getAllUser(){
        viewModelScope.launch {
            repository.getUsers()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{
                    _uiState.value = UiState.Success(it)
                }
        }
    }
}