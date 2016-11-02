package ru.goldtaxi.Entity;


public class Driver {
    public Driver(String n, String t){
        name = n;
        telephone = t;
    }
    private String name;
    private String telephone;


    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setName(String name) {
        this.name = name;
    }


}
