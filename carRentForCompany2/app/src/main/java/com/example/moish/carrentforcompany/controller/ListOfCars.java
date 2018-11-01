package com.example.moish.carrentforcompany.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.moish.carrentforcompany.R;
import com.example.moish.carrentforcompany.model.adapter.CarAdapter;
import com.example.moish.carrentforcompany.model.backend.DBManagerFactory;
import com.example.moish.carrentforcompany.model.entities.Car;

import java.util.List;

public class ListOfCars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_cars);

        getListItems();
    }

    private void getListItems(){

        new AsyncTask<Void, Void, List<Car>>(){

            List<Car> cars;

            @Override
            protected List<Car> doInBackground(Void... voids) {
                cars = DBManagerFactory.getManager().getCar();
                return cars;
            }

            @Override
            protected void onPostExecute(List<Car> cars) {
                initItemByListView(cars);
            }
        }.execute();

    }

    private void initItemByListView(List<Car> cars){

        ListView lv = (ListView) findViewById(R.id.carsList);

        CarAdapter adapter = new CarAdapter(cars, this);

        lv.setAdapter(adapter);
    }

}
