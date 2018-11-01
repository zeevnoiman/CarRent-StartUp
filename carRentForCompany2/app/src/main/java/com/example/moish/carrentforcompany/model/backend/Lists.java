package com.example.moish.carrentforcompany.model.backend;

import com.example.moish.carrentforcompany.model.entities.Car;

import java.util.List;

/**
 * Created by moish on 15/01/2018.
 */

public class Lists {

    public static List<Car> freeCars;


    public static boolean removeCar(int id) {
        Boolean isPartOf = false;
        Car carToRemove = null;
        for (Car c:freeCars) {
            if(c.getCarNumber_id() == id) {
                isPartOf = true;
                carToRemove = c;
                break;
            }
        }
        freeCars.remove(carToRemove);
        return isPartOf;
    }

}
