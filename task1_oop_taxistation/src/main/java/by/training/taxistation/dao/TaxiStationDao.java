package by.training.taxistation.dao;

import by.training.taxistation.dao.factory.CarFactory;
import by.training.taxistation.dao.factory.ICarFactory;
import by.training.taxistation.dao.validation.ReadFromFileValidator;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;
import by.training.taxistation.util.PropertiesUtil;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaxiStationDao implements ITaxiStationDao {

    private String filePath;
    private static final Logger log = Logger.getLogger(TaxiStationDao.class);
    private final String delimiter = "|";
    private ICarFactory carFactory = new CarFactory();

    public TaxiStationDao() {
        filePath = PropertiesUtil.getProperty("storage.file.path");
    }

    public TaxiStationDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public TaxiStation loadTaxiStation() {
        List<String> linesFromFile = readLinesFromFile();
        List<String> validParameters = ReadFromFileValidator.validateCarParametersFromFile(linesFromFile);
        TaxiStation taxiStation = createTaxiStation(validParameters);
        log.info("Создан объект станции. ");
        return taxiStation;
    }

    private List<String> readLinesFromFile() {
        List<String> linesFromFile = new ArrayList<>();
        if (isFileEmpty()) {
            log.info("Файл пустой. Таксопарк пуст.");
            return linesFromFile;
        }

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(linesFromFile::add);
        } catch (IOException exception) {
            log.error("Возникла ошибка при чтении из файла.", exception);
            exception.printStackTrace();
        }
        return linesFromFile;
    }

    private boolean isFileEmpty() {
        File file = new File(filePath);
        return file.length() == 0;
    }

    private TaxiStation createTaxiStation(List<String> carDescriptions) {
        TaxiStation taxiStation = new TaxiStation();

        for (int i = 0; i < carDescriptions.size(); i++) {
            String description = carDescriptions.get(i);
            String[] carParameters = description.split("\\" + delimiter);
            switch (carParameters[0]) {
                case "taxi":
                    Taxi taxi = carFactory.createTaxi(carParameters);
                    taxiStation.getTaxis().add(taxi);
                    break;
                case "minibus":
                    Minibus minibus = carFactory.createMinibus(carParameters);
                    taxiStation.getMinibuses().add(minibus);
                    break;
                case "cargotaxi":
                    CargoTaxi cargoTaxi = carFactory.createCargoTaxi(carParameters);
                    taxiStation.getCargoTaxis().add(cargoTaxi);
                    break;
                default:
                    log.error("В строке " + (i + 1) + " указан несуществующий тип такси.");
            }
        }

        return taxiStation;
    }

    @Override
    public void addTaxi(Taxi car) {
        Object[] carParameters = new Object[]{
                "taxi",
                car.getBrand(),
                car.getModel(),
                car.getCost(),
                car.getMileage(),
                car.getPassengerCapacity()};

        String valueForStorage = convertToStorageFormat(carParameters);
        writeCarToFile(valueForStorage);
    }

    @Override
    public void addMinibus(Minibus car) {
        Object[] carParameters = new Object[]{
                "minibus",
                car.getBrand(),
                car.getModel(),
                car.getCost(),
                car.getMileage(),
                car.getPassengerCapacity()};

        String valueForStorage = convertToStorageFormat(carParameters);
        writeCarToFile(valueForStorage);
    }

    @Override
    public void addCargoTaxi(CargoTaxi car) {
        Object[] carParameters = new Object[]{
                "cargotaxi",
                car.getBrand(),
                car.getModel(),
                car.getCost(),
                car.getMileage(),
                car.getCargoCapacity()};

        String valueForStorage = convertToStorageFormat(carParameters);
        writeCarToFile(valueForStorage);
    }

    private String convertToStorageFormat(Object[] objects) {
        StringBuilder forStorage = new StringBuilder();
        int lastElementIndex = objects.length - 1;

        for (int i = 0; i <= lastElementIndex; i++) {
            forStorage.append(objects[i]);
            if (i != lastElementIndex) {
                forStorage.append(delimiter);
            }
        }

        return forStorage.toString();
    }

    private void writeCarToFile(String carProperties) {

        if (!isFileEmpty() && !isEndingWithNewLine()) {
            carProperties = "\n" + carProperties;
        }

        try (Writer writerToFile = new BufferedWriter(new FileWriter(filePath, true))) {
            writerToFile.write(carProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isEndingWithNewLine() {
        try {
            FileReader r = new FileReader(filePath);

            char[] buf = new char[1024];
            char last = 0;

            for (int n; (n = r.read(buf)) > 0; ) {
                last = buf[n - 1];
            }

            return last == '\n';
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
