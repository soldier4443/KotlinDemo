package com.turastory.kotlindemo.kotlin.app

import com.annimon.stream.Optional
import com.annimon.stream.function.Consumer
import com.turastory.kotlindemo.stub.YesOrNoDialogFragment

class SkipConfirmationDialog : YesOrNoDialogFragment() {

    private var onClickYes = Optional.empty<Consumer<in YesOrNoDialogFragment>>()
    private var onClickNo = Optional.empty<Consumer<in YesOrNoDialogFragment>>()

    companion object {
        @JvmOverloads
        fun create(onClickYes: Consumer<in YesOrNoDialogFragment>,
                   onClickNo: Consumer<in YesOrNoDialogFragment>? = null): SkipConfirmationDialog {
            val dialog = SkipConfirmationDialog()
            dialog.onClickYes = Optional.ofNullable(onClickYes)
            dialog.onClickNo = Optional.ofNullable(onClickNo)
            return dialog
        }
    }
}
