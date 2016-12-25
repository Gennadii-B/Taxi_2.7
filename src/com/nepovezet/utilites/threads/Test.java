package com.nepovezet.utilites.threads;

import com.nepovezet.entity.Cars;
import com.nepovezet.entity.Order;
import com.nepovezet.utilites.DataBase;
import com.nepovezet.utilites.OrderReader;

import java.util.Random;
import  static com.nepovezet.tools.SOPrint.println;

/**
 * Created by user on 24.12.2016.
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

    private void doTest(){
            for(int i = 0; i < 10; i++) {
                Order testOrder;
                testOrder = dataBase.getTestOrders().pollLast();
                println(testOrder.getStartPoint());

                threadSleepHalfSecond();
                println(testOrder.getEndPoint());
                threadSleepHalfSecond();
                if(testOrder.isNeedBabySeat())
                    println(orderReader.texts.TEXT_WITH_BABYSAT);
                else println(orderReader.texts.TEXT_WITHOUT_BABYSAT);
                threadSleepHalfSecond();
                if(testOrder.isNeedSmoke())
                    println(orderReader.texts.TEXT_SMOKE);
                else println(orderReader.texts.TEXT_NO_SMOKE);
                threadSleepHalfSecond();
                if(Cars.CLASS_BUSINESS == testOrder.getNeedCarClass())
                    println(orderReader.texts.TEXT_BUSINESS);
                if(Cars.CLASS_ECONOMIC == testOrder.getNeedCarClass())
                    println(orderReader.texts.TEXT_ECONOMIC);

                threadSleepHalfSecond();
                dataBase.getActualOrders().addFirst(testOrder);
                threadSleep();
            }
    }

    private void threadSleep(){
        timeToSleap = random.nextInt(5) * 1000;
        try {
            Thread.sleep(timeToSleap + 1);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }

    private void threadSleepHalfSecond(){
        try {
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
