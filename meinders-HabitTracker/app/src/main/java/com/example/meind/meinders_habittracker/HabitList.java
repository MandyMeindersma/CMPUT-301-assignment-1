/*Copyright 2016 Mandy Meindersma - meinders@ualberta.ca

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.



URL's I used as inspiration:

https://www.youtube.com/watch?v=fxjIA4HIruU&index=4&list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O

http://stackoverflow.com/questions/21099386/how-do-i-remove-settings-icon-on-top-right-of-action-bar

https://www.google.ca/webhp?sourceid=chrome-instant&rlz=1C1CHBF_enCA711CA711&ion=1&espv=2&ie=UTF-8#q=android%20studios%20do%20not%20allow%20user%20to%20pick%20date%20in%20the%20future

http://stackoverflow.com/questions/7646828/remove-objects-from-arraylist

http://stackoverflow.com/questions/7646828/remove-objects-from-arraylist

http://stackoverflow.com/questions/4602902/how-to-set-the-text-color-of-textview-in-code

https://obsproject.com/

http://stackoverflow.com/questions/14483393/how-do-i-change-the-android-actionbar-title-and-icon

http://stackoverflow.com/questions/7053738/what-is-meant-by-ems-android-textview

http://stackoverflow.com/questions/2592499/casting-and-getting-values-from-date-picker-and-time-picker-in-android

http://stackoverflow.com/questions/9652732/how-to-find-the-length-of-an-array-list

http://stackoverflow.com/questions/18728470/android-how-i-can-get-size-of-string-array

########################################################################
I used a lot of stack overflow which uses the creative commons license
#########################################################################

*/



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
    protected Integer habitCount = 0;

    public HabitList() {
        habits = new ArrayList<Habit>();
        listeners = new ArrayList<Listener>();
    }

    public void addHabit(Habit habit){
        if (habits.contains(habit)){
            throw new IllegalArgumentException();
        }
        habits.add(habit);
        habitCount++;
        notifyListener();
    }

    public void notifyListener() {
        for (Listener  listener : listeners) {
            listener.update();
        }
    }

    public void removeHabits(){
        habits.clear();
        notifyListener();
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

    //to keep track for history page
    public Integer totalhabitsever(){
        return habitCount;
    }

    public Integer getCount(){
        return habits.size();
    }


}
