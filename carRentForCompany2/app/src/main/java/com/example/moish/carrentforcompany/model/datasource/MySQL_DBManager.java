package com.example.moish.carrentforcompany.model.datasource;

import android.content.ContentValues;
import android.widget.Toast;

import com.example.moish.carrentforcompany.model.backend.DB_manager;
import com.example.moish.carrentforcompany.model.backend.Functions;
import com.example.moish.carrentforcompany.model.entities.Branch;
import com.example.moish.carrentforcompany.model.entities.Car;
import com.example.moish.carrentforcompany.model.entities.CarModel;
import com.example.moish.carrentforcompany.model.entities.CarReserve;
import com.example.moish.carrentforcompany.model.entities.Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.moish.carrentforcompany.model.backend.Lists;

import static com.example.moish.carrentforcompany.model.backend.Lists.freeCars;
import static com.example.moish.carrentforcompany.model.backend.Lists.removeCar;

/**
 * Created by moish on 18/12/2017.
 */

public class MySQL_DBManager implements DB_manager {


    private final String UserName="fischbei";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/";



    @Override
    public boolean removeClient(long id) {
        return false;
    }

    @Override
    public boolean updateClient(long id, ContentValues values) {
        return false;
    }

    @Override public List<Client> getClients() {
        List<Client> result = new ArrayList<Client>();
        try {
            String str = PHPtools.GET(WEB_URL + "Client.php");
            JSONArray array = new JSONObject(str).getJSONArray("Client");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Client client = new Client();
                client.setLastName(jsonObject.getString("lastName"));
                client.setFirstName(jsonObject.getString("firstName"));
                client.setId(jsonObject.getInt("_id"));
                client.setPhoneNumber(jsonObject.getString("phoneNumber"));
                client.setEmail(jsonObject.getString("email"));
                client.setCreditCardNumber(jsonObject.getLong("creditCardNumber"));

                result.add(client);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public long addClient(ContentValues values)
    {
        try {
            String result = PHPtools.POST(WEB_URL + "/addClient.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addClient:\n" + result);
            return id;
        } catch (IOException e)
        {
            printLog("addClient Exception:\n" + e);
            return -1;
        }
    }

    private void printLog(String s) {
       // Toast.makeText(, "There is an empty field, please fill in: ", Toast.LENGTH_LONG).show();
    }

    private void SetUpdate() {






    }

    @Override
    public long addCarModel(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addCarModel.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addCarModel:\n" + result);
            return id;
        } catch (IOException e)
        {
            printLog("addCarModel Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public boolean removeCarModel(long id) {
        return false;
    }

    @Override
    public boolean updateCarModel(long id, ContentValues values) {
        return false;
    }

    @Override
    public List<CarModel> getCarModels() {
        List<CarModel> result = new ArrayList<CarModel>();
        try {
            String str = PHPtools.GET(WEB_URL + "CarModel.php");
            JSONArray array = new JSONObject(str).getJSONArray("CarModel");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                CarModel carModel = new CarModel();
                carModel.setModelName(jsonObject.getString("modelName"));
                carModel.setCompanyName(jsonObject.getString("companyName"));
                carModel.setMotorVolume(jsonObject.getInt("motorVolume"));
                carModel.setNumberOfSeats(jsonObject.getInt("numberOfSeats"));
                carModel.setAutomatic(jsonObject.getInt("isAutomatic"));
                carModel.setModelCode(jsonObject.getInt("_id"));

                result.add(carModel);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long addBranch(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addBranch.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addBranch:\n" + result);
            return id;
        } catch (IOException e)
        {
            printLog("addBranch Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public boolean removeBranch(long id) {
        return false;
    }

    @Override
    public boolean updateBranch(long id, ContentValues values) {
        return false;
    }

    @Override
    public List<Branch> getBranchs() {
        List<Branch> result = new ArrayList<Branch>();
        try {
            String str = PHPtools.GET(WEB_URL + "Branch.php");
            JSONArray array = new JSONObject(str).getJSONArray("Branch");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Branch branch = new Branch();
                branch.setNumberOfParkingAvailable(jsonObject.getInt("NumberOfParkingAvailable"));
                branch.setAdressNumber(jsonObject.getString("AdressNumber"));
                branch.setCity(jsonObject.getString("City"));
                branch.setStreet(jsonObject.getString("Street"));
                branch.setBranchNumber_id(jsonObject.getInt("_id"));

                result.add(branch);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long addCar(ContentValues values) {
        try {
            String resultCar = PHPtools.POST(WEB_URL + "addCar.php", values);
            String resultFreeCar = PHPtools.POST(WEB_URL + "addFreeCars.php", values);

            if(resultCar.length() > 10){
                printLog(resultCar);
                return -1;
            }

            if(resultFreeCar.length() > 10){
                printLog(resultFreeCar);
                return -2;
            }

            long id = Long.parseLong(resultCar);
            if (id > 0)
                SetUpdate();
            printLog("addCar:\n" + resultCar);
            return id;
        } catch (IOException e)
        {
            printLog("addCar Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public boolean removeCar(long id) {
        return false;
    }

    @Override
    public boolean updateCar(long id, ContentValues values) {
        return false;
    }//...........................................................................................................

    @Override
    public List<Car> getCar() {
        List<Car> result = new ArrayList<Car>();
        try {
            String str = PHPtools.GET(WEB_URL + "Car.php");
            JSONArray array = new JSONObject(str).getJSONArray("Car");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                Car car = new Car();
                car.setCarNumber_id(jsonObject.getInt("_id"));
                car.setFixedBranch(jsonObject.getInt("fixedBranch"));
                car.setKilometersTraveled(jsonObject.getInt("kilometersTraveled"));
                car.setModel(jsonObject.getInt("model"));

                result.add(car);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long addCarReserve(ContentValues values) {
        try {
            String result = PHPtools.POST(WEB_URL + "/addReserve.php", values);
            String resultRemove = PHPtools.POST(WEB_URL + "/deleteFreeCar.php", values);

           /* //    values.put(Functions.CarConst.CAR_NUMBER, _id.getText().toString());
            ContentValues v = new ContentValues();
            v.put(Functions.CarConst.CAR_NUMBER,Integer.toString((Functions.contentValuesToCarReserve(values).getCarNumber())));
            String resultRemove = PHPtools.POST(WEB_URL + "/deleteFreeCar.php", v);*/
            if(result.length() > 10){
                printLog(result);
                return -1;
            }
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addReserve:\n" + result);

            int carId = values.getAsInteger(Functions.CarReserveConst.CAR_NUMBER);
            removeCar(carId);

            return id;
        } catch (IOException e)
        {
            printLog("addReserve Exception:\n" + e);
            return -1;
        }
    }

    @Override
    public boolean removeCarReserve(int id) {
        return false;
    }

    @Override
    public boolean updateCarReserve(long id, ContentValues values) {
        return false;
    }

    @Override
    public List<CarReserve> getCarReserve() {
        List<CarReserve> result = new ArrayList<CarReserve>();
        try {
            String str = PHPtools.GET(WEB_URL + "CarReserve.php");
            JSONArray array = new JSONObject(str).getJSONArray("CarReserve");
            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                CarReserve carReserve = new CarReserve();
                carReserve.setCarNumber(jsonObject.getInt("carNumber"));
                carReserve.setClientNumber(jsonObject.getInt("clientNumber"));
                carReserve.setEndKilometers(jsonObject.getInt("endKilometers"));
                carReserve.setFueled(jsonObject.getInt("isFueled"));
                carReserve.setLitersFueled(jsonObject.getInt("litersFueled"));
                carReserve.setOpened(jsonObject.getInt("isOpened"));
                carReserve.setRentBegginingDate(jsonObject.getString("rentBegginingDate"));
                carReserve.setRentEndDate(jsonObject.getString("rentEndDate"));
                carReserve.setReserveNumber_id(jsonObject.getInt("_id"));
                carReserve.setStartKilometers(jsonObject.getLong("startKilometers"));
                carReserve.setTotalToPay(jsonObject.getLong("totalToPay"));

                result.add(carReserve);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isUpdate() {
        return false;
    }


}