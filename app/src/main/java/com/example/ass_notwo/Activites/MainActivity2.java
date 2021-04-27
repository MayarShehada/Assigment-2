package com.example.ass_notwo.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ass_notwo.Models.user_info;
import com.example.ass_notwo.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    EditText major_txt , education_txt ;
    Spinner spinner ;
    String name ="null", address = "null" , email = "null" , gender = "null" ,  hobbies = "null", phone = "null" ;

    public static final String MAJOR = "MAJOR";
    public static final String EDUCATION = "EDUCATION";
    public static final int YEAR = 0;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupView();

        ArrayList<String> years = new ArrayList<>();

        years.add("0");years.add("1");years.add("2");years.add("3");years.add("4");years.add("5");
        years.add("6");years.add("7");years.add("8");years.add("9");years.add("10");years.add("more");

        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        spinner.setAdapter(yearsAdapter);


        setUpSharedPrefs();
    }

    public void setupView()
    {
        major_txt=findViewById(R.id.major_txt);
        education_txt=findViewById(R.id.education_txt);
        spinner=findViewById(R.id.spinner);
    }

    private void setUpSharedPrefs() {

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void checkPrefs() {

        String major = prefs.getString(MAJOR, "");
        String edu = prefs.getString(EDUCATION, "");
        int years = prefs.getInt(String.valueOf(YEAR),0);

        spinner.setSelection(years);

        major_txt.setText(major);
        education_txt.setText(edu);
    }

    public void saveOnClick(View view)
    {
        int year = spinner.getSelectedItemPosition();

        String major = major_txt.getText().toString();
        String edu = education_txt.getText().toString();

        editor.putInt(String.valueOf(YEAR), year);
        editor.putString(MAJOR,major);
        editor.putString(EDUCATION, edu);
        editor.commit();

        Intent intent = getIntent();
        name = intent.getStringExtra("name_data");
        address = intent.getStringExtra("address_data");
        email = intent.getStringExtra("email_data");
        phone = intent.getStringExtra("phone_num_data");
        gender = intent.getStringExtra("gender_data");
        hobbies = intent.getStringExtra("hobbies_data");

        user_info[] info = new user_info[4];

        info[0] = new user_info(name, address, email, phone, hobbies, gender, major, edu, String.valueOf(year));



        Gson gson = new Gson();
        String infoString = gson.toJson(info);

        editor.putString("1", infoString);
        editor.commit();

        Toast.makeText(this, "Data Saved:\n" + infoString, Toast.LENGTH_SHORT).show();

    }

}