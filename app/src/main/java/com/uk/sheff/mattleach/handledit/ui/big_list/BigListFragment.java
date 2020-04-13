package com.uk.sheff.mattleach.handledit.ui.big_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uk.sheff.mattleach.handledit.AddTaskActivity;
import com.uk.sheff.mattleach.handledit.BigList;
import com.uk.sheff.mattleach.handledit.HandledItTask;
import com.uk.sheff.mattleach.handledit.HandledItTaskAdapter;
import com.uk.sheff.mattleach.handledit.R;

import java.util.ArrayList;

public class BigListFragment extends Fragment {

    // Singleton Instance
    private BigListViewModel bigListViewModel;

    private RecyclerView bigListRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bigListViewModel =
                ViewModelProviders.of(this).get(BigListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_big_list, container, false);

        // Instantiate List
        bigListRecyclerView = (RecyclerView) root.findViewById(R.id.big_list_recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        bigListRecyclerView.setLayoutManager(layoutManager);

        ArrayList<HandledItTask> bigList = BigList.getInstance().getList();
        adapter = new HandledItTaskAdapter(bigList);
        bigListRecyclerView.setAdapter(adapter);




        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Set button onclick
        Button addTaskButton = view.findViewById(R.id.add_task_button);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OnAddTaskClick();
            }
        });
    }

    public void OnAddTaskClick() {
        Intent intent = new Intent(getContext(), AddTaskActivity.class);
        startActivity(intent);
    }
}
