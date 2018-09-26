package com.turastory.kotlindemo.kotlin.server

import java.io.File

/**
 * Util class - FILE I/O
 */
object MusicLoader {
    @JvmStatic
    fun loadMusics(): Map<SongInfo, List<String>> {
        println("================================ Initiate import process... ================================")

        LyricsReader().let {
            File("/music/music_renewal.csv").forEachLine { line ->
                it.decodeLine(line)
            }

            it.yieldResults()

            return it.decodedResults
        }
    }
}