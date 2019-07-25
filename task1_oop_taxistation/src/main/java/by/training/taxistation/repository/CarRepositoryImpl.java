package by.training.taxistation.repository;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    /**
     * Taxi station instance is a storage for cars.
     */
    private final TaxiStation taxiStation
            = TaxiStation.getInstance();

    /**
     * Add car to the taxi station storage.
     *
     * @param car car.
     */
    @Override
    public void create(final Car car) {

    }

    /**
     * Read list of cars from taxi station storage.
     *
     * @return car list.
     */
    @Override
    public List<Car> read() {
        return taxiStation.getCars();
    }

    /**
     * Delet car from taxi station storage.
     *
     * @param car car for deleting from storage.
     */
    @Override
    public void delete(final Car car) {

    }

    /**
     * returns the list of cars with the specified specification.
     *
     * @param specification specification for query.
     * @return the list of cars with the specified specification.
     */
    @Override
    public List<Car> query(final CarSpecification specification) {
        return specification.query(read());
    }

}
