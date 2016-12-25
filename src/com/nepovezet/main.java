package com.nepovezet;

import com.nepovezet.utilites.LanguageSelection;
import com.nepovezet.utilites.threads.Test;
import com.nepovezet.utilites.OrderReader;
import com.nepovezet.utilites.threads.DispatcherThread;
import com.nepovezet.utilites.threads.OrderReaderThread;

/**
 * Created by N on 11.11.2016.
 */
public class main {
    public static void main(String[] args) throws Exception {

        OrderReader orderReader = OrderReader.getInstance();
        LanguageSelection languageSelection = new LanguageSelection();

        System.out.println("Taxi nepovezet v2.7\n");

        languageSelection.quLocale();
        System.out.println(orderReader.texts.TEXT_TEST);

        Thread test = new Thread(new Test(orderReader.getAnswerYN()));
        Thread orderReaderThread = new Thread(new OrderReaderThread());
        Thread dispatcherThread = new Thread(new DispatcherThread());

        test.start();
        orderReaderThread.start();
        dispatcherThread.start();


    }
}
