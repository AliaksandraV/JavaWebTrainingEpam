package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.Car;

public interface CarFactory {

    Car create(String[] arr);
}
