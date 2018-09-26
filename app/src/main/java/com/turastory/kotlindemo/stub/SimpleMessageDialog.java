package com.turastory.kotlindemo.stub;

import android.support.v4.app.DialogFragment;

public class SimpleMessageDialog extends DialogFragment {
    
    public static final int DO_NOT_DISMISS = -1;
    
    public static SimpleMessageDialog newInstance(String message) {
        return new SimpleMessageDialog();
    }
    
    public void setOnDismiss(Runnable onDismissListener) {
    
    }
    
    public void setDismissTime(int dismissTime) {
    
    }
}
