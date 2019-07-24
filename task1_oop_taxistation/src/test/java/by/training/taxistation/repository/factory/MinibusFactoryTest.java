package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import by.training.taxistation.entity.car.Minibus;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinibusFactoryTest {
    private MinibusFactory factory = new MinibusFactory();

    @Test
    public void testCreate() {
        String[] carParameters = {"minibus", "MAN", "TGM", "10000", "1", "1525 MP-7",
                "460000", "36000", "false", "false", "false"};

        Minibus expected = new Minibus(CarBrand.MAN,
                "TGM",
                10000,
                1,
                "1525 MP-7",
                460000,
                36000,
                false,
                false,
                false
        );

        Minibus actual = factory.create(carParameters);
        assertEquals(actual, expected);
    }
}