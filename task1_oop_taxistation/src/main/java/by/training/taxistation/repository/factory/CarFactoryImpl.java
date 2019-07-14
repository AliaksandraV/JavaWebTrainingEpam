package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.Car;
import org.apache.log4j.Logger;

public class CarFactoryImpl implements CarFactory {
    private static final Logger log = Logger.getLogger(CarFactoryImpl.class);


    @Override
    public Car create(String[] arr) {
        Car car;
        switch (arr[0]) {
            case "taxi":
                car = new TaxiFactory().create(arr);
                break;
            case "minibus":
                car = new MinibusFactory().create(arr);
                break;
            case "cargotaxi":
                car = new CargoTaxiFactory().create(arr);
                break;
            default:
                log.error("Передан несуществующий тип такси.");
                return null;
        }
        return car;
    }
}
