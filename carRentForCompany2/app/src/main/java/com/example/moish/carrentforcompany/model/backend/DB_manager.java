package com.example.moish.carrentforcompany.model.backend;

import android.content.ContentValues;

import com.example.moish.carrentforcompany.model.entities.Branch;
import com.example.moish.carrentforcompany.model.entities.Car;
import com.example.moish.carrentforcompany.model.entities.CarModel;
import com.example.moish.carrentforcompany.model.entities.CarReserve;
import com.example.moish.carrentforcompany.model.entities.Client;

import java.util.List;

/**
 * Created by moish on 16/11/2017.
 */

public interface DB_manager {
    long addClient(ContentValues client);
    boolean removeClient(long id);
    boolean updateClient(long id, ContentValues values);
    List<Client> getClients();

    long addCarModel(ContentValues carModel);
    boolean removeCarModel(long id);
    boolean updateCarModel(long id, ContentValues values);
    List<CarModel> getCarModels();

    long addBranch(ContentValues branch);
    boolean removeBranch(long id);
    boolean updateBranch(long id, ContentValues values);
    List<Branch> getBranchs();

    long addCar(ContentValues car);
    boolean removeCar(long id);
    boolean updateCar(long id, ContentValues values);
    List<Car> getCar();

    long addCarReserve(ContentValues carReserve);
    boolean removeCarReserve(int id);
    boolean updateCarReserve(long id, ContentValues values);
    List<CarReserve> getCarReserve();

    public boolean isUpdate();
}
