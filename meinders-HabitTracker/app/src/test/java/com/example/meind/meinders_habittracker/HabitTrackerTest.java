package com.example.meind.meinders_habittracker;

import android.test.AndroidTestCase;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static junit.framework.Assert.*;


/**
 * Created by meind on 2016-10-01.
 */

public class HabitTrackerTest {

    @Test
    public void addHabit() {
        String stringA = "Take pill";
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit aHabit = new Habit(stringA,formatDate, false, false, false, false, false, false, false);
        assertTrue("String not equal", stringA.equals(aHabit.getHabit()));
    }


    @Test
    public void testAddHabit(){
        HabitList list = new HabitList();
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit habit = new Habit("Hello!",formatDate, false, false, false, false, false, false, false);
        list.addHabit(habit);
        assertTrue(list.hasHabit(habit));
    }


    @Test
    public void testGetAllHabits(){
        HabitList list = new HabitList();

        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());

        Habit habit = new Habit("take medication",formatDate, false, false, false, false, false, false, false);
        Habit habit2 = new Habit("take more medication",formatDate, false, false, false, false, false, false, false);

        assertFalse(list.hasHabit(habit));
        list.addHabit(habit);
        list.addHabit(habit2);
        assertTrue(list.hasHabit(habit));



        assertTrue("must have 2 elements",list.getAllHabits().size()==2);
    }

    @Test
    public void testHasHabit(){
        HabitList list = new HabitList();

        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit habit = new Habit("take medication",formatDate, false, false, false, false, false, false, false);

        assertFalse(list.hasHabit(habit));
        list.addHabit(habit);
        assertTrue(list.hasHabit(habit));

    }

    @Test
    public void testGetHabit(){
        HabitList list = new HabitList();

        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("wash face",formatDate, false, false, false, false, false, false, false);
        Habit b = new Habit("brush teeth",formatDate, false, false, false, false, false, false, false);

        list.addHabit(a);
        list.addHabit(b);

        assertEquals(a, list.getHabit(0));
        assertEquals(b, list.getHabit(1));
    }

    @Test
    public void testDeleteHabit(){
        HabitList list = new HabitList();
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("love sarah",formatDate, false, false, false, false, false, false, false);
        list.addHabit(a);
        assertTrue(list.hasHabit(a));

        list.removeHabit(a);
        assertFalse(list.hasHabit(a));

    }

    @Test
    public void testGetCount(){
        HabitList list = new HabitList();
        assertTrue(list.getCount().equals(0));
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("walk",formatDate, false, false, false, false, false, false, false);
        Habit b = new Habit("run",formatDate, false, false, false, false, false, false, false);

        list.addHabit(a);
        list.addHabit(b);

        assertTrue(list.getCount().equals(2));
    }


    boolean updated = false;
    @Test
    public void testNotifyListeners(){
        HabitList habitList = new HabitList();
        updated = false;
        Listener l = new Listener(){
            public void update(){
                HabitTrackerTest.this.updated = true;
            }
        };
        habitList.addListener(l);
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("walk",formatDate, false, false, false, false, false, false, false);
        habitList.addHabit(a);
        assertTrue("didn't fire update",this.updated);
    }



    @Test
    public void testRemoveListeners(){
        HabitList habitList = new HabitList();
        Listener l = new Listener(){
            public void update(){
                HabitTrackerTest.this.updated = true;
            }
        };
        habitList.addListener(l);
        habitList.removeListener(l);
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("walk",formatDate, false, false, false, false, false, false, false);
        habitList.addHabit(a);
        assertFalse("didn't fire update",this.updated);
    }


    @Test
    public void testAddRemoveCompletion(){
        HabitList list = new HabitList();
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("love sarah",formatDate, false, false, false, false, false, false, false);
        list.addHabit(a);
        a.addComplete(formatDate);

        Integer i=0;
        a.removeComplete(formatDate);
        assertTrue("see if it works", a.getNumCompletions()==0);

    }

    @Test
    public void testgetCompletions(){
        HabitList list = new HabitList();
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("love sarah",formatDate, false, false, false, false, false, false, false);
        list.addHabit(a);
        a.addComplete(formatDate);
        assertTrue(1==a.getNumCompletions());

    }

    @Test
    public void testTotalHabit(){
        HabitList list = new HabitList();
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        Habit a = new Habit("love sarah",formatDate, false, false, false, false, false, false, false);
        Habit o = new Habit("lovef sarah",formatDate, false, false, false, false, false, false, false);
        Habit c = new Habit("loveg sarah",formatDate, false, false, false, false, false, false, false);
        Habit d = new Habit("love sgarah",formatDate, false, false, false, false, false, false, false);
        Habit y = new Habit("love hsarah",formatDate, false, false, false, false, false, false, false);
        list.addHabit(a);
        list.addHabit(o);
        list.addHabit(c);
        list.addHabit(d);
        list.addHabit(y);
        list.removeHabit(a);
        Integer e =list.totalhabitsever();
        Integer b = 5;
        assertEquals(b, e);
    }

}
