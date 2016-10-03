package com.example.meind.meinders_habittracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by meind on 2016-10-01.
 */

public class Habit implements Comparable{

    private String Habit;
    private String date;
    private Boolean sunday;
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;



    public Habit (String Habit, String date, Boolean sunday,
                  Boolean monday, Boolean tuesday, Boolean wednesday,
                  Boolean thursday, Boolean friday, Boolean saturday){
        this.Habit=Habit;
        this.date=date;
        this.sunday=sunday;
        this.monday=monday;
        this.tuesday=tuesday;
        this.wednesday=wednesday;
        this.thursday=thursday;
        this.friday=friday;
        this.saturday=saturday;
    }

    public void setDate(String date) {

        this.date = date;
    }


    public String getHabit() {
        return Habit;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString(){
        return  Habit +" started " + date;
    }

    public String HabittoString(){
        return  Habit;
    }






    @Override
    public int compareTo(Object o) {
        return ((Habit) o).getDate().compareTo(this.getDate());
    }
}

