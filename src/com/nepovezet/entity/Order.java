package com.nepovezet.entity;

/**
 * Created by N on 12.11.2016.
 */
public class Order {

    private int id;
    private String startPoint;
    private String endPoint;
    private boolean isNeedBabySeat;
    private boolean isNeedSmoke;
    private int needCarClass;
    private Driver needDriver = null;

    public Order(int id, String startPoint, String endPoint, boolean isNeedBabySeat,
                 boolean isNeedSmoke, int needCarClass) {
        this.id = id;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.isNeedBabySeat = isNeedBabySeat;
        this.isNeedSmoke = isNeedSmoke;
        this.needCarClass = needCarClass;
    }

    public boolean isNeedBabySeat() {
        return isNeedBabySeat;
    }

    public boolean isNeedSmoke() {
        return isNeedSmoke;
    }

    public int getNeedCarClass() {
        return needCarClass;
    }

    public  void setNeedDriver(Driver needDriver) {
        this.needDriver = needDriver;
    }

    public Driver getNeedDriver() {
        return needDriver;
    }

    public int getId() {
        return id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }


}
