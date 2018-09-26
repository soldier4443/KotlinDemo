package com.turastory.kotlindemo.todo.server;

import com.turastory.kotlindemo.stub.TrainingUser;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by tura on 2018-09-26.
 */
public class Using {
    public void use() {
        FreeEventChecker.checkRegistrationTimeBefore(new Date(), new Date());
        DailyFreeTrainingGenerator.generate("CODE", new TrainingUser());
        MusicLoader.loadMusics();
        
        int dayInMillis = DateFormatUtil.DAY_IN_MILLIS;
        DateFormat dateFormat = DateFormatUtil.date;
        DateFormatUtil.getDate(2018, 9, 26);
        DateFormatUtil.getDate(2018, 9, 26, 20, 4, 16);
        DateFormatUtil.parseDay("2018-09-26 20:04:16");
        DateFormatUtil.dayAfter(new Date(), 7);
        DateFormatUtil.dayBefore(new Date(), 7);
        
        SongInfo songInfo = new SongInfo();
        songInfo = new SongInfo("title", "artist", 3);
    }
}
