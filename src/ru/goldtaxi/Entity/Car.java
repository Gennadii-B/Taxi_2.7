package ru.goldtaxi.Entity;

/**
 * Created by дима on 30.10.2016.
 */
public class Car {
    public Car(String mark, Driver driver, String number, boolean ishavebabyseat,
        boolean issmokecar, int carclass, String carstatus){
        carMark = mark;
        carDriver = driver;
        carNumber = number;
        isHaveBabySeat = ishavebabyseat;
        isSmokeCar = issmokecar;
        carClass = carclass;
        carStatus = carstatus;
    }

    private String carMark;
    private Driver carDriver;
    private String carNumber;
    private boolean isHaveBabySeat;
    private boolean isSmokeCar;
    private int carClass;
    private String carStatus;

    public static final int TYPE_OF_CLASS_ECONOMIC = 0;
    public static final int TYPE_OF_CLASS_BUSYNESS = 1;
    public static final String TYPE_OF_STATUS_FREE = "Свободен";
    public static final String TYPE_OF_STATUS_RESERVED = "Занят";

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public void setCarDriver(Driver carDriver) {
        this.carDriver = carDriver;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setHaveBabySeat(boolean haveBabySeat) {
        isHaveBabySeat = haveBabySeat;
    }

    public void setSmokeCar(boolean smokeCar) {
        isSmokeCar = smokeCar;
    }

    public void setCarClass(int carClass) {
        this.carClass = carClass;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarMark() {
        return carMark;
    }

    public Driver getCarDriver() {
        return carDriver;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public boolean isHaveBabySeat() {
        return isHaveBabySeat;
    }

    public boolean isSmokeCar() {
        return isSmokeCar;
    }

    public int getCarClass() {
        return carClass;
    }

    public String getCarStatus() {
        return carStatus;
    }




}
