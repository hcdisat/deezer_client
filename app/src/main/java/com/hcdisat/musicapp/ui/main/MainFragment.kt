package com.hcdisat.musicapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hcdisat.musicapp.R
import com.hcdisat.musicapp.artistchart.ui.ArtistChartFragment
import com.hcdisat.musicapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.run {
            ArtistChartFragment.newInstance().also {
                navigateTo(it, ArtistChartFragment.TAG)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun navigateTo(fragment: Fragment, tag: String) {
        activity?.run {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment, tag)
                .commit()
        }
    }
}