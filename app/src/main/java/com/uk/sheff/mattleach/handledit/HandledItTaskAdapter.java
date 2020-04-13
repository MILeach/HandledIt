package com.uk.sheff.mattleach.handledit;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HandledItTaskAdapter extends RecyclerView.Adapter<HandledItTaskAdapter.MyViewHolder> {

    private ArrayList<HandledItTask> taskList;

    // This class is a set of handles to elements of the individual item view we might wish to access
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Elements of handled_it_task_list_item.xml
        public ConstraintLayout c;
        public TextView title;
        public MyViewHolder(ConstraintLayout c, TextView title) {
            super(c);
            this.c = c;
            this.title = title;
        }
    }

    public HandledItTaskAdapter(ArrayList<HandledItTask> taskList) {
        this.taskList = taskList;
    }

    // Creates a new item in the list and assigns a view holder to reference it
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout c = (ConstraintLayout)LayoutInflater.from(parent.getContext())
                .inflate(R.layout.handled_it_task_list_item, parent, false);
        TextView textView = c.findViewById(R.id.task_list_item_title);

        MyViewHolder vh = new MyViewHolder(c, textView);
        return vh;
    }

    // Assign data from
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(taskList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
