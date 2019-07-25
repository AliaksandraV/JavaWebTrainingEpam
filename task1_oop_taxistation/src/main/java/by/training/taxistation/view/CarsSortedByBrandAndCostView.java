package by.training.taxistation.view;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public class CarsSortedByBrandAndCostView extends BaseMenuView {
    /**
     * print cars sorted by brand and cost.
     * @param cars sorted list of cars
     */
    public void print(final List<Car> cars) {
        printCars(cars);
    }
}
