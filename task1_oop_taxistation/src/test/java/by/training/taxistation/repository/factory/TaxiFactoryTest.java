package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TaxiFactoryTest {
    private TaxiFactory factory = new TaxiFactory();

    @Test
    public void testCreate() {
        String[] carParameters = {"taxi", "MAN", "TGM", "10000", "1", "1525 MP-7",
                "460000", "36000", "false", "false", "false"};

        Taxi expected = new Taxi.Builder()
                .setBrand(CarBrand.MAN)
                .setModel("TGM")
                .setCargoCapacity(10000)
                .setPassengerCapacity(1)
                .setPlateNumber("1525 MP-7")
                .setMileage(460000)
                .setCost(36000)
                .setAccessibleForChildren(false)
                .setAccessibleForDisabled(false)
                .setIsMinivan(false)
                .build();

        Taxi actual = factory.create(carParameters);
        assertEquals(actual, expected);
    }
}