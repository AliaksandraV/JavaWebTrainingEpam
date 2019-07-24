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
    private static TaxiStation taxiStationInstance;

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
    public static TaxiStation getTaxiStationInstance() {
        if (taxiStationInstance == null) {
            return taxiStationInstance = new TaxiStation();
        }
        return taxiStationInstance;
    }

    /**
     * get Cars.
     * @return list of cars
     */
    public List<Car> getCars() {
        return cars;
    }
}
