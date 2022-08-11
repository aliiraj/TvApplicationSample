package com.example.tvapplicationsample.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.tvapplicationsample.presentation.home.MainFragment
import com.example.tvapplicationsample.R

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}