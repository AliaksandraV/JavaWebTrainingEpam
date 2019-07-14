package by.training.taxistation;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.repository.CarRepositoryImpl;
import by.training.taxistation.service.ReadFileService;

import java.util.List;

public final class Main {

    private Main() {
    }

    /**
     * Start point of the program.
     *
     * @param args command line values
     */
    public static void main(final String[] args) {
        ReadFileService readFileService = new ReadFileService();
        List<String> lines = readFileService.loadValidLinesFromFile();
        CarRepositoryImpl carRepository = new CarRepositoryImpl(lines);
        List<Car> cars = carRepository.read();

        for (Car car : cars) {
            System.out.println(car.getClass());
            System.out.println(car);
        }
    }
}
