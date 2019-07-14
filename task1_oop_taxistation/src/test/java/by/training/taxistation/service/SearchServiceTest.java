package by.training.taxistation.service;

import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SearchServiceTest {

    private TaxiStation station;
    private SearchService search;

    @BeforeTest
    public void generateTaxiStation(){
        search = new SearchService();
    }

    @Test
    public void testFindByLoadCapacity() {
//        station = new TaxiStation();
//        station.getCargoTaxis().add(new CargoTaxi(CarBrand.FORD, "Focus 2", 6000,152000,5000));
//        station.getCargoTaxis().add(new CargoTaxi(CarBrand.AUDI,"A6", 15000,131000,1100));
//        station.getCargoTaxis().add(new CargoTaxi(CarBrand.MERCEDES_BENZ,"Bus", 11000,197000, 1400));
//        station.getCargoTaxis().add(new CargoTaxi(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,1200));
//
//        List<Car> actual = search.findByLoadCapacity(station, 1000, 1399);
//
//        List<Car> expected = new ArrayList<>();
//        expected.add(new CargoTaxi(CarBrand.AUDI,"A6", 15000,131000,1100));
//        expected.add(new CargoTaxi(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,1200));
//
//        assertEquals(actual, expected);
    }

    @Test
    public void testFindByPassengerCapacity() {
//        station = new TaxiStation();
//        station.getTaxis().add(new Taxi(CarBrand.FORD, "Focus 2", 6000,152000,5));
//        station.getTaxis().add(new Taxi(CarBrand.AUDI,"A6", 15000,131000,4));
//        station.getMinibuses().add(new Minibus(CarBrand.MERCEDES_BENZ,"Bus", 11000,197000, 14));
//        station.getMinibuses().add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,12));
//
//        List<Car> actual = search.findByPassengerCapacity(station, 5, 12);
//
//        List<Car> expected = new ArrayList<>();
//        expected.add(new Taxi(CarBrand.FORD, "Focus 2", 6000,152000,5));
//        expected.add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,12));
//
//        assertEquals(actual, expected);
    }
}