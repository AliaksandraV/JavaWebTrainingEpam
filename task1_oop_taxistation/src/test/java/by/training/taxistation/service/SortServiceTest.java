package by.training.taxistation.service;

import by.training.taxistation.entity.station.TaxiStation;
import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SortServiceTest {
//
//    private TaxiStation station;
//    private SortService sort;
//
//    @BeforeTest
//    public void generateTaxiStation(){
//        sort = new SortService();
//    }
//
//    @Test
//    public void testSortByCarBrand() {
//        station = new TaxiStation();
//        station.getTaxis().add(new Taxi(CarBrand.FORD, "Focus 2", 6000,152000,5));
//        station.getTaxis().add(new Taxi(CarBrand.AUDI,"A6", 15000,131000,4));
//        station.getMinibuses().add(new Minibus(CarBrand.MERCEDES_BENZ,"Bus", 11000,197000, 14));
//        station.getMinibuses().add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,12));
//
//        List<Car> actual = sort.sortByCarBrand(station);
//
//        List<Car> expected = new ArrayList<>();
//        expected.add(new Taxi(CarBrand.AUDI,"A6", 15000,131000,4));
//        expected.add(new Taxi(CarBrand.FORD, "Focus 2", 6000,152000,5));
//        expected.add(new Minibus(CarBrand.MERCEDES_BENZ,"Bus", 11000,197000, 14));
//        expected.add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,12));
//
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testSortByCarBrandAndCost() {
//        station = new TaxiStation();
//        station.getMinibuses().add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 11000, 184000,12));
//        station.getMinibuses().add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,12));
//        station.getTaxis().add(new Taxi(CarBrand.AUDI,"A6", 18000,131000,4));
//        station.getTaxis().add(new Taxi(CarBrand.AUDI,"A6", 21000,131000,4));
//        station.getTaxis().add(new Taxi(CarBrand.AUDI,"A6", 15000,131000,4));
//
//        List<Car> actual = sort.sortByCarBrandAndCost(station);
//
//        List<Car> expected = new ArrayList<>();
//        expected.add(new Taxi(CarBrand.AUDI,"A6", 15000,131000,4));
//        expected.add(new Taxi(CarBrand.AUDI,"A6", 18000,131000,4));
//        expected.add(new Taxi(CarBrand.AUDI,"A6", 21000,131000,4));
//        expected.add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 9000, 184000,12));
//        expected.add(new Minibus(CarBrand.VOLKSWAGEN,"Crafter", 11000, 184000,12));
//        assertEquals(actual, expected);
//    }
}