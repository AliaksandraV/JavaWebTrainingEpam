package by.training.taxistation.entity.taxi.passengertaxi;

import by.training.taxistation.entity.taxi.CarBrand;

public class Minibus extends PassengerTaxi {

    /**
     * Minibus constructor.
     * @param brand brand
     * @param model model
     * @param cost cost
     * @param mileage mileage
     * @param passengerCapacity passenger capacity
     */
    public Minibus(final CarBrand brand,
                   final String model,
                   final int cost,
                   final int mileage,
                   final int passengerCapacity) {
        super(brand, model, cost, mileage, passengerCapacity);
    }
}
