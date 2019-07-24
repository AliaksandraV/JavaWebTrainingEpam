package by.training.taxistation.view;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public class SearchCarsByPassengerCapacityView extends BaseMenu {

    public void print(final List<Car> cars) {
        System.out.println("По указанным параметрам обнаружены следующие автомобили: ");
        printCars(cars);
    }

    public void printLabel() {
        System.out.println("Введите диапазон для поиска:");
    }

    public String readFromInput() {
        System.out.print("от: ");
        return readInput();
    }

    public String readToInput() {
        System.out.print("до: ");
        return readInput();
    }
}
