package com.turastory.kotlindemo.stub;

import android.support.v4.app.DialogFragment;

public class PauseDialog extends DialogFragment {
    
    private Runnable onContinue;
    private Runnable onExit;
    private Runnable onSkip;
    
    public PauseDialog setOnContinue(Runnable onContinue) {
        this.onContinue = onContinue;
        return this;
    }
    
    public PauseDialog setOnExit(Runnable onExit) {
        this.onExit = onExit;
        return this;
    }
    
    public PauseDialog setOnSkip(Runnable onSkip) {
        this.onSkip = onSkip;
        return this;
    }
}
