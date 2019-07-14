package by.training.taxistation.service;

import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.car.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortService {

    public List<Car> sortByCarBrand(TaxiStation station) {
        return station.getAll()
                .stream()
                .sorted(Comparator.comparing(car -> car.getBrand().name()))
                .collect(Collectors.toList());
    }

    public List<Car> sortByCarBrandAndCost(TaxiStation station) {
        Comparator<Car> comparator = Comparator
                .comparing((Car o) -> o.getBrand().name())
                .thenComparingInt(Car::getCost);

        return station.getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
