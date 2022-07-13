package com.test.multitab.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.multitab.data.entities.User
import com.test.multitab.data.repository.UserRepository
import com.test.multitab.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor( private val userRepository: UserRepository): ViewModel(){

    private val _state = MutableStateFlow(emptyList<User>())
    val state : StateFlow<List<User>> get() = _state
    private val _userCreateState = MutableStateFlow(false)
    val userCreateState : StateFlow<Boolean> get() = _userCreateState

    init {
        getUsersList()
    }

    private fun getUsersList() = viewModelScope.launch {
        userRepository.getUserList().let {
            if (it.isSuccessful){
                _state.value = Resource.success(it.body()).data!!
            }
        }
    }

     fun deleteUser(user: User) = viewModelScope.launch {
        userRepository.delete(user).let {
            if (it.isSuccessful){
                getUsersList()
            }
        }
    }


     fun createUser(user: User) = viewModelScope.launch {
        userRepository.createUser(user).let {
            Log.e("TAG", "createUser: ${it.body()}", )
            if (it.isSuccessful){
                getUsersList()
                _userCreateState.value = true
            }
        }
    }

}