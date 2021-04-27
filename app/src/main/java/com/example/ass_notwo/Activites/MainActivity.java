package com.example.ass_notwo.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ass_notwo.Activites.MainActivity2;
import com.example.ass_notwo.R;

public class MainActivity extends AppCompatActivity {

    RadioButton female_ra , male_ra , radio ;
    RadioGroup radioGroup;
    EditText name_txt , address_txt , email_txt , ph_num_txt,hobbies_txt;

    public static final String NAME = "NAME";
    public static final String ADDRESS = "ADDRESS";
    public static final String EMAIL = "EMAIL";
    public static final String PHONENUM = "PHONENUM";
    public static final String HOBBIES = "HOBBIES";
    public static final String GE = "GE";


    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        int ra_id = radioGroup.getCheckedRadioButtonId();
        radio=findViewById(ra_id);

        setUpSharedPrefs();
        checkPrefs();
    }

    public void setupView()
    {
        female_ra=findViewById(R.id.female_ra);
        male_ra=findViewById(R.id.male_ra);
        radioGroup=findViewById(R.id.radioGroup);
        name_txt=findViewById(R.id.name_txt);
        address_txt=findViewById(R.id.address_txt);
        email_txt=findViewById(R.id.email_txt);
        ph_num_txt=findViewById(R.id.ph_num_txt);
        hobbies_txt=findViewById(R.id.hobbies_txt);
    }

    private void setUpSharedPrefs() {

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }
    private void checkPrefs() {

            String name = prefs.getString(NAME, "");
            String address = prefs.getString(ADDRESS, "");
            String email = prefs.getString(EMAIL, "");
            String phone_num = prefs.getString(PHONENUM, "");
            String hobbies = prefs.getString(HOBBIES, "");
            String Gender = prefs.getString(GE, "");


            name_txt.setText(name);
            address_txt.setText(address);
            email_txt.setText(email);
            ph_num_txt.setText(phone_num);
            hobbies_txt.setText(hobbies);

        if(Gender.equals("Male")){
            male_ra.setChecked(true);
        }else if (Gender.equals("Female")){
            female_ra.setChecked(true);
        }

    }
    public void nextOnClick(View view)
    {

        InputMethodManager mgr = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

        String name = name_txt.getText().toString();
        String address=address_txt.getText().toString();
        String email = email_txt.getText().toString();
        String phone_num = ph_num_txt.getText().toString();
        String hobbies = hobbies_txt.getText().toString();

        String gender = " ";
        if(male_ra.isChecked()){
            gender = "Male";
        }else if (female_ra.isChecked()){
            gender = "Female";
        }
        editor.putString(NAME,name);
        editor.putString(ADDRESS,address);
        editor.putString(EMAIL,email);
        editor.putString(PHONENUM,phone_num);
        editor.putString(HOBBIES,hobbies);
        editor.putString(GE, gender);
        editor.commit();

        Intent intent = new Intent(this, MainActivity2.class);

        intent.putExtra("name_data", name);
        intent.putExtra("address_data", address);
        intent.putExtra("email_data", email);
        intent.putExtra("phone_num_data", phone_num);
        intent.putExtra("hobbies_data", hobbies);
        intent.putExtra("gender_data",gender);


        startActivity(intent);
    }
}