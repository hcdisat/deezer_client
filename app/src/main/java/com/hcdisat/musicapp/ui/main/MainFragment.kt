package com.hcdisat.musicapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import com.hcdisat.musicapp.R
import com.hcdisat.musicapp.common.extensions.gone
import com.hcdisat.musicapp.common.extensions.visible
import com.hcdisat.musicapp.databinding.FragmentMainBinding
import com.hcdisat.musicapp.ui.main.adapters.ArtistChartAdapter
import com.hcdisat.musicapp.ui.main.common.extensions.addOnTabSelectedListener
import com.hcdisat.musicapp.ui.main.common.extensions.toTabChartType
import com.hcdisat.musicapp.ui.main.events.TabEvent
import com.hcdisat.musicapp.ui.main.models.ChartType
import com.hcdisat.musicapp.ui.main.models.ChartsUIState
import com.hcdisat.musicapp.ui.main.models.StateData
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

    private val artistChartAdapter by lazy {
        ArtistChartAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chartList.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        binding.tabLayout.addOnTabSelectedListener(onTabSelected = ::onTabSelected)

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
                binding.tvSectionHeader.text = getString(R.string.tab_artists)
                binding.chartList.apply {
                    artistChartAdapter.artistChartItems = stateData.artistChart
                    adapter = artistChartAdapter
                }
            }
            ChartType.TRACKS -> {
                binding.tvSectionHeader.text = getString(R.string.tab_tracks)
                binding.chartList.apply {
                    artistChartAdapter.artistChartItems = stateData.artistChart
                    adapter = artistChartAdapter
                }
            }
            ChartType.ALBUMS -> {
                binding.tvSectionHeader.text = getString(R.string.tab_albums)
                binding.chartList.apply {
                    artistChartAdapter.artistChartItems = stateData.artistChart
                    adapter = artistChartAdapter
                }
            }
        }
    }

    private fun handleLoading(showLoading: Boolean) {
        if (showLoading) {
            binding.loading.visible()
            binding.flow.gone()
        } else {
            binding.loading.gone()
            binding.flow.visible()
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

    private fun onTabSelected(tab: TabLayout.Tab) {
        val event = when (tab.position.toTabChartType()) {
            ChartType.ARTISTS -> TabEvent.ArtistSelected
            ChartType.TRACKS -> TabEvent.TracksSelected
            ChartType.ALBUMS -> TabEvent.AlbumsSelected
        }

        viewModel.submitEvent(event)
    }
}