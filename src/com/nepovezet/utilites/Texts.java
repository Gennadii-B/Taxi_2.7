package com.nepovezet.utilites;

import com.nepovezet.entity.Order;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by N on 24.11.2016.
 * тексты используемые в программе с возможностью выбора языка
 */
public class Texts {

    private static Locale ruLocale = new Locale("ru", "RU");
    private static Locale enLocale = new Locale("en", "EN");
    private static Locale needLocale = ruLocale;
    private String formatAnswer = "%n%s %d%n%s%n%s %s%n%s %s%n%s %s %s%n%s %d%n%n";

    ResourceBundle bundle = ResourceBundle.getBundle("com/nepovezet/lang", needLocale);

    public final String TEXT_START_POINT = bundle.getString("Text_Start_point");

    public final String TEXT_END_POINT = bundle.getString("Text_End_Point");

    public final String TEXT_QU_BABYSAT = bundle.getString("Text_Qu_Babyseat");

    public final String TEXT_QU_SMOKE = bundle.getString("Text_Qu_Smoke");

    public final String TEXT_QU_CLASS = bundle.getString("Text_Qu_Class");

    public final String TEXT_ANSWER_NEGATIVE = bundle.getString("Text_Answer_Negative");

    public final String TEXT_EXC = bundle.getString("Text_Exc");

    public final String TEXT_WITH_BABYSAT = bundle.getString("Babyseat_with");
    public final String TEXT_WITHOUT_BABYSAT = bundle.getString("Babyseat_without");

    public final String TEXT_SMOKE = bundle.getString("Smoke");
    public final String TEXT_NO_SMOKE = bundle.getString("No_smoke");

    public final String TEXT_BUSINESS = bundle.getString("Business");
    public final String TEXT_ECONOMIC = bundle.getString("Economic");

    public final String TEXT_TIME_COMPLETION = bundle.getString("Time_completion");

    public final String TEXT_SECOND = bundle.getString("Second");

    public final String TEXT_NUMER_ORDER = bundle.getString("Number_order");

    public final String TEXT_FOUND_CAR = bundle.getString("Found_car");

    public final String TEXT_NO_CAR = bundle.getString("No_car");

    public final String TEXT_SECOND_SEARCH = bundle.getString("Second_search");

    public final String TEXT_TEST = bundle.getString("Test");

    public  final String TEXT_ANSWER_RESERVED_CAR_0 = bundle.getString("Text_Ans_Reserved_Car_0");
    public  final String TEXT_ANSWER_RESERVED_CAR_1 = bundle.getString("Text_Ans_Reserved_Car_1");
    public  final String TEXT_ANSWER_RESERVED_CAR_2 = bundle.getString("Text_Ans_Reserved_Car_2");
    public  final String TEXT_ANSWER_RESERVED_CAR_3 = bundle.getString("Text_Ans_Reserved_Car_3");
    public  final String TEXT_ANSWER_RESERVED_CAR_4 = bundle.getString("Text_Ans_Reserved_Car_4");
    public  final String TEXT_ANSWER_RESERVED_CAR_5 = bundle.getString("Text_Ans_Reserved_Car_5");
    public  final String TEXT_EXC_POINT = bundle.getString("Exc_Point");

    public void textAnswerReservedCar(Order order){
        System.out.printf(formatAnswer, TEXT_ANSWER_RESERVED_CAR_0, order.getId(), TEXT_ANSWER_RESERVED_CAR_1,
                TEXT_ANSWER_RESERVED_CAR_2, order.getNeedDriver().getCar().getCarMark(), TEXT_ANSWER_RESERVED_CAR_3,
                order.getNeedDriver().getCar().getCarNumber(), TEXT_ANSWER_RESERVED_CAR_4, order.getNeedDriver().getName(),
                order.getNeedDriver().getSurname(),
                TEXT_ANSWER_RESERVED_CAR_5, order.getNeedDriver().getPhoneNumber());

    }


    public void setNeedLocale(Locale needLocale) {
        this.needLocale = needLocale;
    }

    public Locale getRuLocale() {
        return ruLocale;
    }

    public Locale getEnLocale() {
        return enLocale;
    }
}
