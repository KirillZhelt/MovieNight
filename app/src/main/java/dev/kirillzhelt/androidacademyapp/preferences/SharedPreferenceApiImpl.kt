package dev.kirillzhelt.androidacademyapp.preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceApiImpl(context: Context): SharedPreferenceApi {

    companion object {
        private const val CACHE_SHARED_PREFS = "CACHE_SHARED_PREFS"

        private const val LAST_CACHE_TIME = "LAST_CACHE_TIME"
    }

    private val sharedPreferences = context.getSharedPreferences(CACHE_SHARED_PREFS, Context.MODE_PRIVATE)

    override var lastCacheTime: Long
        get() {
            return sharedPreferences.getLong(LAST_CACHE_TIME, 0)
        }
        set(value) {
            with (sharedPreferences.edit()) {
                putLong(LAST_CACHE_TIME, value)
                commit()
            }
        }
}