package by.training.taxistation.service;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.repository.CarRepository;
import by.training.taxistation.repository.CarRepositoryImpl;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository = new CarRepositoryImpl();


    @Override
    public void create(Car car) {

    }

    @Override
    public List read() {
        return carRepository.read();
    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public List query(CarSpecification specification) {
        return carRepository.query(specification);
    }
}
