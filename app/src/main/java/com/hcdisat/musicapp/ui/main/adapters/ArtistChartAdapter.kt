package com.hcdisat.musicapp.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hcdisat.musicapp.databinding.ChartArtistItemBinding
import com.hcdisat.musicapp.ui.main.adapters.viewHolders.ArtistChartViewHolder
import com.hcdisat.musicapp.ui.models.ArtistChartItem
import kotlin.properties.Delegates

class ArtistChartAdapter : RecyclerView.Adapter<ArtistChartViewHolder>() {

    var artistChartItems: List<ArtistChartItem> by Delegates.observable(
        listOf()
    ) { _, _, newValue ->
        notifyItemRangeChanged(0, newValue.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistChartViewHolder =
        ArtistChartViewHolder(
            ChartArtistItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ArtistChartViewHolder, position: Int) {
        holder.bind(artistChartItems[position])
    }

    override fun getItemCount() = artistChartItems.size
}