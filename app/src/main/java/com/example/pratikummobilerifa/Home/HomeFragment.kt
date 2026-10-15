package com.example.pratikummobilerifa.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.pratikummobilerifa.AuthActivity
import com.example.pratikummobilerifa.Home.pertemuan_4.FourthActivity
import com.example.pratikummobilerifa.Home.pertemuan_5.FifthActivity
import com.example.pratikummobilerifa.Home.pertemuan_7.seventhActivity
import com.example.pratikummobilerifa.R
import com.example.pratikummobilerifa.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        binding.btnToFourth.setOnClickListener {
            val i = Intent(requireContext(), FourthActivity::class.java)

            // Masukkan data extra terlebih dahulu
            i.putExtra("name", "Politeknik Caltex Rifa")
            i.putExtra("from", "Rumbai")
            i.putExtra("age", 25)

            // Panggil startActivity HANYA SATU KALI di sini
            startActivity(i)
        }
        binding.btnToFifth.setOnClickListener {
            val i = Intent(requireContext(), FifthActivity::class.java)
            startActivity(i)
        }

        binding.btnToSeventh.setOnClickListener {
            val i = Intent(requireContext(), seventhActivity::class.java)
            startActivity(i)
        }

    }
}
