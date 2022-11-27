package com.hcdisat.musicapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.hcdisat.musicapp.R
import com.hcdisat.musicapp.common.extensions.gone
import com.hcdisat.musicapp.common.extensions.visible
import com.hcdisat.musicapp.databinding.FragmentMainBinding
import com.hcdisat.musicapp.ui.models.ChartType
import com.hcdisat.musicapp.ui.models.ChartsUIState
import com.hcdisat.musicapp.ui.models.StateData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.uiState.flowWithLifecycle(
                lifecycle,
                Lifecycle.State.CREATED
            ).collect(::handleState)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun loadAChart(stateData: StateData) {
        when (stateData.selectedChart) {
            ChartType.ARTISTS -> {
                binding.tvSectionHeader.text = getString(R.string.chart_artist_title)
                Log.d("TAG", "loadArtistChart: $stateData")
            }
            ChartType.TRACKS -> TODO()
            ChartType.ALBUMS -> TODO()
        }
    }

    private fun handleLoading(showLoading: Boolean) {
        if (showLoading) {
            binding.loading.visible()
            binding.group.gone()
        } else {
            binding.loading.gone()
            binding.group.visible()
        }
    }

    private fun handleState(uiState: ChartsUIState) {
        when (uiState) {
            is ChartsUIState.Completed -> {
                loadAChart(uiState.data)
                handleLoading(false)
            }
            is ChartsUIState.Failed -> {
                uiState.throwable.printStackTrace()
                handleLoading(false)
            }
            ChartsUIState.Loading -> handleLoading(true)
        }
    }
}