package edu.indiana.cs.assignment4_calendar;

/**
 * Created by Owl on 9/25/16.
 */
public class events {

    private String title;
    private int timeStart;
    private int timeEnd;
    private String note;


    public events(String title, int timeStart, int timeEnd, String note) {
        this.title = title;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public String getNote() {
        return note;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String toString() {
        return this.title + "&&&" + this.timeStart + "&&&" + this.timeEnd + "&&&" + this.note;
    }
}
