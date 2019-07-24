package by.training.taxistation.service;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public interface CarService {

    void create(Car car);

    List <Car> read();

    void delete(Car car);

    List <Car> query (CarSpecification specification);
}
