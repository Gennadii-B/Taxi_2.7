package com.nepovezet.utilites.threads;

import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.utilites.DataBase;
import com.nepovezet.utilites.OrderReader;

import java.util.Random;

/**
 * Created by user on 23.12.2016.
 * поток исполнения заказа
 * резервирует авто и дает кленту необходимую информацию
 *
 */
public class ExecEmulationThread implements  Runnable {

    OrderReader orderReader = OrderReader.getInstance();
    Order order;
    Random random = new Random();

    public ExecEmulationThread(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        order.getNeedDriver().setStatus(Driver.STATUS_RESERVED);
        System.out.println("\n-------------------------------------");
        //дает информацию об авто нужную заказчику
        orderReader.texts.textAnswerReservedCar(order);

//в пределах 30-90 сек эмулирует исполнение заказа
//после чего авто освобождается
            int sleepTime = (random.nextInt(60_000)+ 30_000);
            System.out.printf("%s %d %s", orderReader.texts.TEXT_TIME_COMPLETION,
                    (sleepTime/1000), orderReader.texts.TEXT_SECOND);
            System.out.println("\n-------------------------------------\n");
        try{
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        order.getNeedDriver().setStatus(Driver.STATUS_FREE);

    }
}
