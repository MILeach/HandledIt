package com.uk.sheff.mattleach.handledit.ui.big_list;

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

public class BigListFragment extends Fragment {

    private BigListViewModel bigListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bigListViewModel =
                ViewModelProviders.of(this).get(BigListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_big_list, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        bigListViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
