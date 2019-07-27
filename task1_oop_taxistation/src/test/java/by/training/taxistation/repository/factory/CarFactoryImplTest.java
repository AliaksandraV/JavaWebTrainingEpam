package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.CargoTaxi;
import by.training.taxistation.entity.car.Minibus;
import by.training.taxistation.entity.car.Taxi;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CarFactoryImplTest {

    private CarFactoryImpl factory = new CarFactoryImpl();

    @Test
    public void testCreateCargoTaxi() throws InvalidCarDataException {
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

        CargoTaxi actual = (CargoTaxi) factory.create(carParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateTaxi() throws InvalidCarDataException {
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

        Taxi actual = (Taxi) factory.create(carParameters);
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateMinibus() throws InvalidCarDataException {
        String[] carParameters = {"minibus", "MAN", "TGM", "10000", "1", "1525 MP-7",
                "460000", "36000", "false", "false", "false"};

        Minibus expected = new Minibus.Builder()
                .setBrand(CarBrand.MAN)
                .setModel("TGM")
                .setCargoCapacity(10000)
                .setPassengerCapacity(1)
                .setPlateNumber("1525 MP-7")
                .setMileage(460000)
                .setCost(36000)
                .setAccessibleForChildren(false)
                .setAccessibleForDisabled(false)
                .setIsIntercityTransportation(false)
                .build();

        Minibus actual = (Minibus) factory.create(carParameters);
        assertEquals(actual, expected);
    }
}