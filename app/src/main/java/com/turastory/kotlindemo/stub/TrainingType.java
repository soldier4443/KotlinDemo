package com.turastory.kotlindemo.stub;

import java.util.ArrayList;
import java.util.List;

public class TrainingType {
    public final String name;
    
    TrainingType(String name) {
        this.name = name;
    }
    
    public static List<TrainingType> getFreeTrainingTypeForNewUser() {
        return new ArrayList<>();
    }
    
    public static List<TrainingType> getFreeTrainingType() {
        return new ArrayList<>();
    }
}
