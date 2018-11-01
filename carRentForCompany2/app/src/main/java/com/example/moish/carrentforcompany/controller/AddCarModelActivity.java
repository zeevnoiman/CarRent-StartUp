
package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moish.carrentforcompany.R;
import com.example.moish.carrentforcompany.model.backend.DBManagerFactory;
import com.example.moish.carrentforcompany.model.backend.Functions;

public class AddCarModelActivity extends Activity implements View.OnClickListener {



    private EditText modelCodeIdText;
    private EditText companyNameText;
    private EditText modelNameEditText;
    private EditText motorVolumeEditText;
    private EditText numberOfSeatsEditText;
    private Button addCarModelButton;
    private CheckBox isAutomaticCheckBox;
    private int checkBox;


    private void findViews() {
        modelCodeIdText = (EditText)findViewById( R.id.ModelCode_idText);
        companyNameText = (EditText)findViewById( R.id.CompanyNameText );
        modelNameEditText = (EditText)findViewById( R.id.ModelNameEditText);
        motorVolumeEditText = (EditText)findViewById( R.id.MotorVolumeEditText );
        isAutomaticCheckBox = (CheckBox)findViewById( R.id.IsAutomaticEditText);
        numberOfSeatsEditText = (EditText)findViewById( R.id.NumberOfSeatsEditText);
        addCarModelButton = (Button)findViewById( R.id.addCarModelButton);


        addCarModelButton.setOnClickListener( this );
    }


    private void addCarModel(){
        final ContentValues values = new ContentValues();
        try{
            long id = Long.valueOf(modelCodeIdText.getText().toString());



            values.put(Functions.CarModelConst.ISAUTOMATIC, Integer.toString(checkBox));
            values.put(Functions.CarModelConst.ENGINE_VOLUME, motorVolumeEditText.getText().toString());
            values.put(Functions.CarModelConst.MODEL_NAME, modelNameEditText.getText().toString());
            values.put(Functions.CarModelConst.SEATING, numberOfSeatsEditText.getText().toString());
            values.put(Functions.CarModelConst.COMPANY_NAME, companyNameText.getText().toString());
            values.put(Functions.CarModelConst.MODEL_ID, modelCodeIdText.getText().toString());

            new AsyncTask<Void, Void, Long>(){
                @Override
                protected void onPostExecute(Long aLong) {
                    Toast.makeText(getBaseContext(), "ID: " + aLong, Toast.LENGTH_LONG).show();
                    Log.d("client", values.toString());
                }

                @Override
                protected Long doInBackground(Void... voids) {
                    return DBManagerFactory.getManager().addCarModel(values);
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
        if ( v == addCarModelButton ) {
            if(isFullTheAllTexBox()== true)
                addCarModel();
            else { Toast.makeText(getBaseContext(), "There is an empty field, please fill in: ", Toast.LENGTH_LONG).show();}
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);
        findViews();
    }

    private void clearEditTexts(EditText[] editTexts){
        for (EditText editText : editTexts){
            editText.setText("");
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.IsAutomaticEditText:
                if (checked)
                {
                    checkBox = 1;

                }
                else {
                    checkBox = 0;

                }

                break;
            // TODO: Veggie sandwich
        }
    }

    //this funcion check if the all field are filled
    boolean isFullTheAllTexBox(){
        String LN = modelCodeIdText.getText().toString();
        String FN = numberOfSeatsEditText.getText().toString();
        String CI = modelNameEditText.getText().toString();
        String TL = motorVolumeEditText.getText().toString();
        String CC = numberOfSeatsEditText.getText().toString();
        if(LN.isEmpty()|| FN.isEmpty() || CI.isEmpty() || TL.isEmpty()  || CC.isEmpty()){
            return false;
        }
        return true;

    }
}


