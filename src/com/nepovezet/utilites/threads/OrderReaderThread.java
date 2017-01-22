package com.nepovezet.utilites.threads;

import com.nepovezet.entity.Order;
import com.nepovezet.utilites.DataBase;
import com.nepovezet.utilites.OrderReader;

/**
 * Created by user on 23.12.2016.
 * безперебойно принимает заказы
 */
public class OrderReaderThread implements Runnable {

    OrderReader orderReader = OrderReader.getInstance();
    DataBase dataBase = DataBase.getInstance();
    Order order;

    @Override
    public void run() {
        while(true) {
            order = orderReader.newOrder();
            dataBase.addOrderFirst(order);
            order = null;
        }
    }

    public OrderReaderThread(){
        new Thread(this).start();
    }
}
