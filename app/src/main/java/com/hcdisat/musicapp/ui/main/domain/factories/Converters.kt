package com.hcdisat.musicapp.ui.main.domain.factories

import com.hcdisat.musicapp.data.network.models.Album
import com.hcdisat.musicapp.data.network.models.Artist
import com.hcdisat.musicapp.data.network.models.Track
import com.hcdisat.musicapp.ui.main.models.AlbumChartItem
import com.hcdisat.musicapp.ui.main.models.ArtistChartItem
import com.hcdisat.musicapp.ui.main.models.TracksChartItem

fun Artist.toArtistChart() = ArtistChartItem(
    artistId = id,
    name = name,
    picture = pictureMedium,
    position = position ?: 0,
    trackList = tracklist
)

fun Track.toTracksChartItem() =
    TracksChartItem(
        trackId = id,
        artistId = artist.id,
        artistName = artist.name,
        position = position,
        title = title,
        rank = rank,
        picture = md5Image
    )

fun Album.toAlbumChartItem() =
    AlbumChartItem(
        albumId = id,
        artistId = artist.id,
        cover = coverMedium,
        position = position,
        title = title
    )

