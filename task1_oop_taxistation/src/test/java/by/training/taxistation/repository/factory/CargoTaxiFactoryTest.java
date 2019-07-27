package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CargoTaxiFactoryTest {
    private CargoTaxiFactory factory = new CargoTaxiFactory();

    @Test
    public void testCreate() {
        String[] carParameters = {"cargotaxi", "MAN", "TGM", "10000", "1", "1525 MP-7",
                "460000", "36000", "7.3", "2.5", "2.9", "53"};

        CargoTaxi expected = new CargoTaxi.Builder()
                .setBrand(CarBrand.MAN)
                .setModel("TGM")
                .setCargoCapacity(10000)
                .setPassengerCapacity(1)
                .setPlateNumber("1525 MP-7")
                .setMileage(460000)
                .setCost(36000)
                .setLength(7.3)
                .setWidth(2.5)
                .setHeight(2.9)
                .setVolume(53)
                .build();

        CargoTaxi actual = factory.create(carParameters);
        assertEquals(actual, expected);
    }
}