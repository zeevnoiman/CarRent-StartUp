package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.moish.carrentforcompany.R;

public class ClientActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        findViews();
    }
    private Button AddClientButton;
    private Button RemoveClientButton;
    private Button UpdateClientButton;
    private Button ShowCarButton;

    private void findViews() {
        AddClientButton = (Button)findViewById( R.id.AddClientButton );
        RemoveClientButton = (Button)findViewById( R.id.RemoveClientButton );
        UpdateClientButton = (Button)findViewById( R.id.UpdateClientButton );
        ShowCarButton = (Button)findViewById( R.id.ShowCarButton );

        AddClientButton.setOnClickListener( this );
        RemoveClientButton.setOnClickListener( this );
        UpdateClientButton.setOnClickListener( this );
        ShowCarButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
    **/
    @Override
    public void onClick(View v) {
        if ( v == AddClientButton ) {
            Intent intent = new Intent(this,AddClientActivity.class);
            startActivity(intent);
        } else if ( v == RemoveClientButton ) {
            // Handle clicks for RemoveClientButton
        } else if ( v == UpdateClientButton ) {
            // Handle clicks for UpdateClientButton
        } else if ( v == ShowCarButton ) {
            Intent intent = new Intent(this,ListOfClients.class);
            startActivity(intent);
        }
    }

}
