package com.nepovezet.utilites.threads;

import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.utilites.CarSelection;
import com.nepovezet.utilites.OrderReader;


/**
 * Created by user on 23.12.2016.
 */
public class OrderBookingThread implements Runnable {

    CarSelection carSelection = CarSelection.getInstance();
    OrderReader orderReader = OrderReader.getInstance();
    private Order order;
    Driver needDriver = null;
    static int counter = 0;
    boolean isSwitchFound = false;

    public OrderBookingThread(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        doSearchNeedCar();
        doSecondSearchNeedCar();
    }

    private void doSearchNeedCar(){
        counter++;
        needDriver = carSelection.search(order);
        if(needDriver != null){
            order.setNeedDriver(needDriver);
            isSwitchFound = true;
            new Thread(new ExecEmulationThread(order)).start();
            System.out.printf("%s %d %s",
                    orderReader.texts.TEXT_NUMER_ORDER,
                    order.getId(), orderReader.texts.TEXT_FOUND_CAR);
        }else if(needDriver == null) {
        }
    }

    private void doSecondSearchNeedCar(){
        if(!isSwitchFound) {
            System.out.printf("%s %d %s %s",
                    orderReader.texts.TEXT_NUMER_ORDER, order.getId(),
                    orderReader.texts.TEXT_ANSWER_NEGATIVE, "\n");
            isSwitchFound = false;
            threadSleep();
            doSearchNeedCar();
            if(needDriver == null)
                System.out.println(orderReader.texts.TEXT_NO_CAR);
        }
    }

    private void threadSleep(){
        try{
            Thread.sleep(60_000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.printf("%s %d %s", orderReader.texts.TEXT_NUMER_ORDER,
                order.getId(), orderReader.texts.TEXT_SECOND_SEARCH);
    }

}
