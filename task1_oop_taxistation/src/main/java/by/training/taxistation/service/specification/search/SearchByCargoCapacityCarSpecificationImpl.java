package by.training.taxistation.service.specification.search;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByCargoCapacityCarSpecificationImpl
        implements CarSpecification {
    /**
     * began search from this value.
     */
    private int from;
    /**
     * look up to this value.
     */
    private int to;

    /**
     * constructor with search parameters.
     *
     * @param newFrom value for <from> variable
     * @param newTo   value for <to> variable
     */
    public SearchByCargoCapacityCarSpecificationImpl(
            final int newFrom, final int newTo) {
        from = newFrom;
        to = newTo;
    }

    /**
     * specification for searching car by cargo capacity.
     *
     * @param cars car for searching by load capacity
     * @return the list of cars found in the search options
     */
    @Override
    public List<Car> query(final List<Car> cars) {
        return cars
                .stream()
                .filter(cargoTaxi -> {
                    int capacity = cargoTaxi.getCargoCapacity();
                    return capacity >= from && capacity <= to;
                })
                .collect(Collectors.toList());
    }
}
