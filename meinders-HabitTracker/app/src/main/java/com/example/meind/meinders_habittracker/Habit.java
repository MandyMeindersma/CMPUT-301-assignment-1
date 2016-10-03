package com.example.meind.meinders_habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    protected ArrayList<String> completes = new ArrayList<String>();



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

    public void setDate(String date) {this.date = date;}

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

    public void addComplete(String date){
        completes.add(date);
    }

    public boolean getSunday(){
        return sunday;
    }

    public boolean getMonday(){
        return monday;
    }

    public boolean getTuesday(){
        return tuesday;
    }

    public boolean getWednesday(){
        return wednesday;
    }

    public boolean getThursday(){
        return thursday;
    }

    public boolean getFriday(){
        return friday;
    }

    public boolean getSaturday(){
        return saturday;
    }

    public void removeComplete(String date){
        completes.remove(date);

    }

    public String getDate(Integer position){
        return completes.get(position);
    }


    public ArrayList<String> getCompletions(){
        return completes;
    }

    public Integer getNumCompletions(){

        return completes.size();
    }

    @Override
    public int compareTo(Object o) {
        return ((Habit) o).getDate().compareTo(this.getDate());
    }
}

