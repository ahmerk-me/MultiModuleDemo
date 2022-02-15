package com.mylibrary

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by webuser1 on 6/14/2015.
 */
class SessionManager @SuppressLint("CommitPrefEdits") constructor(var _context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var PRIVATE_MODE = 0
    fun LoginSeassion() {
        editor.putBoolean(IS_LOGGED, true)
        editor.commit()
    }

    val isLoggedin: Boolean
        get() = pref.getBoolean(IS_LOGGED, false)
    var isFirstTime: Boolean
        get() = pref.getBoolean(IsFirstTime, true)
        set(isFirstTime) {
            editor.putBoolean(IsFirstTime, isFirstTime)
            editor.commit()
        }

    fun logout() {
        editor.putBoolean(IS_LOGGED, false)
        editor.commit()
    }

    var userCode: String?
        get() = pref.getString(UserCode, "0")
        set(code) {
            editor.putString(UserCode, code)
            editor.commit()
        }
    var fragType: Int
        get() = pref.getInt(FragType, 1)
        set(code) {
            editor.putInt(FragType, code)
            editor.commit()
        }
    var userAddress: String?
        get() = pref.getString(UserAddress, "")
        set(address) {
            editor.putString(UserAddress, address)
            editor.commit()
        }
    var userName: String?
        get() = pref.getString(UserName, "")
        set(name) {
            editor.putString(UserName, name)
            editor.commit()
        }
    var userPassword: String?
        get() = pref.getString(UserPassword, "")
        set(password) {
            editor.putString(UserPassword, password)
            editor.commit()
        }
    var userMobile: String?
        get() = pref.getString(UserMobile, "")
        set(mob) {
            editor.putString(UserMobile, mob)
            editor.commit()
        }
    var userEmail: String?
        get() = pref.getString(UserEmail, "")
        set(email) {
            editor.putString(UserEmail, email)
            editor.commit()
        }
    var userCountryId: String?
        get() = pref.getString(UserCountryId, "")
        set(id) {
            editor.putString(UserCountryId, id)
            editor.commit()
        }
    var userCurrencyCode: String?
        get() = pref.getString(UserCurrencyCode, "")
        set(userCurrencyId) {
            editor.putString(UserCurrencyCode, userCurrencyId)
            editor.commit()
        }
    var guestUserId: String?
        get() = pref.getString(GuestUserId, "0")
        set(code) {
            editor.putString(GuestUserId, code)
            editor.commit()
        }
    var token: String?
        get() = pref.getString(Token, "")
        set(code) {
            editor.putString(Token, code)
            editor.commit()
        }

    fun vendor() {
        editor.putBoolean(IsVendor, true)
        editor.commit()
    }

    fun customer() {
        editor.putBoolean(IsVendor, false)
        editor.commit()
    }

    val isVendor: Boolean
        get() = pref.getBoolean(IsVendor, false)
    var recentlyViewArrayList: String?
        get() = pref.getString(RecentlyViewArrayList, "")
        set(token) {
            editor.putString(RecentlyViewArrayList, token)
            editor.commit()
        }
    var versionName: String?
        get() = pref.getString(VersionName, "0")
        set(version) {
            editor.putString(VersionName, version)
            editor.commit()
        }

    fun changeNotification(status: Boolean) {
        editor.putBoolean(IsNotificationOn, status)
        editor.commit()
    }

    val isNotificationOn: Boolean
        get() = pref.getBoolean(IsNotificationOn, true)

    companion object {
        private const val PREF_NAME = "com.camouflage.pref"
        private const val IS_LOGGED = "isLogged"
        private const val UserCode = "UserCode"
        private const val UserAddress = "UserAddress"
        private const val UserEmail = "UserEmail"
        private const val UserName = "UserName"
        private const val UserPassword = "UserPassword"
        private const val UserMobile = "UserMobile"
        private const val UserCountryId = "UserCountryId"
        private const val IsFirstTime = "IsFirstTime"
        private const val UserCurrencyCode = "UserCurrencyCode"
        private const val GuestUserId = "GuestUserId"
        private const val Token = "Token"
        private const val IsVendor = "IsVendor"
        private const val RecentlyViewArrayList = "RecentlyViewArrayList"
        private const val IsNotificationOn = "IsNotificationOn"
        private const val FragType = "FragType"
        private const val VersionName = "VersionName"
    }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
}