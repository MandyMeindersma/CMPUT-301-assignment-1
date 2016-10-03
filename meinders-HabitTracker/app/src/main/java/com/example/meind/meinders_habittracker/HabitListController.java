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
    private static Integer ViewPosition;

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

    public static void setViewHabit(Integer position){
        ViewPosition = position;
    }

    public static Habit getViewHabit(){
        return habitList.getHabit(ViewPosition);
    }



}
