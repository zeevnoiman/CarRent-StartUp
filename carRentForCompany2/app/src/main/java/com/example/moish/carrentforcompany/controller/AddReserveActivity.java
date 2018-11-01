package com.example.moish.carrentforcompany.controller;

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

public class AddReserveActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reserve);
        findViews();
    }

    private EditText ReserveNumberId;
    private EditText ClientNumber;
    private CheckBox IsOpened;
    private EditText RentBegginning;
    private EditText RentEnd;
    private EditText StartKilometers;
    private EditText EndKilometers;
    private CheckBox IsFueled;
    private EditText LitersFueled;
    private EditText TotalToPay;
    private EditText CarNumber;
    private Button addCarReserveButton;
    private int isOpenCheckBox;
    private int isFueledCheckBox;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-04 14:21:35 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        ReserveNumberId = (EditText)findViewById( R.id.ReserveNumber_id );
        ClientNumber = (EditText)findViewById( R.id.ClientNumber );
        IsOpened = (CheckBox) findViewById( R.id.IsOpened );
        RentBegginning = (EditText)findViewById( R.id.RentBegginning );
        RentEnd = (EditText)findViewById( R.id.RentEnd );
        StartKilometers = (EditText)findViewById( R.id.StartKilometers );
        EndKilometers = (EditText)findViewById( R.id.EndKilometers );
        IsFueled = (CheckBox) findViewById( R.id.IsFueled );
        LitersFueled = (EditText)findViewById( R.id.LitersFueled );
        TotalToPay = (EditText)findViewById( R.id.TotalToPay );
        CarNumber = (EditText)findViewById( R.id.CarNumber );
        addCarReserveButton = (Button)findViewById( R.id.addCarReserveButton );

        addCarReserveButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-12-04 14:21:35 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void addReserve(){
        final ContentValues values = new ContentValues();
        try{
            long id = Long.valueOf(ReserveNumberId.getText().toString());

            values.put(Functions.CarReserveConst.TOTAL_TO_PAY, TotalToPay.getText().toString());
            values.put(Functions.CarReserveConst.START_KILOMETERS, StartKilometers.getText().toString());
            values.put(Functions.CarReserveConst.RESERVE_NUMBER, ReserveNumberId.getText().toString());
            values.put(Functions.CarReserveConst.RENT_END_DATE, RentEnd.getText().toString());
            values.put(Functions.CarReserveConst.RENT_BEGGINING_DATE, RentBegginning.getText().toString());
            values.put(Functions.CarReserveConst.IS_OPENED, Integer.toString(isOpenCheckBox));
            values.put(Functions.CarReserveConst.LITERS_FUELED, LitersFueled.getText().toString());
            values.put(Functions.CarReserveConst.IS_FUELED,  Integer.toString(isFueledCheckBox));
            values.put(Functions.CarReserveConst.END_KILOMETERS, EndKilometers.getText().toString());
            values.put(Functions.CarReserveConst.CLIENT_NUMBER, ClientNumber.getText().toString());
            values.put(Functions.CarReserveConst.CAR_NUMBER, CarNumber.getText().toString());

            new AsyncTask<Void, Void, Long>(){
                @Override
                protected void onPostExecute(Long aLong) {
                    Toast.makeText(getBaseContext(), "ID: " + aLong, Toast.LENGTH_LONG).show();
                    Log.d("reserve", values.toString());
                }

                @Override
                protected Long doInBackground(Void... voids) {
                    return DBManagerFactory.getManager().addCarReserve(values);
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
        if ( v == addCarReserveButton ) {
            if(isFullTheAllTexBox()== true)
                addReserve();
            else { Toast.makeText(getBaseContext(), "There is an empty field, please fill in: ", Toast.LENGTH_LONG).show();}
        }
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
            case R.id.IsFueled:
                if (checked)
                {
                    isFueledCheckBox = 1;
                    LitersFueled.setVisibility(View.VISIBLE);
                }
                else {
                    isFueledCheckBox = 0;
                    LitersFueled.setVisibility(View.GONE);
                }
            case R.id.IsOpened:
                if (checked)
                {
                    isOpenCheckBox = 1;
                }
                else {
                    isOpenCheckBox = 0;
                }

                break;
            // TODO: Veggie sandwich
        }
    }

    //this funcion check if the all field are filled
    boolean isFullTheAllTexBox(){
        String RN = ReserveNumberId.getText().toString();
        String CN = ClientNumber.getText().toString();
       // String IO = IsOpened.getText().toString();
        String RB = RentBegginning.getText().toString();
        String RE = RentEnd.getText().toString();
        String SK = StartKilometers.getText().toString();
     //   String EK = EndKilometers.getText().toString();
        String IF = IsFueled.getText().toString();
        String LF = LitersFueled.getText().toString();
       // String TP = TotalToPay.getText().toString();
        String CNB = CarNumber.getText().toString();
        if(RN.isEmpty()|| CN.isEmpty() ||  RB.isEmpty() || RE.isEmpty() || SK.isEmpty()||
               IF.isEmpty()|| LF.isEmpty()|| CNB.isEmpty()){
            return false;
        }
        return true;

    }
}
