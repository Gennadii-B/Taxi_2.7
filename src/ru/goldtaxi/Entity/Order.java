package ru.goldtaxi.Entity;

public class Order {
     public Order(String start, String end, boolean babyseat, boolean smoke,
          int carclass){
        startPoint = start;
        endPoint = end;
        isNeedBabySeat = babyseat;
        isNeedSmokeCar = smoke;
        needCarClass = carclass;


    }


    private String startPoint;
    private String endPoint;
    private boolean isNeedBabySeat;
    private boolean isNeedSmokeCar;
    private int needCarClass;
    private String carReserver;
    private Car needCar = null;


    public Car getNeedCar() {
        return needCar;
    }

    public void setNeedCar(Car needCar) {
        this.needCar = needCar;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public boolean isNeedBabySeat() {
        return isNeedBabySeat;
    }

    public void setNeedBabySeat(boolean needBabySeat) {
        isNeedBabySeat = needBabySeat;
    }

    public boolean isNeedSmokeCar() {
        return isNeedSmokeCar;
    }

    public void setNeedSmokeCar(boolean needSmokeCar) {
        isNeedSmokeCar = needSmokeCar;
    }

    public int getNeedCarClass() {
        return needCarClass;
    }

    public void setNeedCarClass(int needCarClass) {
        this.needCarClass = needCarClass;
    }

    public String getCarReserver() {
        return carReserver;
    }

    public void setCarReserver(String carReserver) {
        this.carReserver = carReserver;
    }

}
