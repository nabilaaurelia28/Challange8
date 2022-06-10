package com.example.challange8.base.arch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress
class GenericViewModelFactory (private val viewModel: ViewModel): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(viewModel::class.java) -> {
                return viewModel as T
            }
            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}