package by.training.taxistation;

import by.training.taxistation.repository.factory.TaxiStationFactory;
import by.training.taxistation.repository.factory.TaxiStationFactoryImpl;
import by.training.taxistation.сontroller.MainMenuController;

public final class Main {

    private Main() {
    }

    /**
     * Start point of the program.
     *
     * @param args command line values
     */
    public static void main(final String[] args) {
        TaxiStationFactory factory = new TaxiStationFactoryImpl();
        factory.fill();
        MainMenuController menuController = new MainMenuController();
        menuController.run();
//        ReadFileService readFileService = new ReadFileService();
//        List<String> lines = readFileService.loadValidLinesFromFile();
//        CarRepositoryImpl carRepository = new CarRepositoryImpl(lines);
//        List<Car> cars = carRepository.read();

//        for (Car car : cars) {
//            System.out.println(car.getClass());
//            System.out.println(car);
//        }

//        SortByCarBrandImpl sortByCarBrand = new SortByCarBrandImpl();
//        SortByCarBrandAndCostImpl sort = new SortByCarBrandAndCostImpl();

//        SearchByPassengerCapacityCarSpecificationImpl search = new SearchByPassengerCapacityCarSpecificationImpl(1, 4);
//        SearchByLoadCapacityCarSpecificationImpl search1 = new SearchByLoadCapacityCarSpecificationImpl(100, 500);
//
//        List<Car> cars1 = search1.find(cars);
//        for (Car car : cars1) {
//            System.out.println(car);
//        }
    }
}
