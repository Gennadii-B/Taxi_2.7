package com.nepovezet.utilites;

import com.nepovezet.entity.Cars;
import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.tools.Kit;

import java.util.LinkedList;

/**
 * Created by N on 12.11.2016.
 * При запуске программы в конструкторе класса автоматически инициализируется
 * лист водителей c автомобилями
 * а так же лист с тестовыми заказами
 */
public class DataBase {
    private static DataBase ourInstance = new DataBase();

     private volatile Kit<Driver> drivers = new Kit<>();
     private volatile LinkedList<Order> actualOrders = new LinkedList<>();
     private Kit<Order> archiveOrders = new Kit<>();
     private LinkedList<Order> testOrders = new LinkedList<>();

    private int numberOfTestUsers = 50;

    private DataBase() {
        initialize();
        initTestData();
    }

    private void initialize(){
        drivers.insert(new Driver("Alexand", "Brechalov", 88003535,
                Cars.TAXI_A0, 0, true, true));
        drivers.insert(new Driver("Boris", "Titiv", 88002463,
                Cars.TAXI_A1, 1, false, false));
        drivers.insert(new Driver("Andrey", "Makarov", 88004673,
                Cars.TAXI_A2, 2, true, false));
        drivers.insert(new Driver("Olga", "Batalina", 88003561,
                Cars.TAXI_A3, 3, false, false));
        drivers.insert(new Driver("Zahar", "Prelepin", 88008321,
                Cars.TAXI_A4, 4, true, false));
        drivers.insert(new Driver("Ella", "Pamfilova", 88007933,
                Cars.TAXI_A5, 5, true, false));
        drivers.insert(new Driver("Sergey", "Neverov", 88003122,
                Cars.TAXI_A6, 6, false, true));
        drivers.insert(new Driver("Sergey", "Aksenov", 88003651,
                Cars.TAXI_A7, 7, true, true));
        drivers.insert(new Driver("Pavel", "Krashennikov", 88001234,
                Cars.TAXI_A8, 8, true, false));
        drivers.insert(new Driver("Natalia", "Poklonskaya", 88004321,
                Cars.TAXI_A9, 9, false, false));
    }

    private void initTestData(){
        for(int i=0; i <numberOfTestUsers; i++) {
            testOrders.addFirst(new Order(1000, "Ubileynaya 31e", "Ubileynaya 31e",
                    true, true, Cars.CLASS_BUSINESS));
        }
//            testOrders.addFirst(new Order(1001, "Ubileynaya 31e", "Ubileynaya 31e",
//                    true, true, Cars.CLASS_BUSINESS));
//            testOrders.addFirst(new Order(1002, "Ubileynaya 31e", "Ubileynaya 31e",
//                    true, true, Cars.CLASS_BUSINESS));
//            testOrders.addFirst(new Order(1003, "Ubileynaya 31e", "Ubileynaya 31e",
//                    true, false, Cars.CLASS_ECONOMIC));
//            testOrders.addFirst(new Order(1004, "Ubileynaya 31e", "Ubileynaya 31e",
//                    false, false, Cars.CLASS_ECONOMIC));
//            testOrders.addFirst(new Order(1005, "Ubileynaya 31e", "Ubileynaya 31e",
//                    false, false, Cars.CLASS_ECONOMIC));
//            testOrders.addFirst(new Order(1006, "Ubileynaya 31e", "Ubileynaya 31e",
//                    true, true, Cars.CLASS_BUSINESS));
//            testOrders.addFirst(new Order(1007, "Ubileynaya 31e", "Ubileynaya 31e",
//                    true, true, Cars.CLASS_ECONOMIC));
//            testOrders.addFirst(new Order(1008, "Ubileynaya 31e", "Ubileynaya 31e",
//                    true, false, Cars.CLASS_BUSINESS));
//            testOrders.addFirst(new Order(1009, "Ubileynaya 31e", "Ubileynaya 31e",
//                    false, true, Cars.CLASS_ECONOMIC));

    }

    public static DataBase getInstance() {
        return ourInstance;
    }

    public Kit<Driver> getDrivers() {
        return drivers;
    }

    public LinkedList<Order> getActualOrders() {
        return actualOrders;
    }

    public void addOrderFirst(Order order){
        actualOrders.addFirst(order);
    }

    public Kit<Order> getArchiveOrders() {
        return archiveOrders;
    }

    public LinkedList<Order> getTestOrders() {
        return testOrders;
    }

    public void setNumberOfTestUsers(int numberOfTestUsers) {
        numberOfTestUsers = numberOfTestUsers;
    }
}
