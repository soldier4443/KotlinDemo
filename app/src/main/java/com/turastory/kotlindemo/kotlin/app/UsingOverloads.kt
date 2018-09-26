package com.turastory.kotlindemo.kotlin.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.annimon.stream.function.Consumer
import com.turastory.kotlindemo.stub.InbrainDialogFragment

/**
 * Created by tura on 2018-09-26.
 */
class UsingOverloads : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fm = supportFragmentManager

        DialogUtils.message(fm, "asdf")
        DialogUtils.message(fm, "asdf", onDismiss = stub())
        DialogUtils.message(fm, "asdf", dismissTime = 100)
        DialogUtils.message(fm, "asdf", 100, stub())

        DialogUtils.skip(fm, dialogStub())
        DialogUtils.skip(fm, dialogStub(), dialogStub())

        DialogUtils.backLogin(this, dialogStub())
        DialogUtils.backLogin(this, dialogStub(), 0)
    }

    private fun stub(): Runnable {
        return Runnable { }
    }

    private fun dialogStub(): Consumer<in InbrainDialogFragment> {
        return Consumer { }
    }
}
