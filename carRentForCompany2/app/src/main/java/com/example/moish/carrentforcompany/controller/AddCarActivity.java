package com.example.moish.carrentforcompany.controller;


import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moish.carrentforcompany.R;
import com.example.moish.carrentforcompany.model.backend.DBManagerFactory;
import com.example.moish.carrentforcompany.model.backend.Functions;

public class AddCarActivity extends Activity implements View.OnClickListener  {


    private EditText carCode_idText;
    private EditText carModelText;
    private EditText kilometersTraveledText;
    private EditText carsFixedBranchText;
    private Button addCarButton;


    private void findViews() {
        carCode_idText          = (EditText)findViewById( R.id.CarCode_idText );
        carModelText           = (EditText)findViewById( R.id.CarModelText );
        kilometersTraveledText  = (EditText)findViewById( R.id.KilometersTraveledText );
        carsFixedBranchText     = (EditText)findViewById( R.id.CarsFixedBranchText );
        addCarButton             = (Button)findViewById( R.id.addCarButton );


        addCarButton.setOnClickListener( this );
    }


    private void addCar(){
        final ContentValues values = new ContentValues();
        try{
            long id = Long.valueOf(carCode_idText.getText().toString());



            values.put(Functions.CarConst.CAR_NUMBER, carCode_idText.getText().toString());
            values.put(Functions.CarConst.FIXED_BRANCH, carsFixedBranchText.getText().toString());
            values.put(Functions.CarConst.KILOMETERS_TRAVELED, kilometersTraveledText.getText().toString());
            values.put(Functions.CarConst.MODEL,carModelText.getText().toString());

            new AsyncTask<Void, Void, Long>(){
                @Override
                protected void onPostExecute(Long aLong) {
                    Toast.makeText(getBaseContext(), "ID: " + aLong, Toast.LENGTH_LONG).show();
                    Log.d("client", values.toString());
                }

                @Override
                protected Long doInBackground(Void... voids) {
                    return DBManagerFactory.getManager().addCar(values);
                }
            }.execute();
        }
        catch (Exception e){e.toString();
        }
        finally{
            this.finish();
        }
    }


    @Override
    public void onClick(View v) {
        if ( v == addCarButton ) {
            if(isFullTheAllTexBox()== true)
                addCar();
            else { Toast.makeText(getBaseContext(), "There is an empty field, please fill in: ", Toast.LENGTH_LONG).show();}
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }

    private void clearEditTexts(EditText[] editTexts){
        for (EditText editText : editTexts){
            editText.setText("");
        }
    }

    //this funcion check if the all field are filled
    boolean isFullTheAllTexBox(){
        String LN = carCode_idText.getText().toString();
        String FN = carModelText.getText().toString();
        String CI = kilometersTraveledText.getText().toString();
        String TL = carsFixedBranchText.getText().toString();

        if(LN.isEmpty()|| FN.isEmpty() || CI.isEmpty() || TL.isEmpty() ){
            return false;
        }
        return true;

    }
}




