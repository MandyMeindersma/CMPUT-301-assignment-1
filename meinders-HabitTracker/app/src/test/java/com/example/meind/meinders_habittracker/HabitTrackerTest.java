package com.example.meind.meinders_habittracker;

import android.test.AndroidTestCase;


import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static junit.framework.Assert.*;


/**
 * Created by meind on 2016-10-01.
 */

public class HabitTrackerTest {

    @Test
    public void addHabit() {
        String stringA = "Take pill";
        Habit aHabit = new Habit(stringA);
        assertTrue("String not equal", stringA.equals(aHabit.getHabit()));
    }


    @Test
    public void testAddHabit(){
        HabitList list = new HabitList();

        Habit habit = new Habit("Hello!",new Date());
        list.addHabit(habit);
        assertTrue(list.hasHabit(habit));
    }

    @Test
    public void testHasHabit(){
        HabitList list = new HabitList();

        Habit habit = new Habit("take medication",new Date());

        assertFalse(list.hasHabit(habit));
        list.addHabit(habit);
        assertTrue(list.hasHabit(habit));

    }

    @Test
    public void testGetHabit(){
        HabitList list = new HabitList();

        Habit a = new Habit("wash face",new Date());
        Habit b = new Habit("brush teeth",new Date());

        list.addHabit(a);
        list.addHabit(b);

        assertEquals(a, list.getHabit(0));
        assertEquals(b, list.getHabit(1));
    }

    @Test
    public void testDeleteHabit(){
        HabitList list = new HabitList();
        Habit a = new Habit("love sarah",new Date());
        list.addHabit(a);
        assertTrue(list.hasHabit(a));

        list.removeHabit(a);
        assertFalse(list.hasHabit(a));

    }

    @Test
    public void testGetCount(){
        HabitList list = new HabitList();
        assertTrue(list.getCount().equals(0));
        Habit a = new Habit("walk",new Date());
        Habit b = new Habit("run",new Date());

        list.addHabit(a);
        list.addHabit(b);

        assertTrue(list.getCount().equals(2));
    }

    @Test
    public void testGetHabits(){
        HabitList list = new HabitList();
        assertTrue(list.getCount().equals(0));
        Date jan1 = new GregorianCalendar(2016, Calendar.JANUARY, 1).getTime();
        Date jan2 = new GregorianCalendar(2016, Calendar.JANUARY, 2).getTime();
        Date jan3 = new GregorianCalendar(2016, Calendar.JANUARY, 3).getTime();
        Habit a = new Habit("a",jan1);
        Habit b = new Habit("b",jan2);
        Habit c = new Habit("c",jan3);


        list.addHabit(b);
        list.addHabit(a);
        list.addHabit(c);


        assertEquals(a, list.getHabits().get(2));
        assertEquals(b, list.getHabits().get(1));
        assertEquals(c, list.getHabits().get(0));

    }






}
