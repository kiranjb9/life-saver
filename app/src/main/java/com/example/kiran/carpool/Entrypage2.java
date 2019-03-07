package com.example.kiran.carpool;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiran.carpool.Util.HttpManager;

import com.example.kiran.carpool.Util.Models.User;
import com.example.kiran.carpool.Util.Models.Posts;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

/**
 * Created by Belal on 18/09/16.
 */


public class Entrypage2 extends Fragment {
    Spinner mySpinner1;
    String SpinnerText1="",Hospital,result,LngLat,By;
    ArrayAdapter<CharSequence> adapter1;
    Button button;
    Posts p = new Posts();
    User user = new User();

    public Entrypage2() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        View view = inflater.inflate(R.layout.fragment_entrypage2, container, false);



        //AUTOCOMPLETE API CODDE
        final TextView txtVw = view.findViewById(R.id.placeName);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        view.findViewById(R.id.place_autocomplete_search_button).setVisibility(View.GONE);
//        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
//                getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        AutocompleteFilter filter= new AutocompleteFilter.Builder()
                .setCountry("IN")
                .build();

        autocompleteFragment.setFilter(filter);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                txtVw.setText(place.getAddress() + "\n" + place.getLatLng().toString());
                Hospital = place.getAddress().toString();
                LngLat = place.getLatLng().toString();

            }
            @Override
            public void onError(Status status) {
                txtVw.setText(status.toString());
                System.out.println("ERROR IN PLACE" + status.getStatusMessage() + " CODE IS :  " + status.getStatusCode());
            }
        }); //AUTOCOMPLETE API CODE ENDS HERE

        //spinner
        mySpinner1 =  view.findViewById(R.id.spinner1);
        adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.blood, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(adapter1);



        //post request

        button = view.findViewById(R.id.btnPost);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check()){
                    RegisterUser registerUser = new RegisterUser();
                    registerUser.execute();


                }

            }
            private boolean check() {
                SpinnerText1 =mySpinner1.getSelectedItem().toString();
                Bundle bundle1 = getActivity().getIntent().getExtras();
               String By;
                By = bundle1.getString("id");
                System.out.println("By@@@@@@@@@@@@" + By);
                System.out.println("pos1@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" +SpinnerText1 + Hospital + LngLat);
                p.setReq_bloodG(SpinnerText1);
                p.setPlace(Hospital);
                p.setLatLong(LngLat);

                return true;
            }

        });

        return  view;


    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Request blood");
    }


    class RegisterUser extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            HttpManager httpManager = new HttpManager(getActivity());
            Gson gson = new Gson();
            String userJson = gson.toJson(p, Posts.class);
            System.out.println("User Json - " + userJson);
            result = HttpManager.postData(getResources().getString(R.string.serviceUrl)+"/posts/"+ User.get_id(),userJson);
            System.out.println("Result - " + result);

            return result;
        }

        protected void onPostExecute(String result) {
            System.out.println("Result - " + result);
            if (result != null && !result.isEmpty()) {
                System.out.println("Result - " + result);

                Bundle bundle1 = new Bundle();
                bundle1.putString("fname", bundle1.getString(("fname")));
                bundle1.putString("email", bundle1.getString("email"));
                Intent myIntent = new Intent(getActivity(), Nav.class);
                myIntent.putExtras(bundle1);
                startActivity(myIntent);

            }

        }


    }
}
