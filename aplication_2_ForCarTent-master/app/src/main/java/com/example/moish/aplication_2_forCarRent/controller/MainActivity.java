package com.example.moish.aplication_2_forCarRent.controller;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.moish.aplication_2_forCarRent.R;
import com.example.moish.aplication_2_forCarRent.controller.fragments.AllFreeCars;
import com.example.moish.aplication_2_forCarRent.controller.fragments.All_Branches;
import com.example.moish.aplication_2_forCarRent.controller.fragments.ExitDialog;
import com.example.moish.aplication_2_forCarRent.controller.fragments.Home;
import com.example.moish.aplication_2_forCarRent.controller.fragments.LoginFragment;
import com.example.moish.aplication_2_forCarRent.controller.fragments.Profile;
import com.example.moish.aplication_2_forCarRent.model.entities.Client;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Client client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

      /*// FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        login();
       /* FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        Fragment fragment = new Home();
        fragmentTransaction.add(R.id.fragment_container, fragment);

        fragmentTransaction.commit();*/
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
        getMenuInflater().inflate(R.menu.main, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.All_the_branches) {

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            Fragment fragment = new All_Branches();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

        } else if (id == R.id.Home) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            Fragment fragment = new Home();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

        }else if (id == R.id.Exit) {

            ExitDialog exitDialog = new ExitDialog();
            exitDialog.show(getSupportFragmentManager(), "exit");

        } else if (id == R.id.All_the_free_cars) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            Fragment fragment = new AllFreeCars();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

        }  else if (id == R.id.Actual_state) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            Fragment fragment = new Profile();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void login() {

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new LoginFragment());
        //ft.addToBackStack(null);
        ft.commit();
    }


    private void logout() {
        client = null; // clear the current logged client
        login();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client){
        this.client = client;
    }
}
//
//
//


