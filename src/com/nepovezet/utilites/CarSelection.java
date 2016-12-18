package com.nepovezet.utilites;

import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;

/**
 * Created by N on 12.11.2016.
 * Здесь происходит перебор автомобилей, в случае соответствия условиям
 * вызывается метод Dialog.answerReservedCar(driver) который сообщает
 * всю нужную информацию об автомобиле.
 * В случае несоответствия вызывается Dialog.negativeAnswer()
 */
public class CarSelection {
    private static CarSelection ourInstance = new CarSelection();
    public static CarSelection getInstance() {
        return ourInstance;
    }
    private CarSelection() {
    }

    DataBase dataBase = DataBase.getInstance();
    Driver needDriver;

    public Driver search(Order order) {
        needDriver = null;
        for (Driver driver : dataBase.getDrivers()) {
            if (driver.getCar().getCarClass() == order.getNeedCarClass() &&
                    driver.isHaveBabySeat() == order.isNeedBabySeat() &&
                    driver.isHaveSmoke() == order.isNeedSmoke() &&
                    driver.getStatus() == Driver.STATUS_FREE) {

                        needDriver = driver;
                        break;
            }
        }
        return needDriver;
    }
}
