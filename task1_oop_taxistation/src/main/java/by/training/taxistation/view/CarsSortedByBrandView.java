package by.training.taxistation.view;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public class CarsSortedByBrandView extends BaseMenuView {
    /**
     * print cars sorted by brand.
     * @param cars sorted list of cars
     */
    public void print(final List<Car> cars) {
        printCars(cars);
    }
}
