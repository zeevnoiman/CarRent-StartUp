package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.example.moish.carrentforcompany.R;
import com.example.moish.carrentforcompany.model.adapter.ClientAdapter;
import com.example.moish.carrentforcompany.model.adapter.ReserveAdapter;
import com.example.moish.carrentforcompany.model.backend.DBManagerFactory;
import com.example.moish.carrentforcompany.model.entities.CarReserve;
import com.example.moish.carrentforcompany.model.entities.Client;

import java.util.List;

/**
 * Created by Daniel on 09/12/2017.
 */

public class ListOfReserves extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reserves);

        getListItems();
    }



    private void getListItems(){

        new AsyncTask<Void, Void, List<CarReserve>>(){

            List<CarReserve> reserves;


            @Override
            protected List<CarReserve> doInBackground(Void... voids) {
                reserves = DBManagerFactory.getManager().getCarReserve();
                return reserves;
            }

            @Override
            protected void onPostExecute(List<CarReserve> reserves) {
                initItemByListView(reserves);
            }
        }.execute();

    }

    private void initItemByListView(List<CarReserve> reserves){

        ListView lv = (ListView) findViewById(R.id.reservesList);

        ReserveAdapter adapter = new ReserveAdapter(reserves, this);

        lv.setAdapter(adapter);
    }

}
