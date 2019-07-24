package by.training.taxistation.repository;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public interface CarRepository {
    /**
     * .
     *
     * @param car .
     */
    void create(Car car);

    /**
     * .
     *
     * @return .
     */
    List<Car> read();

    /**
     * .
     *
     * @param car .
     */
    void delete(Car car);

    /**
     * .
     *
     * @param specification .
     * @return .
     */
    List<Car> query(CarSpecification specification);
}
