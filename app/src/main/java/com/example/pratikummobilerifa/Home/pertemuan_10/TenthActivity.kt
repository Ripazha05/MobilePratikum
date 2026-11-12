package com.example.pratikummobilerifa.Home.pertemuan_10

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pratikummobilerifa.Home.pertemuan_4.FourthActivity
import com.example.pratikummobilerifa.Home.pertemuan_5.FifthActivity
import com.example.pratikummobilerifa.Home.pertemuan_7.seventhActivity
import com.example.pratikummobilerifa.R
import com.example.pratikummobilerifa.databinding.ActivityTenthBinding
import com.google.android.material.chip.Chip

class TenthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 10"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        binding.btnMenu1.setOnClickListener {
            val i = Intent(this, FourthActivity::class.java)
            i.putExtra("name", "Politeknik Caltex Rifa")
            i.putExtra("from", "Rumbai")
            i.putExtra("age", 25)
            startActivity(i)
        }
        binding.btnMenu2.setOnClickListener {
            val i = Intent(this, FifthActivity::class.java)
            startActivity(i)
        }
        binding.btnMenu3.setOnClickListener {
            val i = Intent(this, seventhActivity::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            Toast.makeText(this, "Login email: $email", Toast.LENGTH_SHORT).show()
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                if (chip != null) {
                    Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
