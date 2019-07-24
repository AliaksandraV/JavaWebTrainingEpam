package by.training.taxistation.service.specification.sort;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.Comparator;
import java.util.List;

public class SortByCarBrandAndCostImpl implements CarSpecification {//SortCarSpecification {

    @Override
    public List<Car> query(List<Car> cars) {
        cars.sort(Comparator.comparing((Car o) -> o.getBrand().getTitle()).thenComparing((Car::getCost)));
        return cars;
    }

}
