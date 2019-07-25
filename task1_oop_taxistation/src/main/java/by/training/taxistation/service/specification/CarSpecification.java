package by.training.taxistation.service.specification;

import by.training.taxistation.entity.car.Car;

import java.util.List;

public interface CarSpecification {
    /**
     * specification for sorting cars.
     *
     * @param cars car for sorting
     * @return the list of cars sorting by brand and cost
     */
    List<Car> query(List<Car> cars);
}
