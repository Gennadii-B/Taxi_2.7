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
public class Test  implements Runnable{

    OrderReader orderReader = OrderReader.getInstance();
    DataBase dataBase = DataBase.getInstance();
    Random random = new Random();
    private int timeToSleap;
    private boolean isDo;

    public Test(boolean isDo) {
        this.isDo = isDo;
    }

    @Override
    public void run() {
        if(isDo)doTest();
    }

//эмулирует заполнение полей заказа после чего программа
//должна обработать этот заказ
    private void doTest(){
            for(int i = 0; i < 10; i++) {
                Order testOrder;
                testOrder = dataBase.getTestOrders().pollLast();
                println(testOrder.getId() + "");
                println(testOrder.getStartPoint());

                println(testOrder.getEndPoint());
                if(testOrder.isNeedBabySeat())
                    println(orderReader.texts.TEXT_WITH_BABYSAT);
                else println(orderReader.texts.TEXT_WITHOUT_BABYSAT);
                if(testOrder.isNeedSmoke())
                    println(orderReader.texts.TEXT_SMOKE);
                else println(orderReader.texts.TEXT_NO_SMOKE);
                if(Cars.CLASS_BUSINESS == testOrder.getNeedCarClass())
                    println(orderReader.texts.TEXT_BUSINESS);
                if(Cars.CLASS_ECONOMIC == testOrder.getNeedCarClass())
                    println(orderReader.texts.TEXT_ECONOMIC);

                dataBase.getActualOrders().addFirst(testOrder);
            }
    }



}
