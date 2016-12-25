package com.nepovezet.tools;

import com.nepovezet.utilites.OrderReader;
import com.nepovezet.utilites.Texts;

/**
 * Created by N on 13.11.2016.
 */
public class TaxiException extends Exception {

    OrderReader orderReader = OrderReader.getInstance();
    Texts texts = orderReader.texts;

    public String toString(){
        return  texts.TEXT_EXC;}
}
