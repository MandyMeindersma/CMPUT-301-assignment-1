package com.example.meind.meinders_habittracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by meind on 2016-10-01.
 */

public class HabitList {

    protected ArrayList<Habit> habits = null;
    protected ArrayList<Listener> listeners = null;

    public HabitList() {
        habits = new ArrayList<Habit>();
        listeners = new ArrayList<Listener>();
    }

    public void addHabit(Habit habit){
        if (habits.contains(habit)){
            throw new IllegalArgumentException();
        }
        habits.add(habit);
        notifyListener();
    }

    private void notifyListener() {
        for (Listener  listener : listeners) {
            listener.update();
        }
    }

    public void addListener(Listener l) {
        listeners.add(l);
    }

    public void removeListener(Listener l) {
        listeners.remove(l);
    }





    public boolean hasHabit(Habit habit){
        return habits.contains(habit);
    }

    public Habit getHabit(int i){
        return habits.get(i);
    }

    public ArrayList<Habit> getAllHabits (){
        return habits;
    }

    public void removeHabit(Habit a){
        habits.remove(a);
        notifyListener();
    }



    public Integer getCount(){
        return habits.size();
    }





}
