package com.turastory.kotlindemo.java.server;

import com.turastory.kotlindemo.stub.TrainingType;
import com.turastory.kotlindemo.stub.TrainingUser;

import java.util.Date;
import java.util.List;

/**
 * usage
 */
public class DailyFreeTrainingGenerator {
    
    public static TrainingType generate(String lastTrainingType, TrainingUser user) {
        List<TrainingType> trainingTypes;
        
        Date current = new Date();
        String dateString = user.getRegisterTime();
        Date registerDay = DateFormatUtil.parseDay(dateString);
        
        //가입한지 7일 이내이면
        if (current.before(DateFormatUtil.dayAfter(registerDay, 7))) {
            //신규 유저 선호도 높은 과제 위주로 열기
            trainingTypes = TrainingType.getFreeTrainingTypeForNewUser();
            for (TrainingType item : trainingTypes) {// 어제와 같은 훈련 하지 않도록
                if (!item.name.equals(lastTrainingType))
                    return item;
            }
        }
        
        trainingTypes = TrainingType.getFreeTrainingType();
        for (TrainingType item : trainingTypes) { // 어제와 같은 훈련 하지 않도록
            if (!item.name.equals(lastTrainingType))
                return item;
        }
        
        throw new IllegalStateException("Should not reach here.");
    }
}