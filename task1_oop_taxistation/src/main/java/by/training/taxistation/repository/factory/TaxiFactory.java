package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.Taxi;

public class TaxiFactory implements CarFactory {

    @Override
    public Taxi create(String[] arr) {
        return new Taxi.Builder()
                .setBrand(CarBrand.valueOf(arr[1]))
                .setModel(arr[2])
                .setCargoCapacity(Integer.valueOf(arr[3]))
                .setPassengerCapacity(Integer.valueOf(arr[4]))
                .setPlateNumber(arr[5])
                .setMileage(Integer.valueOf(arr[6]))
                .setCost(Integer.valueOf(arr[7]))
                .setAccessibleForChildren(Boolean.valueOf(arr[8]))
                .setAccessibleForDisabled(Boolean.valueOf(arr[9]))
                .setIsMinivan(Boolean.valueOf(arr[10]))
                .build();
    }
}
