package com.uk.sheff.mattleach.handledit;

import java.util.Date;

public class HandledItTask {
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private String title;
    private String details;
    private int priority;
    private Date startDate;
    private Date endDate;

    public HandledItTask() {

    }

    public String toString() {
        return "HandledItTask: " + title;
    }
}
