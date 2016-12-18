package com.nepovezet.entity;

/**
 * Created by N on 12.11.2016.
 */
public class Driver {

    private String name;
    private String surname;
    private int phoneNumber;
    private String status = STATUS_FREE;
    private Cars car;
    private int id;
    private boolean isHaveBabySeat;
    private boolean isHaveSmoke;

    public static final String STATUS_FREE = "свободен";
    public static final String STATUS_RESERVED = "занят";

    public Driver(String name, String surname, int phoneNumber, Cars car, int id,
                  boolean isHaveBabySeat, boolean isHaveSmoke) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.car = car;
        this.id = id;
        this.isHaveBabySeat = isHaveBabySeat;
        this.isHaveSmoke = isHaveSmoke;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Cars getCar() {
        return car;
    }

    public boolean isHaveBabySeat() {
        return isHaveBabySeat;
    }

    public boolean isHaveSmoke() {
        return isHaveSmoke;
    }
}
