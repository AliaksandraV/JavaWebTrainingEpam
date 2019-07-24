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

    TaxiStation station = TaxiStation.getTaxiStationInstance();
    CarRepository repository = new CarRepositoryImpl();

    @BeforeTest
    public void before(){
        Car car = new CargoTaxi(CarBrand.MAN,
                "TGM",
                10000,
                1,
                "1525 MP-7",
                460000,
                36000,
                7.3,
                2.5,
                2.9,
                53
        );
        station.getCars().add(car);
    }

    @Test
    public void testCreate() {
    }

    @Test
    public void testRead() {
        Car car = new CargoTaxi(CarBrand.MAN,
                "TGM",
                10000,
                1,
                "1525 MP-7",
                460000,
                36000,
                7.3,
                2.5,
                2.9,
                53
        );
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