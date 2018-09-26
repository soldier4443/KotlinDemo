package com.turastory.kotlindemo.todo.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.annimon.stream.function.Consumer;
import com.turastory.kotlindemo.stub.InbrainDialogFragment;

/**
 * Created by tura on 2018-09-26.
 */
public class UsingOverloads extends AppCompatActivity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        FragmentManager fm = getSupportFragmentManager();
        
        DialogUtils.message(fm, "asdf");
        DialogUtils.message(fm, "asdf", stub());
        DialogUtils.message(fm, "asdf", 100);
        DialogUtils.message(fm, "asdf", 100, stub());
        
        DialogUtils.skip(fm, dialogStub());
        DialogUtils.skip(fm, dialogStub(), dialogStub());
        
        DialogUtils.backLogin(this, dialogStub());
        DialogUtils.backLogin(this, dialogStub(), 0);
    }
    
    private Runnable stub() {
        return () -> {
        };
    }
    
    private Consumer<? super InbrainDialogFragment> dialogStub() {
        return dialog -> {
        };
    }
}
