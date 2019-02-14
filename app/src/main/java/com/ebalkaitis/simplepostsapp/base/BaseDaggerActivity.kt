package com.ebalkaitis.simplepostsapp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseDaggerActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int
}
