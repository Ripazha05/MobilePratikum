package com.example.pratikummobilerifa.Home

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
import com.example.pratikummobilerifa.Home.pertemuan_10.TenthActivity
import com.example.pratikummobilerifa.Home.pertemuan_11.ActivityEleventh
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
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Dashboard"
        }

        binding.btnToFourth.setOnClickListener {
            val i = Intent(requireContext(), FourthActivity::class.java)
            i.putExtra("name", "Politeknik Caltex Rifa")
            i.putExtra("from", "Rumbai")
            i.putExtra("age", 25)
            startActivity(i)
        }

        binding.btnToFifth.setOnClickListener {
            val i = Intent(requireContext(), ActivityEleventh::class.java) // wait, FifthActivity
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSeventh.setOnClickListener {
            val i = Intent(requireContext(), seventhActivity::class.java)
            startActivity(i)
        }

        binding.btnToPertemuan10.setOnClickListener {
            val i = Intent(requireContext(), TenthActivity::class.java)
            startActivity(i)
        }

        binding.btnToEleventh.setOnClickListener {
            val i = Intent(requireContext(), ActivityEleventh::class.java)
            startActivity(i)
        }

        binding.btnToAuth.setOnClickListener {
            val i = Intent(requireContext(), AuthActivity::class.java)
            startActivity(i)
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi_Logout")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val sharedPref = requireActivity().getSharedPreferences("user_pref", android.content.Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
