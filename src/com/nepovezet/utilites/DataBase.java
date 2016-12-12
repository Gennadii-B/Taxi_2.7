package com.nepovezet.utilites;

import com.nepovezet.entity.Car;
import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.tools.Kit;

import java.util.ArrayList;

/**
 * Created by N on 12.11.2016.
 * При запуске программы в конструкторе класса автоматически инициализируется
 * листы водителей и автомобилей
 */
public class DataBase {
    private static DataBase ourInstance = new DataBase();

     private Kit<Driver> drivers = new Kit<>();
     private Kit<Car> parkingCars = new Kit<>();
     private Kit<Order> baseOrders = new Kit<>();

    private DataBase() {
        parkingCars.insert(new Car("df 834", "BMW", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, true, false));
        parkingCars.insert(new Car("bt 352", "FIAT", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, true, true));
        parkingCars.insert(new Car("lr 742", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, false));
        parkingCars.insert(new Car("qw245", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, false));
        parkingCars.insert(new Car("ot 248", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, true, false));
        parkingCars.insert(new Car("kf 565", "Skoda", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, false, false));
        parkingCars.insert(new Car("rt 045", "AUDI", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, false, true));
        parkingCars.insert(new Car("yy 555", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, true));
        parkingCars.insert(new Car("df 987", "AUDI", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, false, false));
        parkingCars.insert(new Car("zz 777", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, false));

        drivers.insert(new Driver("Alexand", "Brechalov", 88003535, parkingCars.pull(0), 0));
        drivers.insert(new Driver("Boris", "Titiv", 88002463, parkingCars.pull(1), 1));
        drivers.insert(new Driver("Andrey", "Makarov", 88004673, parkingCars.pull(2), 2));
        drivers.insert(new Driver("Olga", "Batalina", 88003561, parkingCars.pull(3), 3));
        drivers.insert(new Driver("Zahar", "Prelepin", 88008321, parkingCars.pull(4), 4));
        drivers.insert(new Driver("Ella", "Pamfilova", 88007933, parkingCars.pull(5), 5));
        drivers.insert(new Driver("Sergey", "Neverov", 88003122, parkingCars.pull(6), 6));
        drivers.insert(new Driver("Sergey", "Aksenov", 88003651, parkingCars.pull(7), 7));
        drivers.insert(new Driver("Pavel", "Krashennikov", 88001234, parkingCars.pull(8), 8));
        drivers.insert(new Driver("Natalia", "Poklonskaya", 88004321, parkingCars.pull(9), 9));
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
