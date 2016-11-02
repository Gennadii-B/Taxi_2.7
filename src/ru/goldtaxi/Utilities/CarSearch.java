package ru.goldtaxi.Utilities;

import ru.goldtaxi.Entity.*;

import java.util.ArrayList;


public class CarSearch {
    public static void searchFreeCar(ArrayList<Car> CarArrayList, Order order) {

        for (Car car: CarArrayList) {
            if(car.isHaveBabySeat() == order.isNeedBabySeat() &&
               car.isSmokeCar() == order.isNeedSmokeCar() &&
               car.getCarClass() == order.getNeedCarClass() &&
               car.getCarStatus() == Car.TYPE_OF_STATUS_FREE) {

                    order.setNeedCar(car);
                    car.setCarStatus(Car.TYPE_OF_STATUS_RESERVED);
                    break;
            }
        }


    }
}


