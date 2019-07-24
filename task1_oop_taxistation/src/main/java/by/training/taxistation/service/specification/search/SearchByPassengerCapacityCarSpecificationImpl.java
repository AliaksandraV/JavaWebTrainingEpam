package by.training.taxistation.service.specification.search;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByPassengerCapacityCarSpecificationImpl implements CarSpecification {

    private int from;
    private int to;

    public SearchByPassengerCapacityCarSpecificationImpl(int newFrom, int newTo) {
        from = newFrom;
        to = newTo;
    }

    @Override
    public List<Car> query(List<Car> cars) {
        return cars
                .stream()
                .filter(taxi -> {
                    int capacity = taxi.getPassengerCapacity();
                    return capacity >= from && capacity <= to;
                })
                .collect(Collectors.toList());

    }

}
