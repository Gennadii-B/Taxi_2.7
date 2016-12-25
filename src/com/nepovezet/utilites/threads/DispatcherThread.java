package com.nepovezet.utilites.threads;

import com.nepovezet.entity.Order;
import com.nepovezet.utilites.DataBase;

/**
 * Created by user on 23.12.2016.
 * поток который в случае заполнения "getActualOrders" поочередно вынимает
 * заказы и отправляет в собственный поток "OrderBookingThread" который в свою
 * очередь занимется подбором нужного авто
 */
public class DispatcherThread implements Runnable {
    DataBase dataBase = DataBase.getInstance();
    Order order;

    @Override
    public void run() {
        while(true) {
            if (!dataBase.getActualOrders().isEmpty())
                order = dataBase.getActualOrders().pollLast();

            if(order != null) {
                //создание потока для каждого полученного заказа
                new Thread(new OrderBookingThread(order)).start();
                order = null;
            }

            try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
        }
    }
}
