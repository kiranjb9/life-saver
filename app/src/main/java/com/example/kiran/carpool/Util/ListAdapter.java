package com.example.kiran.carpool.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kiran.carpool.R;
import com.example.kiran.carpool.Util.Models.User;


import java.util.List;

public class ListAdapter extends ArrayAdapter<User>{

    int vg;

    List<User> userList;

    Context context;

    public ListAdapter(Context context, int activity, List<User> list){

        super(context,activity,list);

        this.context=context;

        this.vg=activity;

        this.userList=list;
        System.out.println("entered ListAdapter");

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("entered getView");
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(vg, parent, false);
        User user = userList.get(position);

        TextView Fname=itemView.findViewById(R.id.ListFname);
        TextView RBG = itemView.findViewById(R.id.ListBloodG);
        TextView place = itemView.findViewById(R.id.Listplace);
        TextView Phno=itemView.findViewById(R.id.ListContact);


        try {
            Fname.setText(user.getFname()+" "+user.getLname());

            System.out.println("##############################            "+user.getPosts(getItem(0)).iterator());
//
//            RBG.setText(user.getP().getReq_bloodG());
//            place.setText(user.getP().getPlace());
            Phno.setText(user.getMobilenumber());

            //Email.setText(list.get(position).getString("email"));

            //Branch.setText(list.get(position).getString("branch"));

            //Sem.setText(list.get(position).getString("sem"));

            // Course.setText(list.get(position).getString("course"));


        } catch (Exception e) {
            System.out.println("ERROR"+e);
            e.printStackTrace();
        }



        return itemView;

    }

}
