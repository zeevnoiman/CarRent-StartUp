package com.example.moish.carrentforcompany.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.example.moish.carrentforcompany.R;
import com.example.moish.carrentforcompany.model.adapter.BranchAdapter;
import com.example.moish.carrentforcompany.model.backend.DBManagerFactory;
import com.example.moish.carrentforcompany.model.entities.Branch;

import java.util.List;

/**
 * Created by moish on 09/12/2017.
 */

public class ListOfBranchs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_branch);

       getListItems();
    }

    private void getListItems(){

        new AsyncTask<Void, Void, List<Branch>>(){

            List<Branch> branches;

            @Override
            protected List<Branch> doInBackground(Void... voids) {
                branches = DBManagerFactory.getManager().getBranchs();
                return branches;
            }

            @Override
            protected void onPostExecute(List<Branch> branches) {
                initItemByListView(branches);
            }
        }.execute();

    }

    private void initItemByListView(List<Branch> branches){

        ListView lv = (ListView) findViewById(R.id.BranchesList);

        BranchAdapter adapter = new BranchAdapter(branches, this);

        lv.setAdapter(adapter);
    }

}

