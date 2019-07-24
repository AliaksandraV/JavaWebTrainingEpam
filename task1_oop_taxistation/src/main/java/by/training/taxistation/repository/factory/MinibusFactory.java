package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.Minibus;

class MinibusFactory implements CarFactory {
    /**
     * .
     */
    @Override
    public Minibus create(final String[] carParameters) {
        return new Minibus.Builder()
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
                .setIsIntercityTransportation(Boolean.valueOf(
                        carParameters[
                                CarConstants.INTERCITY_TRANSPORTATION_INDEX]))
                .build();
    }
}
