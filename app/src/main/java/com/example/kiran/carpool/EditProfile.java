package com.example.kiran.carpool;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class EditProfile extends AppCompatActivity {
EditText fname,lname,email,mobilenumber,pass,place;
RadioButton rb1,rb2;
Spinner mySpinner1,mySpinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        fname= (EditText) findViewById(R.id.eFirstName);
        lname= (EditText) findViewById(R.id.eLastName);
        email = (EditText) findViewById(R.id.eEmail);
        mobilenumber = (EditText) findViewById(R.id.eMobileNumber);
        pass = (EditText) findViewById(R.id.ePassword);
        rb1= findViewById(R.id.er1);
        rb2=findViewById(R.id.er2);
        place = findViewById(R.id.eplace);
        mySpinner1 = (Spinner) findViewById(R.id.espinner1);
        mySpinner2 = (Spinner) findViewById(R.id.espinner2);



        Bundle bundle = getIntent().getExtras();
        System.out.println("ssssssssss"+bundle.getString("email"));
        fname.setText(bundle.getString("fname"));
        lname.setText(bundle.getString("lname"));
        email.setText(bundle.getString("email"));
        mobilenumber.setText(bundle.getString("mobile"));
        pass.setText(bundle.getString("pass"));
        place.setText(bundle.getString("place"));
        String checkGender = bundle.getString("gender");
        if(checkGender.equals("MALE")){
            rb1.setChecked(true);
        }
        else {
            rb2.setChecked(true);
        }
        System.out.println("/n" + bundle.getInt("bloodGroup") + "/n" +bundle.getInt("ageValue"));
        mySpinner1.setSelection(bundle.getInt("bloodGroup"));
        mySpinner2.setSelection((bundle.getInt("ageValue")));

    }






}
