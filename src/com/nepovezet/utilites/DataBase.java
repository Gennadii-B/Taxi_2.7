package com.nepovezet.utilites;

import com.nepovezet.entity.Car;
import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;

import java.util.ArrayList;

/**
 * Created by N on 12.11.2016.
 * При запуске программы в конструкторе класса автоматически инициализируется
 * листы водителей и автомобилей
 */
public class DataBase {
    private static DataBase ourInstance = new DataBase();

     ArrayList<Driver> drivers = new ArrayList<>();
     ArrayList<Car> parkingCars = new ArrayList<>();
     ArrayList<Order> baseOrders = new ArrayList<>();

    private DataBase() {
        parkingCars.add(new Car("df 834", "BMW", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, true, false));
        parkingCars.add(new Car("bt 352", "FIAT", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, true, true));
        parkingCars.add(new Car("lr 742", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, false));
        parkingCars.add(new Car("qw245", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, false));
        parkingCars.add(new Car("ot 248", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, true, false));
        parkingCars.add(new Car("kf 565", "Skoda", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, false, false));
        parkingCars.add(new Car("rt 045", "AUDI", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, false, true));
        parkingCars.add(new Car("yy 555", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, true));
        parkingCars.add(new Car("df 987", "AUDI", Car.CLASS_BUSYNESS, Car
                .STATUS_FREE, false, false));
        parkingCars.add(new Car("zz 777", "LADA", Car.CLASS_ECONOMIC, Car
                .STATUS_FREE, false, false));

        drivers.add(new Driver("Alexand", "Brechalov", 88003535, parkingCars.get(0), 0));
        drivers.add(new Driver("Boris", "Titiv", 88002463, parkingCars.get(1), 1));
        drivers.add(new Driver("Andrey", "Makarov", 88004673, parkingCars.get(2), 2));
        drivers.add(new Driver("Olga", "Batalina", 88003561, parkingCars.get(3), 3));
        drivers.add(new Driver("Zahar", "Prelepin", 88008321, parkingCars.get(4), 4));
        drivers.add(new Driver("Ella", "Pamfilova", 88007933, parkingCars.get(5), 5));
        drivers.add(new Driver("Sergey", "Neverov", 88003122, parkingCars.get(6), 6));
        drivers.add(new Driver("Sergey", "Aksenov", 88003651, parkingCars.get(7), 7));
        drivers.add(new Driver("Pavel", "Krashennikov", 88001234, parkingCars.get(8), 8));
        drivers.add(new Driver("Natalia", "Poklonskaya", 88004321, parkingCars.get(9), 9));
    }

    public static DataBase getInstance() {
        return ourInstance;
    }

}
