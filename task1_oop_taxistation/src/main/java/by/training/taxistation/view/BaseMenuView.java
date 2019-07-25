package by.training.taxistation.view;

import by.training.taxistation.entity.car.Car;

import java.util.List;
import java.util.Scanner;

public abstract class BaseMenuView {
    /**
     * read input from console.
     * @return input
     */
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    /**
     * print list of cars.
     * @param cars car list for print
     */
    public void printCars(final List<Car> cars) {
        System.out.println("-----------------------------------------------"
                        + "------------------------------------------------"
                        + "--------------------------");
        System.out.println(String.format(
                "|%-20s|%-15s|%-20s|%-23s|%-15s|%-9s|%-11s|",
                " Марка автомобиля:",
                " Модель:",
                " Грузоподъемность:",
                " Пассажировместимость:",
                " Номерной знак:",
                " Пробег:",
                " Стоимость:"
        ));
        System.out.println("-----------------------------------------------"
                + "------------------------------------------------"
                + "--------------------------");
        for (Car car : cars) {
            System.out.println(
                    String.format(
                            "|%-20s|%-15s|%-20s|%-23s|%-15s|%-9s|%-11s|",
                            car.getBrand().getTitle(),
                            car.getModel(),
                            car.getCargoCapacity(),
                            car.getPassengerCapacity(),
                            car.getPlateNumber(),
                            car.getMileage(),
                            car.getCost()
                    ));
        }
        System.out.println("-----------------------------------------------"
                + "------------------------------------------------"
                + "--------------------------");
    }

}
