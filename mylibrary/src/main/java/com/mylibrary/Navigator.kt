package com.mylibrary

import androidx.fragment.app.FragmentActivity
import com.mylibrary.R
import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment

object Navigator {
    fun loadFragment(
        activity: FragmentActivity,
        baseFragment: Fragment?,
        containerId: Int,
        isStacked: Boolean,
        s: String?
    ) {
        if (!isStacked) {
            activity.supportFragmentManager.beginTransaction().replace(containerId, baseFragment!!)
                .commitAllowingStateLoss()
        } else {
            activity.supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fadein, R.anim.fadeout)
                .replace(containerId, baseFragment!!)
                .addToBackStack(s).commit()
            //
        }
    }

    fun loadFragment2(
        activity: FragmentActivity,
        baseFragment: Fragment?,
        containerId: Int,
        isStacked: Boolean,
        s: String?
    ) {
        if (!isStacked) {
            activity.supportFragmentManager.beginTransaction().add(containerId, baseFragment!!)
                .commitAllowingStateLoss()
        } else {
            activity.supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fadein, R.anim.fadeout)
                .add(containerId, baseFragment!!)
                .addToBackStack(s).commit()
            //
        }
    }

    //    public static void goToAuthorizationActivity(Activity activity) {
    //
    //        activity.startActivity(new Intent(activity, AuthorizationActivity.class));
    //        activity.finish();
    //
    //    }
    fun goToHomeActivity(activity: Activity) {
        activity.startActivity(Intent(activity, MainActivity::class.java))
        activity.finish()
    }
}