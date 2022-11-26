package com.hcdisat.musicapp.artistchart.domain.factories

import com.hcdisat.musicapp.artistchart.models.ArtistChartItem
import com.hcdisat.musicapp.data.network.models.Artist

fun Artist.toArtistChart() {
    ArtistChartItem(
        artistId = id,
        name = name,
        picture = pictureSmall,
        position = position ?: 0,
        trackList = tracklist
    )
}

val artistChart = listOf<ArtistChartItem>(
    ArtistChartItem(
        artistId = 230,
        name = "Kanye West",
        picture = "https://e-cdns-images.dzcdn.net/images/artist/bb76c2ee3b068726ab4c37b0aabdb57a/250x250-000000-80-0-0.jpg",
        position = 1,
        trackList = "https://api.deezer.com/artist/230/top?limit=50"
    ),
    ArtistChartItem(
        artistId = 10583405,
        name = "Bad Bunny",
        picture = "https://e-cdns-images.dzcdn.net/images/artist/f21443a563e5d03ddf83ed1e6a12d581/250x250-000000-80-0-0.jpg",
        position = 2,
        trackList = "https://api.deezer.com/artist/10583405/top?limit=50"
    ),
    ArtistChartItem(
        artistId = 4860761,
        name = "J Balvin",
        picture = "https://e-cdns-images.dzcdn.net/images/artist/330420f615ec0c189bf9c729316f1558/250x250-000000-80-0-0.jpg",
        position = 3,
        trackList = "https://api.deezer.com/artist/4860761/top?limit=50"
    ),
)

