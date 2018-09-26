package com.turastory.kotlindemo.stub;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Exec {
    private static final int THREAD_COUNT = 3;
    
    private static final Object mainLock = new Object();
    private static final Object bgLock = new Object();
    
    private static Exec instance;
    
    private Executor main;
    private Executor background;
    
    private Exec() {
        this.main = new MainThreadExecutor();
        this.background = Executors.newFixedThreadPool(THREAD_COUNT);
    }
    
    public static MainThreadExecutor main() {
        synchronized (mainLock) {
            if (instance == null) {
                instance = new Exec();
            }
            
            return (MainThreadExecutor) instance.main;
        }
    }
    
    public static ThreadPoolExecutor background() {
        synchronized (bgLock) {
            if (instance == null) {
                instance = new Exec();
            }
            
            return (ThreadPoolExecutor) instance.background;
        }
    }
    
    public class MainThreadExecutor implements Executor {
        private Handler mainHandler = new Handler(Looper.getMainLooper());
        
        @Override
        public void execute(@NonNull Runnable command) {
            mainHandler.post(command);
        }
        
        public void executeLately(@NonNull Runnable command, int delayMillis) {
            mainHandler.postDelayed(command, delayMillis);
        }
    }
}
