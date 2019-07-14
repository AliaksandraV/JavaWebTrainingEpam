package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;

//TODO Сомневаюсь что тут надо имплиментить интерфейс
public class CargoTaxiFactory implements CarFactory {

    @Override
    public CargoTaxi create(String[] arr) {
        return new CargoTaxi.Builder()
                .setBrand(CarBrand.valueOf(arr[1]))
                .setModel(arr[2])
                .setCargoCapacity(Integer.valueOf(arr[3]))
                .setPassengerCapacity(Integer.valueOf(arr[4]))
                .setPlateNumber(arr[5])
                .setMileage(Integer.valueOf(arr[6]))
                .setCost(Integer.valueOf(arr[7]))
                .setLength(Double.valueOf(arr[8]))
                .setWidth(Double.valueOf(arr[9]))
                .setHeight(Double.valueOf(arr[10]))
                .setVolume(Double.valueOf(arr[11]))
                .build();
    }
}
