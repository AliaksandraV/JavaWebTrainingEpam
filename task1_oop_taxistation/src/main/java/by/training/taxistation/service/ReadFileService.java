package by.training.taxistation.service;

import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadFileService {

    private String filePath;
    private static final Logger log = Logger.getLogger(ReadFileService.class);
    private final String delimiter = "|";

    public ReadFileService() {
        filePath = PropertiesService.getProperty("storage.file.path");
    }

    public ReadFileService(String newFilePath) {
        filePath = newFilePath;
    }

//    public List<String> loadValidLinesFromFile() {
//        List<String> linesFromFile = readLinesFromFile();
//        return CarFactoryValidator.validateCarParametersFromFile(linesFromFile);
//    }

    public List<String> readLinesFromFile() {
        List<String> linesFromFile = new ArrayList<>();
        if (isFileEmpty()) {
            log.info("Файл пустой. Нет данных.");
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

    //TODO КОД НИЖЕ НАДО ПЕРЕНЕСТИ
    //TODO ПОДУМАТЬ КАК РЕАЛИЗОВАТЬ ЗАПИТЬ В ФАЙЛ, МОЖЕТ ЧЕРЕЗ ФАБРИКУ ТОЖЕ?

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
}
