package com.trinitymirror.fabtobottomnavigationsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trinitymirror.fabtobottomnavigation.FabToBottomNavigationAnim
import com.trinitymirror.fabtobottomnavigation.util.BottomNavigationViewBehavior
import com.trinitymirror.fabtobottomnavigationsample.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var anim: FabToBottomNavigationAnim

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listFab.setOnClickListener(onFabClickListener)

        binding.listNavigation.setOnItemSelectedListener(mOnItemSelectedListener)

        val layoutParams = binding.listNavigation.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior =
            BottomNavigationViewBehavior(object : BottomNavigationViewBehavior.Callback {
                override fun onSlideUp() {
                    anim.hideNavigationView()
                }

                override fun onSlideDown() {
                    anim.hideNavigationView()
                }
            })

        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = MyAdapter()

        anim = FabToBottomNavigationAnim(binding.listFab, binding.listNavigation)
    }

    private fun animateFabToBottomNav() {
        anim.showNavigationView()
    }

    private val onFabClickListener: View.OnClickListener = View.OnClickListener {
        animateFabToBottomNav()
    }


    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    @SuppressLint("SetTextI18n")
    private val mOnItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                binding.listMessage.text = "Selected: ${getString(R.string.title_home)}"
                true
            }
            R.id.navigation_dashboard -> {
                binding.listMessage.text = "Selected: ${getString(R.string.title_dashboard)}"
                true
            }
            R.id.navigation_notifications -> {
                binding.listMessage.text = "Selected: ${getString(R.string.title_notifications)}"
                true
            }
            else -> false
        }
    }
}

