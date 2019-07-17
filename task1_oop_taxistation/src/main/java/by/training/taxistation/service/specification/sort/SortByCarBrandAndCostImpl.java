package by.training.taxistation.service.specification.sort;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.SortCarSpecification;

import java.util.Comparator;
import java.util.List;

public class SortByCarBrandAndCostImpl implements SortCarSpecification {

    public List<Car> sort(List<Car> cars) {
        cars.sort(Comparator.comparing((Car o) -> o.getBrand().getTitle()).thenComparing((Car::getCost)));
        return cars;
    }

}
