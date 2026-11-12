package com.example.pratikummobilerifa.Home.pertemuan_11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pratikummobilerifa.R
import com.example.pratikummobilerifa.databinding.ActivityEleventhBinding
import com.google.android.material.tabs.TabLayoutMediator

class ActivityEleventh : AppCompatActivity() {
    private lateinit var binding: ActivityEleventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEleventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 11 - TabLayout & RecyclerView"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val tabsAdapter = EleventhTabsAdapter(this)
        binding.viewPager.adapter = tabsAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
                1 -> {
                    tab.text = "Tab B"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 5
                }
                2 -> {
                    tab.text = "Tab C"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                }
            }
        }.attach()
    }
}
