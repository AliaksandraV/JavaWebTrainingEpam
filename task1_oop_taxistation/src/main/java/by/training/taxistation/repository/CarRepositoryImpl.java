package by.training.taxistation.repository;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    /**
     * .
     */
    private final TaxiStation taxiStation
            = TaxiStation.getTaxiStationInstance();

    /**
     * .
     *
     * @param car .
     */
    @Override
    public void create(final Car car) {

    }

    /**
     * .
     *
     * @return .
     */
    @Override
    public List<Car> read() {
        return taxiStation.getCars();
    }

    /**
     * .
     *
     * @param car .
     */
    @Override
    public void delete(final Car car) {

    }

    /**
     * .
     *
     * @param specification .
     * @return .
     */
    @Override
    public List<Car> query(final CarSpecification specification) {
        return specification.query(read());
    }

}
