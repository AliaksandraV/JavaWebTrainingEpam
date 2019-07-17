package by.training.taxistation;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.repository.CarRepositoryImpl;
import by.training.taxistation.service.ReadFileService;
import by.training.taxistation.service.specification.sort.SortByCarBrandAndCostImpl;
import by.training.taxistation.service.specification.sort.SortByCarBrandImpl;

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

//        for (Car car : cars) {
//            System.out.println(car.getClass());
//            System.out.println(car);
//        }

//        SortByCarBrandImpl sortByCarBrand = new SortByCarBrandImpl();
        SortByCarBrandAndCostImpl sort = new SortByCarBrandAndCostImpl();

        List<Car> cars1 = sort.sort(cars);
        for (Car car : cars1) {
            System.out.println(car);
        }
    }
}
