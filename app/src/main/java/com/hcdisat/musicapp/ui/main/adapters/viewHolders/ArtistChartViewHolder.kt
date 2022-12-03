package com.hcdisat.musicapp.ui.main.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.hcdisat.musicapp.databinding.ChartArtistItemBinding
import com.hcdisat.musicapp.ui.main.models.ArtistChartItem
import com.squareup.picasso.Picasso

class ArtistChartViewHolder(
    private val binding: ChartArtistItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ArtistChartItem) {
        binding.apply {
            Picasso.get().load(item.picture)
                .into(cover)
            tvName.text = item.name
            tvPosition.text = item.position.toString()
        }
    }
}