package com.hcdisat.musicapp.artistchart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hcdisat.musicapp.databinding.FragmentArtistChartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistChartFragment : Fragment() {
    companion object {
        const val TAG = "ArtistChartFragment"
        fun newInstance() = ArtistChartFragment()
    }

    private var _binding: FragmentArtistChartBinding? = null
    private val binding: FragmentArtistChartBinding get() = _binding!!

    private val viewModel: ArtistChartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArtistChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}