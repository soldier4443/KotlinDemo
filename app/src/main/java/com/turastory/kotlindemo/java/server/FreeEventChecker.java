package com.turastory.kotlindemo.java.server;

import java.util.Date;

/**
 * Util class - object, @JvmStatic
 */
public class FreeEventChecker {
    public static boolean checkRegistrationTimeBefore(Date registerTime, Date currentTime) {
        if (currentTime.before(registerTime))
            throw new IllegalArgumentException("current time < register time");
        
        // 5월 16일 이전에 가입했고, 가입한지 2주일이 안 됬으면 true
        return registerTime.before(DateFormatUtil.getDate(2018, 5, 16, 23, 59, 59)) &&
            currentTime.before(DateFormatUtil.dayAfter(registerTime, 14));
    }
}
