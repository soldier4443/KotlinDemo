package com.turastory.kotlindemo.todo.app;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.annimon.stream.function.Consumer;
import com.turastory.kotlindemo.R;
import com.turastory.kotlindemo.stub.Exec;
import com.turastory.kotlindemo.stub.ExitInbrainTrainerDialog;
import com.turastory.kotlindemo.stub.InbrainDialogFragment;
import com.turastory.kotlindemo.stub.SimpleMessageDialog;

/**
 * Util class - object, overloading
 */
public class DialogUtils {
    private static final String MESSAGE_DIALOG = "message_dialog";
    
    // 간단한 메시지를 띄운다
    public static void message(FragmentManager fragmentManager, String message) {
        message(fragmentManager, message, SimpleMessageDialog.DO_NOT_DISMISS, null);
    }
    
    public static void message(FragmentManager fragmentManager, String message, Runnable onDismiss) {
        message(fragmentManager, message, SimpleMessageDialog.DO_NOT_DISMISS, onDismiss);
    }
    
    public static void message(FragmentManager fragmentManager, String message, int dismissTime) {
        message(fragmentManager, message, dismissTime, null);
    }
    
    public static void message(FragmentManager fragmentManager, String message, int dismissTime, Runnable onDismiss) {
        SimpleMessageDialog dialog = SimpleMessageDialog.newInstance(message);
        dialog.setOnDismiss(onDismiss);
        dialog.setDismissTime(dismissTime);
        showDialogInternal(fragmentManager, dialog, MESSAGE_DIALOG);
    }
    
    // 스킵 다이얼로그를 띄운다
    public static void skip(FragmentManager fm,
                            Consumer<? super InbrainDialogFragment> onClickYes) {
        showDialogInternal(fm, SkipConfirmationDialog.create(onClickYes), "skip");
    }
    
    public static void skip(FragmentManager fm,
                            Consumer<? super InbrainDialogFragment> onClickYes,
                            Consumer<? super InbrainDialogFragment> onClickNo) {
        showDialogInternal(fm, SkipConfirmationDialog.create(onClickYes, onClickNo), "skip");
    }
    
    // 로그인 페이지로 돌아가기
    public static void backLogin(FragmentActivity context,
                                 Consumer<? super InbrainDialogFragment> onClickYes) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        showDialogInternal(fragmentManager, ExitInbrainTrainerDialog.create(onClickYes, R.string.signup_back), "backLogin");
    }
    
    public static void backLogin(FragmentActivity context,
                                 Consumer<? super InbrainDialogFragment> onClickYes, int description) {
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        showDialogInternal(fragmentManager, ExitInbrainTrainerDialog.create(onClickYes, description), "backLogin");
    }
    
    private static void showDialogInternal(FragmentManager fm, DialogFragment dialog, String tag) {
        FragmentTransaction ft = fm.beginTransaction();
        
        Fragment prev = fm.findFragmentByTag(tag);
        if (prev != null) {
            Log.e("DialogUtils", "prev is not null - " + dialog.getClass().toString());
            return;
        }
        
        ft.addToBackStack(null);
        Exec.main().execute(() -> {
            if (!fm.isStateSaved()) {
                dialog.show(ft, tag);
            }
        });
    }
}
