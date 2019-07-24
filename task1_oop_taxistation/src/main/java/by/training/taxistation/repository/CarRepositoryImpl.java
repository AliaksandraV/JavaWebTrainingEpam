package by.training.taxistation.repository;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.repository.factory.CarFactory;
import by.training.taxistation.service.specification.CarSpecification;

import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    //TODO этот чувак общиется с хранилищем таксистэйшен
    private final TaxiStation taxiStation = TaxiStation.getTaxiStationInstance();

    @Override
    public void create(Car car) {

    }

    @Override
    public List<Car> read() {
        return taxiStation.getCars();
    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public List<Car> query(CarSpecification specification) {
        return specification.query(read());
    }

}
