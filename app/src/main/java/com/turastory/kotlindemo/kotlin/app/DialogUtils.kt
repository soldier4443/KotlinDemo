package com.turastory.kotlindemo.kotlin.app

import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.util.Log
import com.annimon.stream.function.Consumer
import com.turastory.kotlindemo.R
import com.turastory.kotlindemo.java.app.SkipConfirmationDialog
import com.turastory.kotlindemo.stub.Exec
import com.turastory.kotlindemo.stub.ExitInbrainTrainerDialog
import com.turastory.kotlindemo.stub.InbrainDialogFragment
import com.turastory.kotlindemo.stub.SimpleMessageDialog

/**
 * Util class - object, overloading
 */
object DialogUtils {
    private const val MESSAGE_DIALOG = "message_dialog"

    // 간단한 메시지를 띄운다
    @JvmOverloads
    @JvmStatic
    fun message(fragmentManager: FragmentManager, message: String, dismissTime: Int = SimpleMessageDialog.DO_NOT_DISMISS, onDismiss: Runnable? = null) {
        val dialog = SimpleMessageDialog.newInstance(message)
        dialog.setOnDismiss(onDismiss)
        dialog.setDismissTime(dismissTime)
        showDialogInternal(fragmentManager, dialog, MESSAGE_DIALOG)
    }

    // 스킵 다이얼로그를 띄운다
    @JvmOverloads
    @JvmStatic
    fun skip(fm: FragmentManager,
             onClickYes: Consumer<in InbrainDialogFragment>,
             onClickNo: Consumer<in InbrainDialogFragment>? = null) {
        showDialogInternal(fm, SkipConfirmationDialog.create(onClickYes, onClickNo), "skip")
    }

    // 로그인 페이지로 돌아가기
    @JvmOverloads
    @JvmStatic
    fun backLogin(context: FragmentActivity,
                  onClickYes: Consumer<in InbrainDialogFragment>,
                  description: Int = R.string.signup_back) {
        val fragmentManager = context.supportFragmentManager
        showDialogInternal(fragmentManager, ExitInbrainTrainerDialog.create(onClickYes, description), "backLogin")
    }

    private fun showDialogInternal(fm: FragmentManager, dialog: DialogFragment, tag: String) {
        val ft = fm.beginTransaction()

        val prev = fm.findFragmentByTag(tag)
        if (prev != null) {
            Log.e("DialogUtils", "prev is not null - " + dialog.javaClass.toString())
            return
        }

        ft.addToBackStack(null)
        Exec.main().execute {
            if (!fm.isStateSaved) {
                dialog.show(ft, tag)
            }
        }
    }
}
