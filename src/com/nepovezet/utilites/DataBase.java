package com.nepovezet.utilites;

import com.nepovezet.entity.Cars;
import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.tools.Kit;

/**
 * Created by N on 12.11.2016.
 * При запуске программы в конструкторе класса автоматически инициализируется
 * лист водителей c автомобилями
 */
public class DataBase {
    private static DataBase ourInstance = new DataBase();

     private Kit<Driver> drivers = new Kit<>();
     private Kit<Order> baseOrders = new Kit<>();

    private DataBase() {
        initialize();
    }

    private void initialize(){
        drivers.insert(new Driver("Alexand", "Brechalov", 88003535,
                Cars.TAXI_A0, 0, true, true));
        drivers.insert(new Driver("Boris", "Titiv", 88002463,
                Cars.TAXI_A1, 0, true, true));
        drivers.insert(new Driver("Andrey", "Makarov", 88004673,
                Cars.TAXI_A2, 0, true, true));
        drivers.insert(new Driver("Olga", "Batalina", 88003561,
                Cars.TAXI_A3, 0, true, true));
        drivers.insert(new Driver("Zahar", "Prelepin", 88008321,
                Cars.TAXI_A4, 0, true, true));
        drivers.insert(new Driver("Ella", "Pamfilova", 88007933,
                Cars.TAXI_A5, 0, true, true));
        drivers.insert(new Driver("Sergey", "Neverov", 88003122,
                Cars.TAXI_A6, 0, true, true));
        drivers.insert(new Driver("Sergey", "Aksenov", 88003651,
                Cars.TAXI_A7, 0, true, true));
        drivers.insert(new Driver("Pavel", "Krashennikov", 88001234,
                Cars.TAXI_A8, 0, true, true));
        drivers.insert(new Driver("Natalia", "Poklonskaya", 88004321,
                Cars.TAXI_A9, 0, true, true));
    }

    public static DataBase getInstance() {
        return ourInstance;
    }

    public Kit<Driver> getDrivers() {
        return drivers;
    }

    public Kit<Order> getBaseOrders() {
        return baseOrders;
    }
}
