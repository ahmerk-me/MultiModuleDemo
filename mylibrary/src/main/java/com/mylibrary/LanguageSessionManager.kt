package com.mylibrary

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.mylibrary.LanguageSessionManager

/**
 * Created by webuser1 on 6/14/2015.
 */
class LanguageSessionManager @SuppressLint("CommitPrefEdits") constructor(var _context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var PRIVATE_MODE = 0
    var lang: String?
        get() = pref.getString(KEY_Lang, "en")
        set(lang) {
            editor.putString(KEY_Lang, lang)
            editor.commit()
        }
    var regId: String?
        get() = pref.getString(KEY_RegID, "")
        set(id) {
            editor.putString(KEY_RegID, id)
            editor.commit()
        }
    val isRegIdToken: Boolean
        get() = pref.getBoolean(IS_Registered, false)

    // Storing notification value as TRUE
    // Get Notification Status
    var notificationStatus: Boolean?
        get() =// Get Notification Status
            pref.getBoolean(KEY_NotificationStatus, false)
        set(status) {
            // Storing notification value as TRUE
            editor.putBoolean(KEY_NotificationStatus, status!!)
            editor.commit()
        }

    companion object {
        private const val PREF_NAME = "com.ais.pref.lang"
        const val KEY_Lang = "KEY_Lang"
        const val KEY_RegID = "regId"
        const val KEY_NotificationStatus = "NotificationStatus"
        private const val IS_Registered = "IsRegistered"
    }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
}