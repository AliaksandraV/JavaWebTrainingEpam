package by.training.taxistation.repository.factory;

import by.training.taxistation.entity.car.CarBrand;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class CarFactoryValidator {

    private static final int expectedNumberOfParametersForCargoTaxi = 12;
    private static final int expectedNumberOfParametersForPassangerTaxi = 11;
    private static final List<String> taxiTypes = Arrays.asList("taxi", "minibus", "cargotaxi");

    private CarFactoryValidator() {

    }

    /**
     * lineNumber указывает номер строки в файле в которой указаны невалидные данные
     *
     * @param
     * @return
     */
    public static boolean validateCarParametersFromFile(String[] carParameters) throws InvalidCarDataException {
//            lineNumber += 1;
        if (validateTaxiType(carParameters[0])//, lineNumber)
                && validateNumberOfParameters(carParameters.length, carParameters[0])//, lineNumber)
                && validateCarBrand(carParameters[1])//, lineNumber)
                && validateCapacity(carParameters[3])//, lineNumber)
                && validateCapacity(carParameters[4])//, lineNumber)
                && validateMileage(carParameters[6])//, lineNumber)
                && validateCost(carParameters[7])//, lineNumber)
                && validateIndividualCharacteristics(carParameters)) {//, lineNumber)) {
            return true;
        }
        return false;
    }


    private static boolean validateNumberOfParameters(int actualNumberOfParameters, String carType) throws InvalidCarDataException {//, int lineNumber) {
        if (carType.equals(taxiTypes.get(0)) || carType.equals(taxiTypes.get(1))) {
            if (actualNumberOfParameters == expectedNumberOfParametersForPassangerTaxi) {
                return true;
            } else {
                throw new InvalidCarDataException("неверное число параметров.");
            }
        } else if (carType.equals(taxiTypes.get(2))) {
            if (actualNumberOfParameters == expectedNumberOfParametersForCargoTaxi) {
                return true;
            } else {
                throw new InvalidCarDataException("неверное число параметров.");
            }
        } else {
            throw new InvalidCarDataException("указан несуществующий тип такси.");
        }
    }

    private static boolean validateTaxiType(String taxiType) throws InvalidCarDataException {//, int lineNumber) {
        if (taxiTypes.contains(taxiType)) {
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
        if (carParameters[0].equals(taxiTypes.get(2))) {
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
