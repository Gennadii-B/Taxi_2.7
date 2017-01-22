package com.nepovezet.utilites.threads;

import com.nepovezet.entity.Cars;
import com.nepovezet.entity.Order;
import com.nepovezet.utilites.DataBase;
import com.nepovezet.utilites.OrderReader;

import java.util.Random;
import  static com.nepovezet.tools.SOPrint.println;

/**
 * Created by user on 24.12.2016.
 * эмуляция 10 заказов. С переодичностью 1-6 секунд вбрасывает
 * заказы на исполнение
 */
public class TestThrad implements Runnable{

    OrderReader orderReader = OrderReader.getInstance();
    DataBase dataBase = DataBase.getInstance();
    Random random = new Random();
    private int timeToSleap;
    private boolean isDo;

    public TestThrad(boolean isDo) {
        this.isDo = isDo;
        new Thread(this).start();
    }

    @Override
    public void run() {
        if(isDo)doTest();
    }

//эмулирует заполнение полей заказа после чего программа
//должна обработать этот заказ
    private void doTest(){
            while(!dataBase.getTestOrders().isEmpty()) {
                Order testOrder;
                testOrder = dataBase.getTestOrders().pollLast();

                dataBase.getActualOrders().addFirst(testOrder);
            }
    }

}
