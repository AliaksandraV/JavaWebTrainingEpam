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
    private static final int
            EXPECTED_NUMBER_OF_PARAMETERS_FOR_PASSANGER_TAXI = 11;
    /**
     * list of existing taxi types.
     */
    private static final List<String> TAXI_TYPES =
            Arrays.asList("taxi", "minibus", "cargotaxi");

    private CarFactoryValidator() {

    }

    /**
     * validate Car Parameters From File.
     *
     * @param carParameters car Parameters
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    public static boolean validateCarParameters(final String[] carParameters)
            throws InvalidCarDataException {

        return (validateTaxiType(carParameters[0])
                && validateNumberOfParameters(carParameters
                .length, carParameters[0])
                && validateCarBrand(carParameters[1])
                && validateCapacity(carParameters[CarConstants.CAR_BRAND_INDEX])
                && validateCapacity(
                carParameters[CarConstants.PAS_CAPACITY_INDEX])
                && validateMileage(carParameters[CarConstants.MILEAGE_INDEX])
                && validateCost(carParameters[CarConstants.COST_INDEX])
                && validateIndividualCharacteristics(carParameters));
    }

    /**
     * validate Number Of Parameters and car type.
     *
     * @param actualNumberOfParameters actual Number Of Parameters
     * @param carType                  car type
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    private static boolean validateNumberOfParameters(
            final int actualNumberOfParameters, final String carType)
            throws InvalidCarDataException {
        if (carType.equals(TAXI_TYPES.get(0))
                || carType.equals(TAXI_TYPES.get(1))) {
            if (actualNumberOfParameters
                    == EXPECTED_NUMBER_OF_PARAMETERS_FOR_PASSANGER_TAXI) {
                return true;
            } else {
                throw new InvalidCarDataException("неверное число параметров.");
            }
        } else if (carType.equals(TAXI_TYPES.get(2))) {
            if (actualNumberOfParameters
                    == EXPECTED_NUMBER_OF_PARAMETERS_FOR_CARGO_TAXI) {
                return true;
            } else {
                throw new InvalidCarDataException("неверное число параметров.");
            }
        } else {
            throw new InvalidCarDataException(
                    "указан несуществующий тип такси.");
        }
    }

    /**
     * @param taxiType taxi type
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    private static boolean validateTaxiType(final String taxiType)
            throws InvalidCarDataException {
        if (TAXI_TYPES.contains(taxiType)) {
            return true;
        } else {
            throw new InvalidCarDataException(
                    "указан несуществующий тип такси.");

        }
    }

    /**
     * @param carBrand car brand
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    private static boolean validateCarBrand(final String carBrand)
            throws InvalidCarDataException {
        if (CarBrand.getByTitle(carBrand).isPresent()) {
            return true;
        } else {
            throw new InvalidCarDataException("указан невалидный брэнд.");
        }
    }

    /**
     * validate Cost.
     *
     * @param cost .
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    private static boolean validateCost(final String cost)
            throws InvalidCarDataException {
        if (isInteger(cost)) {
            return true;
        } else {
            throw new InvalidCarDataException("указана невалидная цена.");
        }
    }

    /**
     * validate Mileage.
     *
     * @param mileage .
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    private static boolean validateMileage(final String mileage)
            throws InvalidCarDataException {
        if (isInteger(mileage)) {
            return true;
        } else {
            throw new InvalidCarDataException("указан невалидный пробег.");
        }
    }

    /**
     * .
     *
     * @param capacity .
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    private static boolean validateCapacity(final String capacity)
            throws InvalidCarDataException {
        if (isInteger(capacity)) {
            return true;
        } else {
            throw new InvalidCarDataException(
                    "указана невалидная вместимость.");
        }
    }

    /**
     * validate Individual Characteristics for different car types.
     *
     * @param carParameters car Parameters
     * @return true or throws InvalidCarDataException
     * @throws InvalidCarDataException if car Parameters invalid
     */
    private static boolean validateIndividualCharacteristics(
            final String[] carParameters) throws InvalidCarDataException {
        if (carParameters[0].equals(TAXI_TYPES.get(2))) {
            if (isDouble(carParameters[CarConstants.LENGTH_INDEX])
                    && isDouble(carParameters[CarConstants.WIDTH_INDEX])
                    && isDouble(carParameters[CarConstants.HEIGHT_INDEX])
                    && isDouble(carParameters[CarConstants.VOLUME_INDEX])) {
                return true;
            } else {
                throw new InvalidCarDataException(
                        "указан невалидный размер грузовой платформы.");
            }
        } else {
            if (isBoolean(carParameters[CarConstants.LENGTH_INDEX])
                    && isBoolean(carParameters[CarConstants.WIDTH_INDEX])
                    && isBoolean(carParameters[CarConstants.HEIGHT_INDEX])) {
                return true;
            } else {
                throw new InvalidCarDataException(
                        "указаны невалидные параметры возможностей перевозки.");
            }

        }
    }

    /**
     * check value is it integer.
     *
     * @param carParameter string
     * @return true or false
     */
    private static boolean isInteger(final String carParameter) {
        try {
            Integer.valueOf(carParameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * check value is it double.
     *
     * @param carParameter string
     * @return true or false
     */
    private static boolean isDouble(final String carParameter) {
        try {
            Double.valueOf(carParameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * check value is it boolean.
     *
     * @param carParameter string
     * @return true or false
     */
    private static boolean isBoolean(final String carParameter) {
        return "true".equalsIgnoreCase(carParameter)
                || "false".equalsIgnoreCase(carParameter);
    }
}
