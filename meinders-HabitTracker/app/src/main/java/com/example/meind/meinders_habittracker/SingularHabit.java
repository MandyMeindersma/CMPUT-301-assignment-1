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

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class SingularHabit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singular_habit);
        setTitle(HabitListController.getViewHabit().HabittoString());


        TextView total = (TextView) findViewById(R.id.total);
        total.setText("Total Completions: "+HabitListController.getViewHabit().getNumCompletions());

        TextView sunday = (TextView) findViewById(R.id.sunText);
        TextView monday = (TextView) findViewById(R.id.monText);
        TextView tuesday = (TextView) findViewById(R.id.tueText);
        TextView wednesday = (TextView) findViewById(R.id.wedText);
        TextView thursday = (TextView) findViewById(R.id.thuText);
        TextView friday = (TextView) findViewById(R.id.friText);
        TextView saturday = (TextView) findViewById(R.id.satText);

        if (HabitListController.getViewHabit().getSunday()){
            sunday.setTextColor(Color.rgb(0,0,0));
        } else {sunday.setTextColor(Color.rgb(224,224,224));}

        if (HabitListController.getViewHabit().getMonday()){
            monday.setTextColor(Color.rgb(0,0,0));
        } else {monday.setTextColor(Color.rgb(224,224,224));}

        if (HabitListController.getViewHabit().getTuesday()){
            tuesday.setTextColor(Color.rgb(0,0,0));
        } else {tuesday.setTextColor(Color.rgb(224,224,224));}

        if (HabitListController.getViewHabit().getWednesday()){
            wednesday.setTextColor(Color.rgb(0,0,0));
        } else {wednesday.setTextColor(Color.rgb(224,224,224));}

        if (HabitListController.getViewHabit().getThursday()){
            thursday.setTextColor(Color.rgb(0,0,0));
        } else {thursday.setTextColor(Color.rgb(224,224,224));}

        if (HabitListController.getViewHabit().getFriday()){
            friday.setTextColor(Color.rgb(0,0,0));
        } else {friday.setTextColor(Color.rgb(224,224,224));}

        if (HabitListController.getViewHabit().getSaturday()){
            saturday.setTextColor(Color.rgb(0,0,0));
        } else {saturday.setTextColor(Color.rgb(224,224,224));}

        ListView listview = (ListView) findViewById(R.id.CompletionList);
        final ArrayList<String> completeList = HabitListController.getViewHabit().getCompletions();
        final ArrayAdapter<String> completeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, completeList);
        listview.setAdapter(completeAdapter);



        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(SingularHabit.this);
                adb.setMessage("Delete Completion?");
                adb.setCancelable(true);
                //final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = HabitListController.getViewHabit().getDate(position);
                        HabitListController.getViewHabit().removeComplete(date);

                        TextView total = (TextView) findViewById(R.id.total);
                        total.setText("Total Completions: "+HabitListController.getViewHabit().getNumCompletions());

                        ListView listview = (ListView) findViewById(R.id.CompletionList);
                        final ArrayList<String> CompleteList = HabitListController.getViewHabit().getCompletions();
                        final ArrayAdapter<String> CompleteAdapter = new ArrayAdapter<String>(SingularHabit.this, android.R.layout.simple_list_item_1, CompleteList);
                        listview.setAdapter(CompleteAdapter);

                        //added observer
                        HabitListController.getHabitList().addListener(new Listener() {
                            @Override
                            public void update() {
                                CompleteAdapter.notifyDataSetChanged();
                            }
                        });

                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
                return false;

            }

        });


    }



    public void gotCompletion(View v){
        String formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        HabitListController.getViewHabit().addComplete(formatDate);

        TextView total = (TextView) findViewById(R.id.total);
        total.setText("Total Completions: "+HabitListController.getViewHabit().getNumCompletions());
        ListView listview = (ListView) findViewById(R.id.CompletionList);
        final ArrayList<String> CompleteList = HabitListController.getViewHabit().getCompletions();
        final ArrayAdapter<String> CompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CompleteList);
        listview.setAdapter(CompleteAdapter);

        //String[] means array of strings

        //added observer
        HabitListController.getHabitList().addListener(new Listener() {
            @Override
            public void update() {
                CompleteAdapter.notifyDataSetChanged();
            }
        });















    }





}
