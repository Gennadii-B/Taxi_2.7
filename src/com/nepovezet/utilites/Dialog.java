package com.nepovezet.utilites;

import com.nepovezet.entity.Car;
import com.nepovezet.entity.Driver;
import com.nepovezet.entity.Order;
import com.nepovezet.tools.TaxiException;

import static com.nepovezet.tools.SOPrint.println;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by N on 12.11.2016.
 * этот класс ведет диалог с пользователем, помогает создать заявку на автомобиль и
 * дает ответы на его запрос
 */
public class Dialog {
    private static Dialog ourInstance = new Dialog();

    public static Dialog getInstance() {
        return ourInstance;
    }

    private Dialog() {
    }

    DataBase dataBase = DataBase.getInstance();
    static int idOrders = -1;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public Texts texts = new Texts();
    Order needOrder;
    boolean isOk = true;
    Pattern pattern = Pattern.compile("^([А-Я]?[а-я]*\\s){2,4}\\s*\\d+\\-\\d+$");
    Matcher matcher;


    public Order newOrder() throws Exception {

        String start = "";
        String end = "";
        boolean answerBabySeat;
        boolean answerNeedSmoke;
        int answerCarClass;

        println(texts.TEXT_START_POINT);
        start = setAddress();


        println(texts.TEXT_END_POINT);
        end = setAddress();

        println(texts.TEXT_QU_BABY_SEAT);
        answerBabySeat = setAnswerBool();

        println(texts.TEXT_QU_SMOKE);
        answerNeedSmoke = setAnswerBool();

        println(texts.TEXT_QU_CLASS);
        answerCarClass = setAnswerCarClass();

        idOrders++;

        needOrder = new Order(idOrders,
                start, end, answerBabySeat,
                answerNeedSmoke, answerCarClass);
        dataBase.getBaseOrders().insert(needOrder);

        return needOrder;
    }

    //вызывается в случае несоответствия ни одного авто
    public void negativeAnswer(){
        println(texts.TEXT_ANSWER_NEGATIVE);
    }
    //дает всю инфу о нужном авто
    public void reserveCar(Driver driver){
        driver.getCar().setStatus(Car.STATUS_RESERVED);
        needOrder.setNeedDriver(driver);
        texts.textAnswerReservedCar(driver);
    }
    //следующие два метода обрабатывают запросы пользователя
    private int setAnswerCarClass() throws Exception{
        String answer;
        try{
            answer = reader.readLine();
            if(answer.equals("Y") || answer.equals("N"));
            else throw new TaxiException();
            if(answer.equals("Y"))return Car.CLASS_BUSYNESS;
            else return Car.CLASS_ECONOMIC;

        }catch(TaxiException exc){
            System.out.println(exc);
            return Car.CLASS_ECONOMIC;
        }
    }

    private boolean setAnswerBool() throws Exception{
        String answer;
        try{
            answer = reader.readLine();
            if(answer.equals("Y") || answer.equals("N"));
            else throw new TaxiException();
            if(answer.equals("Y"))return true;
            else return false;

        }catch(TaxiException exc){
            System.out.println(exc);
            return false;
        }
    }

    private String setAddress() throws IOException{
        boolean isOk = true;
        while(isOk) {
            String address = reader.readLine();
            matcher = pattern.matcher(address);
            if(matcher.matches())
                return address;
            else System.out.println(texts.TEXT_EXC_POINT);
        }
        return null;
    }

    public static int getIdOrders() {
        return idOrders;
    }

}


