package com.ebalkaitis.simplepostsapp.utils.extensions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.ebalkaitis.simplepostsapp.R

fun FragmentActivity.replaceFragment(fragment: Fragment, container: Int = R.id.fragmentContainer) {
    supportFragmentManager.beginTransaction()
        .replace(container, fragment)
        .commit()
}
