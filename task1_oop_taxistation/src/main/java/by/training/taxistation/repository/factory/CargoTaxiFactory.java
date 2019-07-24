package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;

class CargoTaxiFactory implements CarFactory {

    @Override
    public CargoTaxi create(String[] carParameters) {
        return new CargoTaxi.Builder()
                .setBrand(CarBrand.valueOf(carParameters[1]))
                .setModel(carParameters[2])
                .setCargoCapacity(Integer.valueOf(carParameters[3]))
                .setPassengerCapacity(Integer.valueOf(carParameters[4]))
                .setPlateNumber(carParameters[5])
                .setMileage(Integer.valueOf(carParameters[6]))
                .setCost(Integer.valueOf(carParameters[7]))
                .setLength(Double.valueOf(carParameters[8]))
                .setWidth(Double.valueOf(carParameters[9]))
                .setHeight(Double.valueOf(carParameters[10]))
                .setVolume(Double.valueOf(carParameters[11]))
                .build();
    }
}
