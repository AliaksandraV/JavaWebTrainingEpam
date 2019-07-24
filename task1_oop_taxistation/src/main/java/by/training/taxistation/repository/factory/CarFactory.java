package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.Car;

public interface CarFactory {
    /**
     * create car instance.
     * @param carParameters car Parameters
     * @return car instance.
     * @throws InvalidCarDataException if car Parameters invalid
     */
    Car create(String[] carParameters) throws InvalidCarDataException;
}
