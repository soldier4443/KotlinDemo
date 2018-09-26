package com.turastory.kotlindemo.kotlin.server

import com.turastory.kotlindemo.stub.TrainingUser
import java.util.*

/**
 * Created by tura on 2018-09-26.
 */
class Using {
    fun use() {
        FreeEventChecker.checkRegistrationTimeBefore(Date(), Date())
        DailyFreeTrainingGenerator.generate("CODE", TrainingUser())
        MusicLoader.loadMusics()

        val dayInMillis = DAY_IN_MILLIS
        val dateFormat = date
        getDate(2018, 9, 26)
        getDate(2018, 9, 26, 20, 4, 16)
        "2018-09-26 20:04:16".parseDay()
        Date().dayAfter(7)
        Date().dayBefore(7)
        Date() + 7
        Date() - 7

        var songInfo = SongInfo()
        songInfo = SongInfo("title", "artist", 3)
    }
}
