package by.training.taxistation.service.specification;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public interface SearchCarSpecification extends CarSpecification {

    public List<Car> find(List<Car> cars);

}
