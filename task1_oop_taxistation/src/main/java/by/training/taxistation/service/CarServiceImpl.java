package by.training.taxistation.service;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.repository.CarRepository;
import by.training.taxistation.repository.CarRepositoryImpl;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public class CarServiceImpl implements CarService {
    /**
     * initialization car Repository.
     */
    private final CarRepository carRepository = new CarRepositoryImpl();
    /**
     * connect with repository to add car to data store.
     *
     * @param car car
     */
    @Override
    public void create(final Car car) {
        //some code here
    }
    /**
     * connect with repository to read car from data store.
     *
     * @return list of cars
     */
    @Override
    public List read() {
        return carRepository.read();
    }
    /**
     * connect with repository to delete car from data store.
     *
     * @param car car to delete
     */
    @Override
    public void delete(final Car car) {
        //some code here
    }
    /**
     * connect with repository to read car from data store by specification.
     *
     * @param specification specification for query
     * @return list of cars
     */
    @Override
    public List query(final CarSpecification specification) {
        return carRepository.query(specification);
    }
}
