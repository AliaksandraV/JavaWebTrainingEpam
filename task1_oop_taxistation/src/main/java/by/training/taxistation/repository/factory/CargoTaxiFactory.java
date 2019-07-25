package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;

class CargoTaxiFactory implements CarFactory {

    /**
     * create cargo taxi instance.
     * @param carParameters car Parameters
     * @return cargo taxi instance
     * @throws InvalidCarDataException if car Parameters invalid
     */
    @Override
    public CargoTaxi create(final String[] carParameters) {
        return new CargoTaxi.Builder()
                .setBrand(CarBrand.valueOf(carParameters[1]))
                .setModel(carParameters[2])
                .setCargoCapacity(Integer.valueOf(
                        carParameters[CarConstants.CARGO_CAPACITY_INDEX]))
                .setPassengerCapacity(Integer.valueOf(
                        carParameters[CarConstants.PAS_CAPACITY_INDEX]))
                .setPlateNumber(carParameters[CarConstants.PLATE_NUMBER_INDEX])
                .setMileage(Integer.valueOf(
                        carParameters[CarConstants.MILEAGE_INDEX]))
                .setCost(Integer.valueOf(
                        carParameters[CarConstants.COST_INDEX]))
                .setLength(Double.valueOf(
                        carParameters[CarConstants.LENGTH_INDEX]))
                .setWidth(Double.valueOf(
                        carParameters[CarConstants.WIDTH_INDEX]))
                .setHeight(Double.valueOf(
                        carParameters[CarConstants.HEIGHT_INDEX]))
                .setVolume(Double.valueOf(
                        carParameters[CarConstants.VOLUME_INDEX]))
                .build();
    }
}
