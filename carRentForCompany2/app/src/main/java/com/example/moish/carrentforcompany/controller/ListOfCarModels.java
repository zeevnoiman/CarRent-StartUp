package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.example.moish.carrentforcompany.R;
import com.example.moish.carrentforcompany.model.adapter.CarModelAdapter;
import com.example.moish.carrentforcompany.model.adapter.ClientAdapter;
import com.example.moish.carrentforcompany.model.backend.DBManagerFactory;
import com.example.moish.carrentforcompany.model.entities.CarModel;
import com.example.moish.carrentforcompany.model.entities.Client;

import java.util.List;

/**
 * Created by moish on 09/12/2017.
 */

public class ListOfCarModels extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_client);

        getListItems();
    }

    private void getListItems(){

        new AsyncTask<Void, Void, List<CarModel>>(){

            List<CarModel> carModels;

            @Override
            protected List<CarModel> doInBackground(Void... voids) {
                carModels = DBManagerFactory.getManager().getCarModels();
                return carModels;
            }

            @Override
            protected void onPostExecute(List<CarModel> carModels) {
                initItemByListView(carModels);
            }
        }.execute();

    }

    private void initItemByListView(List<CarModel> carModels){

        ListView lv = (ListView) findViewById(R.id.clientsList);

        CarModelAdapter adapter = new CarModelAdapter(carModels, this);

        lv.setAdapter(adapter);
    }

}





