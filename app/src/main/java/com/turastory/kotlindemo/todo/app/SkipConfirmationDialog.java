package com.turastory.kotlindemo.todo.app;

import com.annimon.stream.Optional;
import com.annimon.stream.function.Consumer;
import com.turastory.kotlindemo.stub.YesOrNoDialogFragment;

public class SkipConfirmationDialog extends YesOrNoDialogFragment {
    
    private Optional<Consumer<? super YesOrNoDialogFragment>> onClickYes = Optional.empty();
    private Optional<Consumer<? super YesOrNoDialogFragment>> onClickNo = Optional.empty();
    
    public static SkipConfirmationDialog create(Consumer<? super YesOrNoDialogFragment> onClickYes) {
        SkipConfirmationDialog dialog = new SkipConfirmationDialog();
        dialog.onClickYes = Optional.ofNullable(onClickYes);
        return dialog;
    }
    
    public static SkipConfirmationDialog create(Consumer<? super YesOrNoDialogFragment> onClickYes,
                                                Consumer<? super YesOrNoDialogFragment> onClickNo) {
        SkipConfirmationDialog dialog = new SkipConfirmationDialog();
        dialog.onClickYes = Optional.ofNullable(onClickYes);
        dialog.onClickNo = Optional.ofNullable(onClickNo);
        return dialog;
    }
}
