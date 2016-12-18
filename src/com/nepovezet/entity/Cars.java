package com.nepovezet.entity;

/**
 * Created by gendy on 18.12.16.
 */
public enum Cars {

    TAXI_A0("OG 356", "Peugeot", Cars.CLASS_BUSYNESS),
    TAXI_A1("DG 743", "LADA", Cars.CLASS_ECONOMIC),
    TAXI_A2("GJ 833", "LADA", Cars.CLASS_ECONOMIC),
    TAXI_A3("QA 345", "LADA", Cars.CLASS_ECONOMIC),
    TAXI_A4("LI 753", "Skoda", Cars.CLASS_BUSYNESS),
    TAXI_A5("RT 742", "LADA", Cars.CLASS_ECONOMIC),
    TAXI_A6("NM 886", "LADA", Cars.CLASS_ECONOMIC),
    TAXI_A7("WE 777", "LADA", Cars.CLASS_ECONOMIC),
    TAXI_A8("ME 126", "BMW", Cars.CLASS_BUSYNESS),
    TAXI_A9("QK 043", "Chevrolet", Cars.CLASS_BUSYNESS);

    private String carNumber;
    private String carMark;
    private int carClass;

    public static final int CLASS_ECONOMIC = 0;
    public static final int CLASS_BUSYNESS = 1;

    Cars(String carNumber, String carMark, int carClass) {
        this.carNumber = carNumber;
        this.carMark = carMark;
        this.carClass = carClass;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getCarMark() {
        return carMark;
    }

    public int getCarClass() {
        return carClass;
    }
}
