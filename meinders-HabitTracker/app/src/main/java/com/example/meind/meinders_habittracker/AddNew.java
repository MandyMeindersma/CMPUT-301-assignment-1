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

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static com.example.meind.meinders_habittracker.R.id.habitText;
import static com.example.meind.meinders_habittracker.R.id.HabitList;
import static com.example.meind.meinders_habittracker.R.id.mini;
import static com.example.meind.meinders_habittracker.R.id.toggleButtonSun;

public class AddNew extends AppCompatActivity {

   //private static final String FILENAME = "file.sav";

    private HabitList habitList;

    //private ArrayAdapter<Habit> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

    }

    public void saveHabit(View v){
        Toast.makeText(this, "Saved the habit!", Toast.LENGTH_SHORT).show();
        HabitListController hc = new HabitListController();
        EditText HabitText = (EditText) findViewById(R.id.habitText);
        DatePicker startDate = (DatePicker) findViewById(R.id.startDatePicked);
        Date start = new Date(startDate.getYear() - 1900, startDate.getMonth(), startDate.getDayOfMonth());
        String formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(start);

        ToggleButton sunButton = (ToggleButton) findViewById(R.id.toggleButtonSun);
        Boolean sunday = sunButton.isChecked();
        ToggleButton monButton = (ToggleButton) findViewById(R.id.toggleButtonMon);
        Boolean monday = monButton.isChecked();
        ToggleButton tueButton = (ToggleButton) findViewById(R.id.toggleButtonTue);
        Boolean tuesday = tueButton.isChecked();
        ToggleButton wedButton = (ToggleButton) findViewById(R.id.toggleButtonWed);
        Boolean wednesday = wedButton.isChecked();
        ToggleButton thuButton = (ToggleButton) findViewById(R.id.toggleButtonThu);
        Boolean thursday = thuButton.isChecked();
        ToggleButton friButton = (ToggleButton) findViewById(R.id.toggleButtonFri);
        Boolean friday = friButton.isChecked();
        ToggleButton satButton = (ToggleButton) findViewById(R.id.toggleButtonSat);
        Boolean saturday = satButton.isChecked();

        Habit newHabit = new Habit(HabitText.getText().toString(), formatDate, sunday, monday, tuesday, wednesday, thursday, friday, saturday);

        hc.addHabit(newHabit);

        this.finish();
    }



}

