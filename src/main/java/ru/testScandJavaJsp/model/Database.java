package ru.testScandJavaJsp.model;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Created by 15 on 02.04.2017.
 */
public class Database {

    private int Id;

    private LocalDate date;

    private String performer;

    private String activity;

    public int getId() {
        return Id;
    }

    public LocalDate getDateTime() {
        return date;
    }

    public String getPerformer() {
        return performer;
    }

    public String getActivity() {
        return activity;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setDateTime(LocalDate dateTime) {
        this.date = dateTime;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Database(int id, LocalDate startDate, String performer, String activity) {
        Id = id;
        this.date = startDate;
        this.performer = performer;
        this.activity = activity;
    }
}
