package com.uk.sheff.mattleach.handledit.ui.todays_tasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TodaysTasksViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TodaysTasksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the today\'s tasks fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}