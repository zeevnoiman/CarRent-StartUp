package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moish.carrentforcompany.R;

public class CarModelActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model);
        findViews();
    }
    private Button AddCarModeltButton;
    private Button RemoveCarModelButton;
    private Button UpdateCarModelButton;
    private Button ShowCarModelButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-23 19:42:38 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        AddCarModeltButton = (Button)findViewById( R.id.AddCarModeltButton );
        RemoveCarModelButton = (Button)findViewById( R.id.RemoveCarModelButton );
        UpdateCarModelButton = (Button)findViewById( R.id.UpdateCarModelButton );
        ShowCarModelButton = (Button)findViewById( R.id.ShowCarModelButton );

        AddCarModeltButton.setOnClickListener( this );
        RemoveCarModelButton.setOnClickListener( this );
        UpdateCarModelButton.setOnClickListener( this );
        ShowCarModelButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-23 19:42:38 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == AddCarModeltButton ) {
            Intent intent = new Intent(this, AddCarModelActivity.class);
            startActivity(intent);
        } else if ( v == RemoveCarModelButton ) {
            // Handle clicks for RemoveCarModelButton
        } else if ( v == UpdateCarModelButton ) {
            // Handle clicks for UpdateCarModelButton
        } else if ( v == ShowCarModelButton ) {
            Intent intent = new Intent(this, ListOfCarModels.class);
            startActivity(intent);
        }
    }

}
