package by.training.taxistation.entity.station;

import by.training.taxistation.entity.car.Car;

import java.util.ArrayList;
import java.util.List;

public final class TaxiStation {
    /**
     * list of cars on taxistation.
     */
    private List<Car> cars;
    /**
     * Taxi station is singleton.
     */
    private static TaxiStation instance;

    /**
     * constructor.
     */
    private TaxiStation() {
        cars = new ArrayList<>();
    }

    /**
     * get Taxi Station Instance.
     * @return list of cars
     */
    public static TaxiStation getInstance() {
        if (instance == null) {
            return instance = new TaxiStation();
        }
        return instance;
    }

    /**
     * get Cars.
     * @return list of cars
     */
    public List<Car> getCars() {
        return cars;
    }
}
