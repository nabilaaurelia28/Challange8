package com.example.challange8.base.arch

import android.util.Log

open class BaseViewModellmpl : ViewModel(), BaseContract.BaseViewModel {
    override fun logResponse(msg: String?) {
        Log.d(BaseViewModellmpl::class.java.simpleName, msg.orEmpty())
    }
}