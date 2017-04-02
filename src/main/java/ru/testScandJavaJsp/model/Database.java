package ru.testScandJavaJsp.model;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 * Created by 15 on 02.04.2017.
 */
public class Database {

    private int Id;

    private LocalDateTime dateTime;



    private String performer;

    private String activity;

    public int getId() {
        return Id;
    }

    public LocalDateTime getStartDate() {
        return dateTime;
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

    public void setStartDate(LocalDateTime startDate) {
        this.dateTime = startDate;
    }


    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Database(int id, LocalDateTime startDate, String performer, String activity) {
        Id = id;
        this.dateTime = startDate;
        this.performer = performer;
        this.activity = activity;
    }
}
