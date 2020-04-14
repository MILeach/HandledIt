package com.uk.sheff.mattleach.handledit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Assign save button click method
        Button addTaskButton = (Button)findViewById(R.id.save_task_button);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OnSaveTaskClick();
            }
        });
    }


    public void OnSaveTaskClick() {
        // Get task information
        EditText title = (EditText)findViewById(R.id.new_task_title_text);
        String titleText = title.getText().toString();

        // Create task using information
        HandledItTask newTask = new HandledItTask(titleText);

        // Add task to big list
        BigList bigList = BigList.getInstance();
        bigList.addTask(newTask);

        finish();
    }


}
