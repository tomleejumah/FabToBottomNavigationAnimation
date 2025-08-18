package com.trinitymirror.fabtobottomnavigationsample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trinitymirror.fabtobottomnavigation.FabToBottomNavigationAnim
import com.trinitymirror.fabtobottomnavigationsample.databinding.ActivitySampleBinding


class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleBinding
    private lateinit var anim: FabToBottomNavigationAnim

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener(onFabClickListener)
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        binding.button.setOnClickListener(onButtonClickListener)

        anim = FabToBottomNavigationAnim(binding.fab, binding.navigation)
    }

    private fun animateFabToBottomNav() {
        anim.showNavigationView()
    }

    private fun animateBottomNavToFab() {
        anim.hideNavigationView()
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    private val onButtonClickListener = View.OnClickListener {
        animateBottomNavToFab()
    }

    private val onFabClickListener = View.OnClickListener {
        animateFabToBottomNav()
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    binding.message.setText(R.string.title_home)
                    true
                }
                R.id.navigation_dashboard -> {
                    binding.message.setText(R.string.title_dashboard)
                    true
                }
                R.id.navigation_notifications -> {
                    binding.message.setText(R.string.title_notifications)
                    true
                }
                else -> false
            }
        }
}

