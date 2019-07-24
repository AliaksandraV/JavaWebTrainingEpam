package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.Car;
import org.apache.log4j.Logger;

public class CarFactoryImpl implements CarFactory {
    private static final Logger log = Logger.getLogger(CarFactoryImpl.class);

    @Override
    public Car create(String[] carParameters) throws InvalidCarDataException {
        Car car;
        CarFactoryValidator.validateCarParametersFromFile(carParameters);
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
                log.error("Несуществующий тип такси.");
                return null;
        }
        return car;
    }
}
