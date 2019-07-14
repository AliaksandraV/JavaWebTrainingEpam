package by.training.taxistation.repository;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public interface CarRepository {

    void create(Car car);

    List read();

    void delete(Car car);

    List query (CarSpecification specification);
}
