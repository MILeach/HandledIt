package com.uk.sheff.mattleach.handledit.ui.current_task;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CurrentTaskViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CurrentTaskViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the current task fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}