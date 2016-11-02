package ru.goldtaxi;

import ru.goldtaxi.Entity.*;
import ru.goldtaxi.Utilities.*;

import java.util.ArrayList;


public class main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> CarArrayList = Initialization.initCarArray();
        while (true) {
            Order order = OrderReader.getInstance().orderRead();
            CarSearch.searchFreeCar(CarArrayList, order);
            OrderReader.anserCarNeed(order);
        }
    }
}
