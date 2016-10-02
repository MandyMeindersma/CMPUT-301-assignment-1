package com.example.meind.meinders_habittracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by meind on 2016-10-01.
 */

public class HabitList {

    List<Habit> habits = new ArrayList<Habit>();

    public void addHabit(Habit habit){
        if (habits.contains(habit)){
            throw new IllegalArgumentException();
        }
        habits.add(habit);
    }

    public boolean hasHabit(Habit habit){
        return habits.contains(habit);
    }

    public Habit getHabit(int i){
        return habits.get(i);
    }

    public void removeHabit(Habit a){
        habits.remove(a);
    }

    public List<Habit> getHabits(){
        Collections.sort(habits);
        return habits;
    }


    public Integer getCount(){
        return habits.size();
    }





}
