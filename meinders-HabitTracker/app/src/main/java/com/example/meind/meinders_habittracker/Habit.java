package com.example.meind.meinders_habittracker;

import java.util.Date;

/**
 * Created by meind on 2016-10-01.
 */

public class Habit {

    private String Habit;
    private Date date;

    public Habit (String Habit){
        this.Habit=Habit;
        this.date= new Date();
    }

    public Habit (String Habit, Date date){
        this.Habit=Habit;
        this.date=date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getHabit() {
        return Habit;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return  Habit +" started" + date.toString();
    }



}

