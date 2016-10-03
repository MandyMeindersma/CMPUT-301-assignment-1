package com.example.meind.meinders_habittracker;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import static com.example.meind.meinders_habittracker.R.id.activity_add_new;

/**
 * Created by meind on 2016-10-02.
 */

public class HabitListController {

    //lazy singleton
    private static HabitList habitList = null;

    //as long as I call get habit list (which is static and says the same, I should be fine


    static public HabitList getHabitList(){
        if (habitList == null){
            habitList = new HabitList();
        }
        return habitList;
    }

    public void addHabit(Habit newHabit) {

        //have to say getHabitList because it returns the habit list and makes sure the habitlist is not null
        getHabitList().addHabit(newHabit);
    }

    public HabitList showAllHabit(){
        return getHabitList();
    }


}
