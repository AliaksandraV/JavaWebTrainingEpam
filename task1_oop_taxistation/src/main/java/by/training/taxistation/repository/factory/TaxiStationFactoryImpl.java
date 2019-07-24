package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.service.ReadFileService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TaxiStationFactoryImpl implements TaxiStationFactory {
    /**
     * .
     */
    private static final Logger LOGGER
            = Logger.getLogger(TaxiStationFactoryImpl.class);

    /**
     * .
     */
    @Override
    public void fill() {
        TaxiStation taxiStation = TaxiStation.getTaxiStationInstance();
        taxiStation.getCars().addAll(createListOfCars());
    }

    /**
     * .
     * @return .
     */
    private List<Car> createListOfCars() {
        List<Car> cars = new ArrayList<>();
        CarFactory carFactory = new CarFactoryImpl();
        ReadFileService readFileService = new ReadFileService();
        List<String> lines = readFileService.readLinesFromFile();
        for (int i = 0; i < lines.size(); i++) {
            String[] carParameters = lines.get(i).split("\\|");
            try {
                cars.add(carFactory.create(carParameters));
            } catch (InvalidCarDataException e) {
                LOGGER.error(
                        "У файла в строке " + (i + 1) + " " + e.getMessage());
            }
        }
        return cars;
    }
}
