package com.nepovezet.utilites;

import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;

/**
 * Created by N on 12.11.2016.
 * Здесь происходит перебор автомобилей, в случае соответствия условиям
 * возвращается нужный водитель с автомобилем
 *
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

        for (Driver driver : dataBase.getDrivers()) {
            if(driver.getStatus() == Driver.STATUS_FREE)
                synchronized (driver) {
                    if (driver.getStatus() == Driver.STATUS_FREE &&
                            driver.getCar().getCarClass() == order.getNeedCarClass() &&
                            driver.isHaveBabySeat() == order.isNeedBabySeat() &&
                            driver.isHaveSmoke() == order.isNeedSmoke()) {

                        needDriver = driver;
                        needDriver.setStatus(Driver.STATUS_RESERVED);
                        return needDriver;
                    }
                }
      }
        return null;
    }
}
