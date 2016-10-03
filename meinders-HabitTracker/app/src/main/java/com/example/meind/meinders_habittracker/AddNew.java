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
        //adapter.notifyDataSetChanged();

        //  saveInFile();





        this.finish();
    }





   /* private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_APPEND);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(HabitList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }*/


}

