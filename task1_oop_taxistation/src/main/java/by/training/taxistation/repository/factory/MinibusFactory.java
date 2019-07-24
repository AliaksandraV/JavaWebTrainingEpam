package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.Minibus;

class MinibusFactory implements CarFactory {

    @Override
    public Minibus create(String[] carParameters) {
        return new Minibus.Builder()
                .setBrand(CarBrand.valueOf(carParameters[1]))
                .setModel(carParameters[2])
                .setCargoCapacity(Integer.valueOf(carParameters[3]))
                .setPassengerCapacity(Integer.valueOf(carParameters[4]))
                .setPlateNumber(carParameters[5])
                .setMileage(Integer.valueOf(carParameters[6]))
                .setCost(Integer.valueOf(carParameters[7]))
                .setAccessibleForChildren(Boolean.valueOf(carParameters[8]))
                .setAccessibleForDisabled(Boolean.valueOf(carParameters[9]))
                .setIsIntercityTransportation(Boolean.valueOf(carParameters[10]))
                .build();
    }
}
