package com.turastory.kotlindemo.stub;

import com.annimon.stream.function.Consumer;

/**
 * Created by tura on 2018-09-26.
 */
public class ExitInbrainTrainerDialog extends YesOrNoDialogFragment {
    
    public static ExitInbrainTrainerDialog create(Consumer<? super YesOrNoDialogFragment> onClickYes) {
        ExitInbrainTrainerDialog dialog = new ExitInbrainTrainerDialog();
        return dialog;
    }
    
    public static ExitInbrainTrainerDialog create(Consumer<? super YesOrNoDialogFragment> onClickYes, int description) {
        ExitInbrainTrainerDialog dialog = new ExitInbrainTrainerDialog();
        return dialog;
    }
}
