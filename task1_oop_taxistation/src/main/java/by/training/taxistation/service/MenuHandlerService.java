package by.training.taxistation.service;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;
import by.training.taxistation.service.specification.search.SearchByCargoCapacityCarSpecificationImpl;
import by.training.taxistation.service.specification.search.SearchByPassengerCapacityCarSpecificationImpl;
import by.training.taxistation.service.specification.sort.SortByCarBrandAndCostImpl;
import by.training.taxistation.service.specification.sort.SortByCarBrandImpl;

import java.util.ArrayList;
import java.util.List;

public class MenuHandlerService {
    /**
     * car service initialization.
     */
    private final CarService carService = new CarServiceImpl();
    /**
     * car specification initialization.
     */
    private CarSpecification specification;

    /**
     * car cost.
     *
     * @return cost of all cars in taxi station
     */
    public int carsCost() {
        List<Car> cars = new ArrayList<>(carService.read());
        int sum = 0;
        for (Car car : cars) {
            sum += car.getCost();
        }
        return sum;
    }

    /**
     * cars sort by brand.
     *
     * @return cars sorted by brand
     */
    public List<Car> carsSortedByBrand() {
        specification = new SortByCarBrandImpl();
        return carService.query(specification);
    }

    /**
     * cars sort by brand and cost.
     *
     * @return cars sorted by brand and cost
     */
    public List<Car> carsSortedByBrandAndCost() {
        specification = new SortByCarBrandAndCostImpl();
        return carService.query(specification);
    }

    /**
     * search cars by passenger capacity.
     *
     * @param from search parameters
     * @param to   search parameters
     * @return list of detected vehicles by parameters
     */
    public List<Car> searchCarsByPassengerCapacity(
            final int from, final int to) {
        specification = new SearchByPassengerCapacityCarSpecificationImpl(
                from, to);
        return carService.query(specification);
    }

    /**
     * search cars by cargo capacity.
     *
     * @param from search parameters
     * @param to   search parameters
     * @return list of detected vehicles by parameters
     */
    public List<Car> searchCarsByCargoCapacity(final int from, final int to) {
        specification = new SearchByCargoCapacityCarSpecificationImpl(from, to);
        return carService.query(specification);
    }

}
