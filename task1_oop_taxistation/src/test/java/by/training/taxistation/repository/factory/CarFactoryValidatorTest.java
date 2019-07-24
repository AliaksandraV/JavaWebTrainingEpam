package by.training.taxistation.repository.factory;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CarFactoryValidatorTest {

    @Test
    public void testValidateCarParametersFromFile() throws InvalidCarDataException {
        String[] carParameters = {"cargotaxi", "MAN", "TGM", "10000", "1", "1525 MP-7",
                "460000", "36000", "7.3", "2.5", "2.9", "53"};

        boolean expected = true;

        boolean actual = CarFactoryValidator.validateCarParametersFromFile(carParameters);
        assertEquals(actual, expected);
    }
}