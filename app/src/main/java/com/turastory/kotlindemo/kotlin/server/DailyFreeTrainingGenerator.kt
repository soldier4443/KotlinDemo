package com.turastory.kotlindemo.kotlin.server

import com.turastory.kotlindemo.stub.TrainingType
import com.turastory.kotlindemo.stub.TrainingUser
import java.util.*

/**
 * usage
 */
object DailyFreeTrainingGenerator {
    @JvmStatic
    fun generate(lastTrainingType: String, user: TrainingUser): TrainingType {
        val current = Date()
        val dateString = user.registerTime
        val registerDay = dateString.parseDay()

        //가입한지 7일 이내이면
        if (current < registerDay + 7) {
            //신규 유저 선호도 높은 과제 위주로 열기
            TrainingType.getFreeTrainingTypeForNewUser()
                .forEach { item ->
                    // 어제와 같은 훈련 하지 않도록
                    if (item.name != lastTrainingType)
                        return item
                }
        }

        TrainingType.getFreeTrainingType()
            .forEach { item ->
                if (item.name != lastTrainingType)
                    return item
            }

        throw IllegalStateException("Should not reach here.")
    }
}