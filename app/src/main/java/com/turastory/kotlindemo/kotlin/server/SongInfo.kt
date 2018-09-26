package com.turastory.kotlindemo.kotlin.server

/**
 * VO - data class
 */
data class SongInfo(var title: String? = null,
                    var artist: String? = null,
                    var difficulty: Int = 0)