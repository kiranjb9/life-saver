package com.example.kiran.carpool;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kiran.carpool.Util.HttpManager;
import com.example.kiran.carpool.Util.Models.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


public class Login extends AppCompatActivity {
    Button button1,button2;
    EditText  email,pass;
    String result;
    String Vemail,Vpass;
    final User newUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.lemail);
        pass = findViewById(R.id.lpassword);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Login.this, Register.class);
                startActivity(myIntent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()){
                    RegisterUser registerUser = new RegisterUser();
                    registerUser.execute();
                }
            }
            private Boolean check(){
                Vemail = email.getText().toString();
                Vpass = pass.getText().toString();


                newUser.setEmail(Vemail);
                newUser.setPass(Vpass);
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
            result = HttpManager.postData("http://10.0.2.2:3000/login",userJson);
            System.out.println("Result - " + result);

            return result;
        }

        protected void onPostExecute(String result) {
            System.out.println("Result - " + result);
            JSONObject jresponse = null;
            try {
                jresponse = new JSONObject(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println(jresponse.optString("Fname"));

            if (result != null && !result.isEmpty()) {
                System.out.println("Result - " + result);

                Bundle bundle = new Bundle();
                bundle.putString("fname", jresponse.optString("fname"));
                bundle.putString("id", jresponse.optString("_id"));
                User.set_id(jresponse.optString("_id"));
                bundle.putString("lname", jresponse.optString("lname"));
                bundle.putString("mobile", jresponse.optString("mobilenumber"));
                bundle.putString("email", jresponse.optString("email"));
                bundle.putString("pass", jresponse.optString("pass"));
                bundle.putString("blood", jresponse.optString("Req_bloodG"));
                bundle.putString("age", jresponse.optString("age"));
                bundle.putString("place", jresponse.optString("place"));
                bundle.putString("gender", jresponse.optString("gender"));
                bundle.putInt("ageValue", bundle.getInt("ageValue"));
                bundle.putInt("bloodGroup", bundle.getInt("bloodGroup"));


                Intent myIntent = new Intent(Login.this, Nav.class);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
                if (result == null )   {
                    Log.d("error","nothing found");
            }

        }


    }
}
