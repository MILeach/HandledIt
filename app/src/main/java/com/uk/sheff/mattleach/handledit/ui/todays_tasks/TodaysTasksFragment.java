package com.uk.sheff.mattleach.handledit.ui.todays_tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.uk.sheff.mattleach.handledit.R;

public class TodaysTasksFragment extends Fragment {

    private TodaysTasksViewModel todaysTasksViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todaysTasksViewModel =
                ViewModelProviders.of(this).get(TodaysTasksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_todays_tasks, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        todaysTasksViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
