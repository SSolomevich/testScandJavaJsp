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

    public LocalDate getDate() {
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Database(int id, LocalDate date, String performer, String activity) {
        Id = id;
        this.date = date;
        this.performer = performer;
        this.activity = activity;
    }

    public Database() {

    }
}
