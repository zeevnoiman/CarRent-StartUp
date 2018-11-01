package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moish.carrentforcompany.R;

public class ReserveActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        findViews();
    }

    private Button addReserveButton;
    private Button removeReserveButton;
    private Button updateReserveButton;
    private Button showReservesButton;

    private void findViews() {
        addReserveButton = (Button)findViewById( R.id.addReserveButton );
        removeReserveButton = (Button)findViewById( R.id.removeReserveButton );
        updateReserveButton = (Button)findViewById( R.id.updateReserveButton );
        showReservesButton = (Button)findViewById( R.id.showReservesButton );

        addReserveButton.setOnClickListener(this);
        removeReserveButton.setOnClickListener( this );
        updateReserveButton.setOnClickListener( this );
        showReservesButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-23 19:36:27 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addReserveButton ) {
            Intent intent = new Intent(this,AddReserveActivity.class);
            startActivity(intent);
        } else if ( v == removeReserveButton ) {
            // Handle clicks for removeReserveButton
        } else if ( v == updateReserveButton ) {
            // Handle clicks for updateReserveButton
        } else if ( v == showReservesButton ) {
            Intent intent = new Intent(this,ListOfReserves.class);
            startActivity(intent);
        }
    }

}
