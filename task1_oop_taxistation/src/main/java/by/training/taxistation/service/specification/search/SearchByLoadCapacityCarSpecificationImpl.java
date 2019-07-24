package by.training.taxistation.service.specification.search;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByLoadCapacityCarSpecificationImpl implements CarSpecification {

    private int from;
    private int to;

    public SearchByLoadCapacityCarSpecificationImpl(int newFrom, int newTo) {
        from = newFrom;
        to = newTo;
    }

    @Override
    public List<Car> query(List<Car> cars) {
        return cars
                .stream()
                .filter(cargoTaxi -> {
                    int capacity = cargoTaxi.getCargoCapacity();
                    return capacity >= from && capacity <= to;
                })
                .collect(Collectors.toList());
    }
}
