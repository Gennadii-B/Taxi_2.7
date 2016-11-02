package ru.goldtaxi.Utilities;

import ru.goldtaxi.Entity.Car;
import ru.goldtaxi.Entity.Driver;
import java.util.ArrayList;


public class Initialization {


    public static ArrayList<Car> initCarArray() {
        ArrayList<Driver> Drivers = new ArrayList<Driver>();
        Drivers.add(new Driver("Василий Петрович Привет", "88003245"));
        Drivers.add(new Driver("Владимир Николаевич Фрейд", "88006830"));
        Drivers.add(new Driver("Армен Алексеевич Шире", "88009571"));
        Drivers.add(new Driver("Чен Джон Вали", "88001275"));
        Drivers.add(new Driver("Джеки Чен Петров", "88003729"));
        Drivers.add(new Driver("Алексей Геннадьевич Васюта", "88007392"));
        Drivers.add(new Driver("Камран Азарович Гюго", "88000034"));
        Drivers.add(new Driver("Виктор Мари Гюго", "88004626"));
        Drivers.add(new Driver("Альберт Эйнштейн", "88005518"));
        Drivers.add(new Driver("Гоги Когуашвили", "88009367"));

        ArrayList<Car> parking = new ArrayList<Car>();

        parking.add(new Car("Fiat", Drivers.get(0), "ку 053", true, false,
                Car.TYPE_OF_CLASS_ECONOMIC, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("BMW", Drivers.get(1), "тп 343", false, false,
                Car.TYPE_OF_CLASS_BUSYNESS, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("volvo", Drivers.get(2), "нр 884", false, false,
                Car.TYPE_OF_CLASS_ECONOMIC, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("Fiat", Drivers.get(3), "пк 752", false, true,
                Car.TYPE_OF_CLASS_ECONOMIC, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("Audi", Drivers.get(4), "дв 864", true, true,
                Car.TYPE_OF_CLASS_BUSYNESS, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("Lada", Drivers.get(5), "же 834", false, false,
                Car.TYPE_OF_CLASS_ECONOMIC, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("Lada", Drivers.get(6), "на 713", false, false,
                Car.TYPE_OF_CLASS_ECONOMIC, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("Ford", Drivers.get(7), "лп 853", true, false,
                Car.TYPE_OF_CLASS_BUSYNESS, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("Honda", Drivers.get(8), "лп 884", false, true,
                Car.TYPE_OF_CLASS_ECONOMIC, Car.TYPE_OF_STATUS_FREE));
        parking.add(new Car("Lada", Drivers.get(9), "ге 127", false, true,
                Car.TYPE_OF_CLASS_ECONOMIC, Car.TYPE_OF_STATUS_FREE));

        return parking;
    }
}
