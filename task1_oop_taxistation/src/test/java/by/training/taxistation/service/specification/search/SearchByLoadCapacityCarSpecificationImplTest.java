package by.training.taxistation.service.specification.search;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchByLoadCapacityCarSpecificationImplTest {

    private int from = 1000;
    private int to = 1399;
    SearchByLoadCapacityCarSpecificationImpl search;

    @BeforeTest
    public void before() {
        search = new SearchByLoadCapacityCarSpecificationImpl(from, to);
    }

    @Test
    public void testQuery() {
        List<Car> cars = new ArrayList<>();
        cars.add(new CargoTaxi(CarBrand.FORD, "Focus 2", 5000, 4, "6000", 152000, 5000, 1, 1, 1, 1));
        cars.add(new CargoTaxi(CarBrand.AUDI, "A6", 1100, 4, "15000", 131000, 11000, 1, 1, 1, 1));
        cars.add(new CargoTaxi(CarBrand.MERCEDES, "Bus", 1400, 4, "11000", 197000, 14000, 1, 1, 1, 1));
        cars.add(new CargoTaxi(CarBrand.VOLKSWAGEN, "Crafter", 1200, 4, "9000", 184000, 12000, 1, 1, 1, 1));

        List<Car> actual = search.query(cars);

        List<Car> expected = new ArrayList<>();
        expected.add(new CargoTaxi(CarBrand.AUDI, "A6", 1100, 4, "15000", 131000, 11000, 1, 1, 1, 1));
        expected.add(new CargoTaxi(CarBrand.VOLKSWAGEN, "Crafter", 1200, 4, "9000", 184000, 12000, 1, 1, 1, 1));

        assertEquals(actual, expected);
    }

}