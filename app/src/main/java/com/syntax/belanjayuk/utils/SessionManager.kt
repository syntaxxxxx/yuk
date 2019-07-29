package com.syntax.belanjayuk.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(val context: Context) {

    fun getPreference(): SharedPreferences {
        val getPreference =
            context.getSharedPreferences("com.syntax.belanjayuk", 0)
        return getPreference
    }
}