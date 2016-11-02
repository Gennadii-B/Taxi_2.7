package ru.goldtaxi.Utilities;

import static ru.goldtaxi.Utilities.SystemOutPrint.print;
import static ru.goldtaxi.Utilities.SystemOutPrint.println;
import ru.goldtaxi.Entity.Car;
import ru.goldtaxi.Entity.Order;
import java.io.*;

public class OrderReader {
    private OrderReader(){};
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static OrderReader instance = new OrderReader();
    public static OrderReader getInstance(){
        return instance;
    }

    public static Order orderRead() throws Exception {
        boolean babyseat;
        boolean smoke;
        int carclass;

        println("Введите начальную точку вашего маршрута:");
        String start = reader.readLine();

        println("Введите конечную точку вашего маршрута:");
        String end = reader.readLine();

        println("нужно ли вам детское сиденье? Y/N :");
        babyseat = aswerBaby();

        println("будете ли вы курить в дороге? Y/N :");
        smoke = answerSmoke();

        println("вам нужен комфортный автомобиль? Y/N");
        carclass = answerClass();


        Order client = new Order(start, end, babyseat, smoke, carclass);
        return client;
    }

       private static boolean answerSmoke() throws Exception {
           String answer;
           try {
               answer = reader.readLine();
               if (answer.equals("Y") || answer.equals("N")) ;
               else throw new ExceptionOfDataInput();
               if (answer.equals("Y")) return true;
               else return false;
           }
           catch(ExceptionOfDataInput exc) {
               System.out.println(exc);
               return false;
           }
       }

        private static boolean aswerBaby() throws Exception{
        String answer;
        try {
            answer = reader.readLine();
            if (answer.equals("Y") || answer.equals("N")) ;
            else throw new ExceptionOfDataInput();
            if (answer.equals("Y")) return true;
            else return false;
        }
        catch(ExceptionOfDataInput exc){
            System.out.println(exc);
            return false;
        }
    }

    private static int answerClass() throws Exception{
        String answer;
        try {
            answer = reader.readLine();
            if (answer.equals("Y") || answer.equals("N")) ;
            else throw new ExceptionOfDataInput();
            if (answer.equals("Y")) return 1;
            else return 0;
        }
        catch(ExceptionOfDataInput exc) {
            System.out.println(exc);
            return 0;
        }

    }

    public static void anserCarNeed(Order order){
        
        println("К вам подъедет автомобиль: \n" +
                "номер: " + order.getNeedCar().getCarNumber() + "\n" +
                "марка: " + order.getNeedCar().getCarMark() + "\n" +
                "данные водителя: " + order.getNeedCar().getCarDriver().getName() + "|" +
                " контактный номер: " + order.getNeedCar().getCarDriver().getTelephone() + "\n");

    }
}
