package com.uk.sheff.mattleach.handledit.ui.big_list;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uk.sheff.mattleach.handledit.AddTaskActivity;

public class BigListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BigListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the big list fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}