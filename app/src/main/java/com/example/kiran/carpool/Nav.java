package com.example.kiran.carpool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //edit nav header
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = (View) navigationView.getHeaderView(0);
        TextView name = (TextView) headerView.findViewById(R.id.pid1);
        TextView mail = (TextView) headerView.findViewById(R.id.pid2);
        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("fname"));
        mail.setText(bundle.getString("email"));

    //CLICK OF NAV HEADER TO OPEN HEADER
        l=(LinearLayout) headerView.findViewById(R.id.NavHeaderId);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = getIntent().getExtras();


                bundle1.putString("fname", bundle1.getString(("fname")));
                bundle1.putString("id", bundle1.getString("id"));
                bundle1.putString("lname", bundle1.getString("lname"));
                bundle1.putString("mobile", bundle1.getString("mobile"));
                bundle1.putString("email", bundle1.getString("email"));
                bundle1.putString("pass", bundle1.getString("pass"));
                bundle1.putString("blood", bundle1.getString("blood"));
                bundle1.putString("age", bundle1.getString("age"));
                bundle1.putString("place", bundle1.getString("place"));
                bundle1.putString("gender", bundle1.getString("gender"));
                bundle1.putInt("ageValue", bundle1.getInt("ageValue"));
                bundle1.putInt("bloodGroup", bundle1.getInt("bloodGroup"));

                System.out.println("ssssssssss"+bundle1.getString("fname"));
                Intent myIntent = new Intent(Nav.this, EditProfile.class);
            myIntent.putExtras(bundle1);
                startActivity(myIntent);
            }
        });
        displaySelectedScreen(R.id.nav_menu1);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        displaySelectedScreen(item.getItemId());
        return true;
    }

    public void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_menu1:
                fragment = new entryPage();
                break;
            case R.id.nav_menu2:
                fragment = new Entrypage2();
                break;
            case R.id.nav_menu3:
                fragment = new Entrypage3();
                break;

        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
