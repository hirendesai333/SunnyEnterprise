package com.example.sunnyenterprise.utils

import android.content.Context

class Preferences(context: Context) {

    val APP_PREFERENCE = "app_preferences"

    val MOBILE = "email"
    val ID = "id"

    val PREFERENCE = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE)
    val editor = PREFERENCE.edit()

    fun setMobile(mobile: String) {
        editor.putString(MOBILE, mobile)
        editor.apply()
    }

    fun getMobile(): String {
        return PREFERENCE.getString(MOBILE, "")!!
    }

    fun setId(id: Long) {
        editor.putLong(ID, id)
        editor.apply()
    }

    fun getId(): Long {
        return PREFERENCE.getLong(ID, 0)
    }

    fun logOut() {
        editor.clear()
        editor.commit()
        editor.apply()
    }
}