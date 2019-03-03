package com.example.kiran.carpool;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kiran.carpool.Util.HttpManager;
import com.example.kiran.carpool.Util.Models.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
    Button button;
    long v1,v2;
    EditText fname, lname, email, mobilenumber,pass,place;
    String result,gender;
    String Vfname,Vlname,Vemail,Vmobile,Vpass,Vplace;
    String SpinnerText1,SpinnerText2;
    RadioButton rb1,rb2;
    Spinner mySpinner1,mySpinner2;
    ArrayAdapter<CharSequence> adapter1, adapter2, adapter3;

    final User newUser = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fname= findViewById(R.id.FirstName);
       lname= findViewById(R.id.LastName);
      email = findViewById(R.id.Email);
        mobilenumber = findViewById(R.id.MobileNumber);
        pass = findViewById(R.id.Password);
        rb1= findViewById(R.id.r1);
        rb2=findViewById(R.id.r2);
        place = findViewById(R.id.place);
         mySpinner1 = findViewById(R.id.spinner1);
        mySpinner2 = findViewById(R.id.spinner2);
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "MALE";
            }
        });

            rb2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gender = "FEMALE";
                }
            });

            //spinnner 1
        adapter1 = ArrayAdapter.createFromResource(this, R.array.blood, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(adapter1);
        mySpinner1.setPrompt("YOUR BLOOD GROUP?");
        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                v1=parent.getSelectedItemId();
                System.out.println("pos1" + parent.getSelectedItemId());
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(pos) + " slected ", ((Toast.LENGTH_LONG)/2)).show();

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        //spinner2
        final List age = new ArrayList<>();
        for (int i = 15; i < 101; i++) {
            age.add(i);
        }

        ArrayAdapter<Integer> sa= new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, age);
        sa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item );
        mySpinner2.setAdapter(sa);

        v2 = mySpinner2.getSelectedItemPosition();
        System.out.println("pos2" + mySpinner2.getSelectedItemPosition());
        //submitt
        button = findViewById(R.id.Submit);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            //calling Async
            if(check()){
                RegisterUser registerUser = new RegisterUser();
                registerUser.execute();
            }

        }
        private Boolean check(){

            SpinnerText1 = mySpinner1.getSelectedItem().toString();



            newUser.setFname(Vfname);
            newUser.setLname(Vlname);
            newUser.setEmail(Vemail);
            newUser.setMobilenumber(Vmobile);
            newUser.setPass(Vpass);
            newUser.setBloodG(SpinnerText1);
            newUser.setAge(SpinnerText2);
            newUser.setPlace(Vplace);
            newUser.setGender(gender);
            return true;
        }
    });


}

class RegisterUser extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        HttpManager httpManager = new HttpManager(getApplicationContext());
        Gson gson = new Gson();
        String userJson = gson.toJson(newUser, User.class);
        System.out.println("User Json - " + userJson);
        result = HttpManager.postData(getResources().getString(R.string.serviceUrl)+"/insertUserData",userJson);
        System.out.println("Result - " + result);

        return result;
    }

    protected void onPostExecute(String result) {
        System.out.println("Result - " + result);
        if (result != null && !result.isEmpty()) {
            System.out.println("Result - " + result);

            Bundle bundle = new Bundle();
            bundle.putLong("ageValue", v2);
            bundle.putLong("bloodGroup", v1);
            Intent myIntent = new Intent(Register.this, Login.class);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }

    }


}
}

