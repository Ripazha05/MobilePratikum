package com.example.pratikummobilerifa.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pratikummobilerifa.AuthActivity
import com.example.pratikummobilerifa.Home.pertemuan_4.FourthActivity
import com.example.pratikummobilerifa.Home.pertemuan_5.FifthActivity
import com.example.pratikummobilerifa.Home.pertemuan_7.seventhActivity
import com.example.pratikummobilerifa.Home.pertemuan_10.TenthActivity
import com.example.pratikummobilerifa.Home.pertemuan_11.ActivityEleventh
import com.example.pratikummobilerifa.Home.photo.PhotoAdapter
import com.example.pratikummobilerifa.data.api.CatFactApiClient
import com.example.pratikummobilerifa.data.api.PhotoApiClient
import com.example.pratikummobilerifa.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch

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

        loadCatFact()

        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        loadPhoto()

        binding.btnToFourth.setOnClickListener {
            val i = Intent(requireContext(), FourthActivity::class.java)
            i.putExtra("name", "Politeknik Caltex Rifa")
            i.putExtra("from", "Rumbai")
            i.putExtra("age", 25)
            startActivity(i)
        }

        binding.btnToFifth.setOnClickListener {
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

    private fun loadCatFact() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                _binding?.tvCatFact?.text = "\"${response.fact}\""
            } catch (e: Exception) {
                _binding?.tvCatFact?.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                _binding?.rvGallery?.adapter = adapter

                /** List Tampil Vertical*/
                _binding?.rvGallery?.layoutManager = LinearLayoutManager(requireContext())

                /** List Tampil Horizontal */
                //_binding?.rvGallery?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                /** List Tampil Grid */
                //_binding?.rvGallery?.layoutManager = GridLayoutManager(requireContext(), 2)

            } catch (e: Exception) {
                if (_binding != null) {
                    Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
