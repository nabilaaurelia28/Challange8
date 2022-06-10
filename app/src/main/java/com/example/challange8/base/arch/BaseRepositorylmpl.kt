package com.example.challange8.base.arch

import android.util.Log

open class BaseRepositorylmpl {
    override fun logResponse(msg: String?) {
        Log.d(BaseRepositorylmpl::class.java.simpleName, msg.orEmpty())
    }
}