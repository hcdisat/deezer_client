package com.hcdisat.musicapp.ui.main.common.extensions

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

inline fun TabLayout.addOnTabSelectedListener(
    crossinline onTabUnselected: (TabLayout.Tab) -> Unit = { _ -> },
    crossinline onTabReselected: (TabLayout.Tab) -> Unit = { _ -> },
    crossinline onTabSelected: (TabLayout.Tab) -> Unit = { _ -> }
) {
    val listener = object : OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) = onTabSelected(tab)
        override fun onTabUnselected(tab: TabLayout.Tab) = onTabUnselected(tab)
        override fun onTabReselected(tab: TabLayout.Tab) = onTabReselected(tab)
    }

    addOnTabSelectedListener(listener)
}