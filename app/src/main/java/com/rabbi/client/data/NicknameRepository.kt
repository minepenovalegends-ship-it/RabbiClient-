package com.rabbi.client.data

import android.content.Context

class NicknameRepository(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun load(): String = prefs.getString(KEY_NICKNAME, DEFAULT_NICKNAME) ?: DEFAULT_NICKNAME

    fun save(nickname: String) {
        prefs.edit().putString(KEY_NICKNAME, nickname).apply()
    }

    private companion object {
        const val PREFS_NAME = "rabbi_client_prefs"
        const val KEY_NICKNAME = "nickname"
        const val DEFAULT_NICKNAME = "Player"
    }
}
