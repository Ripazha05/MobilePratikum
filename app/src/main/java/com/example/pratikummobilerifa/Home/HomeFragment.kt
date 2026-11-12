package com.example.pratikummobilerifa.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pratikummobilerifa.Home.pertemuan_4.FourthActivity
import com.example.pratikummobilerifa.Home.pertemuan_5.FifthActivity
import com.example.pratikummobilerifa.Home.pertemuan_7.seventhActivity
import com.example.pratikummobilerifa.databinding.FragmentHomeBinding
import com.google.android.material.chip.Chip

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        binding.btnMenu1.setOnClickListener {
            val i = Intent(requireContext(), FourthActivity::class.java)
            i.putExtra("name", "Politeknik Caltex Rifa")
            i.putExtra("from", "Rumbai")
            i.putExtra("age", 25)
            startActivity(i)
        }
        binding.btnMenu2.setOnClickListener {
            val i = Intent(requireContext(), FifthActivity::class.java)
            startActivity(i)
        }
        binding.btnMenu3.setOnClickListener {
            val i = Intent(this@HomeFragment.requireContext(), seventhActivity::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            Toast.makeText(requireContext(), "Login email: $email", Toast.LENGTH_SHORT).show()
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                if (chip != null) {
                    Toast.makeText(requireContext(), "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
