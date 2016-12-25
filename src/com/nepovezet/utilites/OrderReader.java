package com.nepovezet.utilites;

import com.nepovezet.entity.Cars;
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
public class OrderReader {
    private static OrderReader ourInstance = new OrderReader();

    public static OrderReader getInstance() {
        return ourInstance;
    }

    private OrderReader() {
    }

    static int idOrders = -1;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public Texts texts = new Texts();
    Order surrogateOrder;
    Pattern pattern = Pattern.compile("^([А-ЯA-Zа-яa-z]*\\s){1,4}\\s*\\d+[-\\d+А-ЯA-Zа-яa-z]?$");
    Matcher matcher;


    public Order newOrder() {

        String start;
        String end;
        boolean answerBabySeat;
        boolean answerNeedSmoke;
        int answerCarClass;
//ввод адресов маршрута
        println(texts.TEXT_START_POINT);
        start = getAddress();
        println(texts.TEXT_END_POINT);
        end = getAddress();
//требования заказчика (детское сидение, курящий салон, класс авто)
        println(texts.TEXT_QU_BABYSAT);
        answerBabySeat = getAnswerYN();
        println(texts.TEXT_QU_SMOKE);
        answerNeedSmoke = getAnswerYN();
        println(texts.TEXT_QU_CLASS);
        answerCarClass = getAnswerNeedCarClass();

        idOrders++;
//создание объекта заказа для дальнейшей обработки
        surrogateOrder = new Order(idOrders,
                start, end, answerBabySeat,
                answerNeedSmoke, answerCarClass);

        return surrogateOrder;
    }
//узнает какой класс авто нужен заказчику
    private int getAnswerNeedCarClass() {
        String answer;
        try{
            answer = reader.readLine();
            if(answer.equals("Y") || answer.equals("N"));
            else throw new TaxiException();
            if(answer.equals("Y"))return Cars.CLASS_BUSINESS;
            else return Cars.CLASS_ECONOMIC;

        }catch(TaxiException exc){
            System.out.println(exc);
            return Cars.CLASS_ECONOMIC;
        }catch(IOException e){
            System.out.println("error in/out");
            return Cars.CLASS_ECONOMIC;
        }
    }
//вопрос на да/нет
    public boolean getAnswerYN() {
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
        }catch (IOException e){
            System.out.println("error in/out");
            return false;
        }
    }
// узнает точку маршрута у заказчика
    private String getAddress() {
        boolean isOk = true;
        while(isOk) {
            try {
                String address = reader.readLine();
            matcher = pattern.matcher(address);
            if(matcher.matches())
                return address;
            else System.out.println(texts.TEXT_EXC_POINT);
            }catch(IOException e) {
                System.out.println("error in/out");
            }
        }
        return null;
    }


}


