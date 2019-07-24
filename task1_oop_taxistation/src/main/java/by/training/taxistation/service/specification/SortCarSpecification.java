package by.training.taxistation.service.specification;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public interface SortCarSpecification extends CarSpecification {

    public List<Car> sort(List<Car> cars);
}
