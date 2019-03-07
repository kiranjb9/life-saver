package com.example.kiran.carpool;


import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.kiran.carpool.Util.HttpManager;
import com.example.kiran.carpool.Util.ListAdapter;
import com.example.kiran.carpool.Util.Models.Posts;
import com.example.kiran.carpool.Util.Models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;


public class entryPage extends Fragment {
    Toolbar navView ;
    public entryPage() {
    // Required empty public constructor
}
    Context context;
    ListView listV;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        System.out.println("FragmentListUser");
        View view = inflater.inflate(R.layout.list1, container, false);


        listV = view.findViewById(R.id.simpleListView);
        RegisterUser registerUser=new RegisterUser();
        registerUser.execute();

        return  view;
    }


class RegisterUser extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        HttpManager httpManager = new HttpManager(getActivity());
        String result = HttpManager.getData(getResources().getString(R.string.serviceUrl) + "/getalldata");
        return result;
    }


    protected void onPostExecute(String result) {
        System.out.println("Result - "+result);
        Gson gson = new Gson();
        final List<Posts> userList = gson.fromJson(result,new TypeToken<List<Posts>>() {}.getType());

        if(TextUtils.isEmpty(result)){

        }
        else {
            if(userList!=null && userList.size()>0){
                System.out.println("USER LIST CONTENT "+userList.get(0).toString());

                ListAdapter adapter = new ListAdapter(context,R.layout.my_list1,userList);
                listV.setAdapter(adapter);
            }
           /*jsonArray=  getJSonData(result);
            ArrayList<JSONObject> listItems= getArrayListFromJSONArray(jsonArray);
            System.out.println("AFTER RETURNIG FROM getArrayListFromJSONArray");
            ListView listV = (ListView) findViewById(R.id.listv);
            com.example.shivanand.myapplication.util.ListAdapter adapter = new ListAdapter(MyList.this,R.layout.list,listItems);
            listV.setAdapter(adapter);*/
        }
//            listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    int num=listV.getAdapter().getCount();
//                    System.out.println("NUMBER OF ITEMS :"+num);
//                    for(int i=0;i<=num;i++){
//                        if (position == i) {
//                            Intent myIntent = new Intent(view.getContext(), Fragment_2.class);
//                            Bundle b = new Bundle();
//                            System.out.println(userList.get(i).toString());
//                            //Inserts a String value into the mapping of this Bundle
//                            b.putString("fname", userList.get(i).getFname().toString());
//
//                            b.putString("lname", userList.get(i).getLname().toString());
//                            b.putString("gender", userList.get(i).getGender().toString());
//                            b.putString("phno", userList.get(i).getPhno().toString());
//                            b.putString("email", userList.get(i).getEmail().toString());
//                            b.putString("branch", userList.get(i).getBranch().toString());
//                            b.putString("sem", userList.get(i).getSem().toString());
//                            b.putString("course", userList.get(i).getCourse().toString());
//
//                            myIntent.putExtras(b);
//                            startActivityForResult(myIntent, 0);
//                        }
//                    }
//
//                }
//
//
//            });
    }
}


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("ALL BLOOD Requests");
    }



}

