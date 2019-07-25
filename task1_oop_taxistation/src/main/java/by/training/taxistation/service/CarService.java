package by.training.taxistation.service;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public interface CarService {
    /**
     * connect with repository to add car to data store.
     *
     * @param car car
     */
    void create(Car car);

    /**
     * connect with repository to read car from data store.
     *
     * @return list of cars
     */
    List<Car> read();

    /**
     * connect with repository to delete car from data store.
     *
     * @param car car to delete
     */
    void delete(Car car);

    /**
     * connect with repository to read car from data store by specification.
     *
     * @param specification specification for query
     * @return list of cars
     */
    List<Car> query(CarSpecification specification);
}
