package by.training.taxistation.repository;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.station.TaxiStation;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CarRepositoryImplTest {

    TaxiStation station = TaxiStation.getInstance();
    CarRepository repository = new CarRepositoryImpl();

    @BeforeTest
    public void before(){
        Car car = new CargoTaxi.Builder()
                .setBrand(CarBrand.MAN)
                .setModel("TGM")
                .setCargoCapacity(10000)
                .setPassengerCapacity(1)
                .setPlateNumber("1525 MP-7")
                .setMileage(460000)
                .setCost(36000)
                .setLength(7.3)
                .setHeight(2.5)
                .setWidth(2.9)
                .setVolume(53)
                .build();

        station.getCars().add(car);
    }

    @Test
    public void testCreate() {
    }

    @Test
    public void testRead() {
        Car car = new CargoTaxi.Builder()
                .setBrand(CarBrand.MAN)
                .setModel("TGM")
                .setCargoCapacity(10000)
                .setPassengerCapacity(1)
                .setPlateNumber("1525 MP-7")
                .setMileage(460000)
                .setCost(36000)
                .setLength(7.3)
                .setHeight(2.5)
                .setWidth(2.9)
                .setVolume(53)
                .build();
        List <Car> expected = new ArrayList<>();
        expected.add(car);

        List<Car> actual = repository.read();

        assertEquals(actual, expected);
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testQuery() {
    }
}