package by.training.taxistation.service.specification;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public interface CarSpecification {

    public List<Car> query(List<Car> cars);
}
