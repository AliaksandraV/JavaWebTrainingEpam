package by.training.taxistation;

import by.training.taxistation.dao.ITaxiStationDao;
import by.training.taxistation.dao.TaxiStationDao;
import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.SearchService;
import by.training.taxistation.service.SortService;

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
        System.out.println("Hello world!");
        TaxiStation taxiStation = loadStation();

        print(taxiStation.getAll());

        SearchService searchService = new SearchService();
        SortService sortService = new SortService();

        List<Car> cars;
        cars = sortService.sortByCarBrandAndCost(taxiStation);
        print(cars);

        cars = searchService.findByPassengerCapacity(taxiStation, 10, 12);
        print(cars);


    }

    private static void print(List<Car> tscars) {
        for (Car cars : tscars) {
            System.out.println(cars.toString());
        }
        System.out.println();
    }

    private static TaxiStation loadStation() {
        ITaxiStationDao taxiStationDao = new TaxiStationDao();
        return taxiStationDao.loadTaxiStation();
    }
}
