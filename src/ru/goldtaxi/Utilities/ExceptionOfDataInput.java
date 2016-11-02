package ru.goldtaxi.Utilities;

/**
 * Created by N on 01.11.2016.
 */
public class ExceptionOfDataInput extends Exception {


    public String toString(){
        return "Некорректный ввод данных, следуйте инструкции\n" +
                "(автоматически выбран отрицательный ответ)";}
}
