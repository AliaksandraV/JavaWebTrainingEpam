package by.training.taxistation.repository;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.repository.factory.CarFactory;
import by.training.taxistation.repository.factory.CarFactoryImpl;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    List<String> carDescriptions;
    CarFactory carFactory;
    private final String delimiter = "|";

    public CarRepositoryImpl(List<String> validLinesFromFile) {
        carDescriptions = validLinesFromFile;
        carFactory = new CarFactoryImpl();
    }


    @Override
    public void create(Car car) {

    }

    @Override
    public List read() {
        List<Car> cars = new ArrayList<>();
        for (String description : carDescriptions) {
            String[] carParameters = description.split("\\" + delimiter);
            cars.add(carFactory.create(carParameters));
        }
        return cars;
    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public List query(CarSpecification specification) {
        return null;
    }

}
