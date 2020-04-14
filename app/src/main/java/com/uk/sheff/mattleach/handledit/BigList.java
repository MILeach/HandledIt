package com.uk.sheff.mattleach.handledit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class BigList {

    // Context used for accessing shared preferences for saving + loading  the BigList
    private static Context context;
    private static BigList instance;

    public static BigList getInstance() {
        if (context == null) {
            System.out.println("WARNING: Creating BigList instance without context set");
        }
        if (instance == null) {
            instance = new BigList();
        }
        return instance;
    }

    public static void setContext(Context context) {
        BigList.context = context;
    }

    private BigList() {
        tasks = loadTasks();
    }

    private ArrayList<HandledItTask> loadTasks() {
        ArrayList<HandledItTask> loadedTasks;

        // Load list from shared preferences
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.uk.sheff.mattleach.handledit", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("biglist", null);
        Type type = new TypeToken<ArrayList<HandledItTask>>() {}.getType();
        loadedTasks = gson.fromJson(json, type);

        // If list doesn't exist in shared preferences, create a new one
        if(loadedTasks == null) {
            loadedTasks = new ArrayList<HandledItTask>();
        }
        return loadedTasks;
    }

    private void saveTasks() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.uk.sheff.mattleach.handledit", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(tasks);
        editor.putString("biglist", json);
        editor.apply();
    }

    public ArrayList<HandledItTask> getList() {
        return tasks;
    }

    public void addTask(HandledItTask task) {
        tasks.add(task);
        saveTasks();
    }

    private ArrayList<HandledItTask> tasks;
}
