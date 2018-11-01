package com.example.moish.carrentforcompany.model.adapter;

/**
 * Created by moish on 07/12/2017.
 */

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.moish.carrentforcompany.model.entities.CarReserve;
import com.example.moish.carrentforcompany.model.entities.CarReserve;
import com.example.moish.carrentforcompany.R;
import java.util.List;



/**
 * Created by Bruno on 30/11/2017.
 */

public class ReserveAdapter extends BaseAdapter {

    private final List<CarReserve> reserves;
    private final Activity activity;

    public ReserveAdapter(List<CarReserve> reserves, Activity activity) {
        this.reserves = reserves;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return reserves.size();
    }

    @Override
    public Object getItem(int i) {
        return reserves.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ((CarReserve) getItem(i)).getReserveNumber_id();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = activity.getLayoutInflater()
                    .inflate(R.layout.item_row, viewGroup, false);
        }
        CarReserve CarReserve = reserves.get(i);

        try {



            TextView ide = (TextView) view.findViewById(R.id.itemId);
            TextView name = (TextView) view.findViewById(R.id.itemName);

            String isOpened;
            if(CarReserve.isOpened()==1)
            {
                isOpened = "true";
            }
            else
            {
                isOpened = "false";
            }
int a =0;
            name.setText("Car Number: " + CarReserve.getCarNumber() + ",     Client Number: " + CarReserve.getClientNumber(
            )+",    Is the reserve opened: "+isOpened );
            ide.setText(Integer.toString(CarReserve.getReserveNumber_id()));

        }catch (Exception ex){ex.toString();}
        return view;

    }
    {
    }
}

