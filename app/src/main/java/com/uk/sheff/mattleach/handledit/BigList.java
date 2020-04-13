package com.uk.sheff.mattleach.handledit;

import java.util.ArrayList;

public class BigList {

    private static BigList instance;

    public static BigList getInstance() {
        if (instance == null) {
            instance = new BigList();
        }
        return instance;
    }

    private BigList() {
        tasks = loadTasks();
    }

    private ArrayList<HandledItTask> loadTasks() {
        ArrayList<HandledItTask> loadedTasks = new ArrayList<HandledItTask>();

        return loadedTasks;
    }

    public void addTask(HandledItTask task) {
        tasks.add(task);
    }

    private ArrayList<HandledItTask> tasks;
}
