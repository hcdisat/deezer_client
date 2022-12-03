package com.hcdisat.musicapp.ui.main.events

sealed interface Events

sealed interface TabEvent : Events {
    object ArtistSelected : TabEvent
    object TracksSelected : TabEvent
    object AlbumsSelected : TabEvent
}