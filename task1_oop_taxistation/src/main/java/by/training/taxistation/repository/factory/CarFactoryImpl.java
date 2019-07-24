package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.Car;
import org.apache.log4j.Logger;

public class CarFactoryImpl implements CarFactory {
    /**
     * logger declaration.
     */
    private static final Logger LOGGER = Logger.getLogger(CarFactoryImpl.class);

    /**
     * create car instance.
     * @param carParameters car Parameters
     * @return car instance
     * @throws InvalidCarDataException if car Parameters invalid
     */
    @Override
    public Car create(final String[] carParameters)
            throws InvalidCarDataException {
        Car car;
        CarFactoryValidator.validateCarParameters(carParameters);
        switch (carParameters[0]) {
            case "taxi":
                car = new TaxiFactory().create(carParameters);
                break;
            case "minibus":
                car = new MinibusFactory().create(carParameters);
                break;
            case "cargotaxi":
                car = new CargoTaxiFactory().create(carParameters);
                break;
            default:
                LOGGER.error("Несуществующий тип такси.");
                return null;
        }
        return car;
    }
}
