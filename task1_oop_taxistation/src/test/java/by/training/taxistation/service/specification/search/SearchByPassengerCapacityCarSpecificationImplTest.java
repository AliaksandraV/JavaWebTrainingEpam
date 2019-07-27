package by.training.taxistation.service.specification.search;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SearchByPassengerCapacityCarSpecificationImplTest {

    private int from = 2;
    private int to = 4;
    SearchByPassengerCapacityCarSpecificationImpl search;

    @BeforeTest
    public void before() {
        search = new SearchByPassengerCapacityCarSpecificationImpl(from, to);
    }

    @Test
    public void testQuery() {
        List<Car> cars = new ArrayList<>();
        cars.add(new CargoTaxi.Builder()
                .setBrand(CarBrand.FORD)
                .setModel("Focus 2")
                .setCargoCapacity(5000)
                .setPassengerCapacity(5)
                .setPlateNumber("6000")
                .setMileage(152000)
                .setCost(5000)
                .setLength(1)
                .setHeight(1)
                .setWidth(1)
                .setVolume(1)
                .build());
        cars.add(new CargoTaxi.Builder()
                .setBrand(CarBrand.AUDI)
                .setModel("A6")
                .setCargoCapacity(1100)
                .setPassengerCapacity(4)
                .setPlateNumber("15000")
                .setMileage(131000)
                .setCost(11000)
                .setLength(1)
                .setHeight(1)
                .setWidth(1)
                .setVolume(1)
                .build());
        cars.add(new CargoTaxi.Builder()
                .setBrand(CarBrand.MERCEDES)
                .setModel("Bus")
                .setCargoCapacity(1400)
                .setPassengerCapacity(5)
                .setPlateNumber("11000")
                .setMileage(197000)
                .setCost(14000)
                .setLength(1)
                .setHeight(1)
                .setWidth(1)
                .setVolume(1)
                .build());
        cars.add(new CargoTaxi.Builder()
                .setBrand(CarBrand.VOLKSWAGEN)
                .setModel("Crafter")
                .setCargoCapacity(1200)
                .setPassengerCapacity(2)
                .setPlateNumber("9000")
                .setMileage(184000)
                .setCost(12000)
                .setLength(1)
                .setHeight(1)
                .setWidth(1)
                .setVolume(1)
                .build());

        List<Car> actual = search.query(cars);

        List<Car> expected = new ArrayList<>();
        expected.add(new CargoTaxi.Builder()
                .setBrand(CarBrand.AUDI)
                .setModel("A6")
                .setCargoCapacity(1100)
                .setPassengerCapacity(4)
                .setPlateNumber("15000")
                .setMileage(131000)
                .setCost(11000)
                .setLength(1)
                .setHeight(1)
                .setWidth(1)
                .setVolume(1)
                .build());
        expected.add(new CargoTaxi.Builder()
                .setBrand(CarBrand.VOLKSWAGEN)
                .setModel("Crafter")
                .setCargoCapacity(1200)
                .setPassengerCapacity(2)
                .setPlateNumber("9000")
                .setMileage(184000)
                .setCost(12000)
                .setLength(1)
                .setHeight(1)
                .setWidth(1)
                .setVolume(1)
                .build());

        assertEquals(actual, expected);
    }
}