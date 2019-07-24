package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;

import java.util.Arrays;
import java.util.List;

public final class CarFactoryValidator {

    /**
     * expected Number Of Parameters For CargoTaxi.
     */
    private static final int EXPECTED_NUMBER_OF_PARAMETERS_FOR_CARGO_TAXI = 12;
    /**
     * expected Number Of Parameters For Passanger Taxi.
     */
    private static final int EXPECTED_NUMBER_OF_PARAMETERS_FOR_PASSANGER_TAXI = 11;
    /**
     * list of existing taxi types.
     */
    private static final List<String> TAXI_TYPES = Arrays.asList("taxi", "minibus", "cargotaxi");

    private CarFactoryValidator() {

    }

    /**
     *
     * @param carParameters
     * @return
     * @throws InvalidCarDataException
     */
    public static boolean validateCarParametersFromFile(String[] carParameters) throws InvalidCarDataException {
        if (validateTaxiType(carParameters[0])
                && validateNumberOfParameters(carParameters.length, carParameters[0])
                && validateCarBrand(carParameters[1])
                && validateCapacity(carParameters[3])
                && validateCapacity(carParameters[4])
                && validateMileage(carParameters[6])
                && validateCost(carParameters[7])
                && validateIndividualCharacteristics(carParameters)) {
            return true;
        }
        return false;
    }


    private static boolean validateNumberOfParameters(int actualNumberOfParameters, String carType) throws InvalidCarDataException {//, int lineNumber) {
        if (carType.equals(TAXI_TYPES.get(0)) || carType.equals(TAXI_TYPES.get(1))) {
            if (actualNumberOfParameters == EXPECTED_NUMBER_OF_PARAMETERS_FOR_PASSANGER_TAXI) {
                return true;
            } else {
                throw new InvalidCarDataException("неверное число параметров.");
            }
        } else if (carType.equals(TAXI_TYPES.get(2))) {
            if (actualNumberOfParameters == EXPECTED_NUMBER_OF_PARAMETERS_FOR_CARGO_TAXI) {
                return true;
            } else {
                throw new InvalidCarDataException("неверное число параметров.");
            }
        } else {
            throw new InvalidCarDataException("указан несуществующий тип такси.");
        }
    }

    private static boolean validateTaxiType(String taxiType) throws InvalidCarDataException {//, int lineNumber) {
        if (TAXI_TYPES.contains(taxiType)) {
            return true;
        } else {
            throw new InvalidCarDataException("указан несуществующий тип такси.");

        }
    }

    private static boolean validateCarBrand(String carBrand) throws InvalidCarDataException {
        if (CarBrand.getByTitle(carBrand).isPresent()) {
            return true;
        } else {
            throw new InvalidCarDataException("указан невалидный брэнд.");
        }
    }

    private static boolean validateCost(String cost) throws InvalidCarDataException {
        if (isInteger(cost)) {
            return true;
        } else {
            throw new InvalidCarDataException("указана невалидная цена.");
        }
    }

    private static boolean validateMileage(String mileage) throws InvalidCarDataException {
        if (isInteger(mileage)) {
            return true;
        } else {
            throw new InvalidCarDataException("указан невалидный пробег.");
        }
    }

    private static boolean validateCapacity(String capacity) throws InvalidCarDataException {
        if (isInteger(capacity)) {
            return true;
        } else {
            throw new InvalidCarDataException("указана невалидная вместимость.");
        }
    }

    private static boolean validateIndividualCharacteristics(String[] carParameters) throws InvalidCarDataException {
        if (carParameters[0].equals(TAXI_TYPES.get(2))) {
            if (isDouble(carParameters[8])
                    && isDouble(carParameters[9])
                    && isDouble(carParameters[10])
                    && isDouble(carParameters[11])) {
                return true;
            } else {
                throw new InvalidCarDataException("указан невалидный размер грузовой платформы.");
            }
        } else {
            if (isBoolean(carParameters[8])
                    && isBoolean(carParameters[9])
                    && isBoolean(carParameters[10])) {
                return true;
            } else {
                throw new InvalidCarDataException("указаны невалидные параметры возможностей перевозки.");
            }

        }

    }

    private static boolean isInteger(String carParameter) {
        try {
            Integer.valueOf(carParameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String carParameter) {
        try {
            Double.valueOf(carParameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBoolean(String carParameter) {
        return "true".equals(carParameter.toLowerCase()) || "false".equals(carParameter.toLowerCase());
    }
}
