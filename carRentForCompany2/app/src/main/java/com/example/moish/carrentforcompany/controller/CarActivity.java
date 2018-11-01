package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moish.carrentforcompany.R;

public class CarActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        findViews();
    }
    private Button addCarButton;
    private Button removeCarButton;
    private Button updateCarButton;
    private Button showCarsButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-23 19:40:31 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        addCarButton = (Button)findViewById( R.id.addCarButton );
        removeCarButton = (Button)findViewById( R.id.removeCarButton );
        updateCarButton = (Button)findViewById( R.id.updateCarButton );
        showCarsButton = (Button)findViewById( R.id.showCarsButton );

        addCarButton.setOnClickListener( this );
        removeCarButton.setOnClickListener( this );
        updateCarButton.setOnClickListener( this );
        showCarsButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-23 19:40:31 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addCarButton ) {
            Intent intent = new Intent(this, AddCarActivity.class);
            startActivity(intent);
        } else if ( v == removeCarButton ) {
            // Handle clicks for removeCarButton
        } else if ( v == updateCarButton ) {
            // Handle clicks for updateCarButton
        } else if ( v == showCarsButton ) {
            Intent intent = new Intent(this,ListOfCars.class);
            startActivity(intent);
        }
    }

}
