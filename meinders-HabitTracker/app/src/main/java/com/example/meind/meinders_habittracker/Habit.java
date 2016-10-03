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

    //each day of the week will return its value.
    //later used to change color in singular habit view
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

    //revove completion with the data and not position
    public void removeComplete(String date){
        completes.remove(date);
    }

    public String getDate(Integer position){
        return completes.get(position);
    }

    //list of completions
    public ArrayList<String> getCompletions(){
        return completes;
    }

    //number of completions to display total
    public Integer getNumCompletions(){
        return completes.size();
    }

    @Override
    public int compareTo(Object o) {
        return ((Habit) o).getDate().compareTo(this.getDate());
    }
}

