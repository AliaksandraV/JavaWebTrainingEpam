package by.training.taxistation.view;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public class CarListView extends BaseMenuView {
    /**
     * print car list.
     * @param cars list of cars
     */
    public void print(final List<Car> cars) {
        printCars(cars);
    }
}
