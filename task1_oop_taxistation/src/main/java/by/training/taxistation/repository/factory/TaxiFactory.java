package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.Taxi;

class TaxiFactory implements CarFactory {
    /**
     * create taxi instance.
     * @param carParameters car Parameters
     * @return taxi instance.
     */
    @Override
    public Taxi create(final String[] carParameters) {
        return new Taxi.Builder()
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
                .setAccessibleForChildren(Boolean.valueOf(
                        carParameters[
                                CarConstants.ACCESSIBLE_FOR_CHILDREN_INDEX]))
                .setAccessibleForDisabled(Boolean.valueOf(
                        carParameters[
                                CarConstants.ACCESSIBLE_FOR_DISABLED_INDEX]))
                .setIsMinivan(Boolean.valueOf(
                        carParameters[CarConstants.IS_MINIVAN_INDEX]))
                .build();
    }
}
