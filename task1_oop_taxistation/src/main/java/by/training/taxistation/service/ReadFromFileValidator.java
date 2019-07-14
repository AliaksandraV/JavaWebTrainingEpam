package by.training.taxistation.service;

import by.training.taxistation.entity.car.CarBrand;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReadFromFileValidator {

    private static final Logger log = Logger.getLogger(ReadFromFileValidator.class);
    private static final String delimiter = "|";
    private static final int expectedNumberOfParametersForCargoTaxi = 12;
    private static final int expectedNumberOfParametersForPassangerTaxi = 11;
    private static final List<String> taxiTypes = Arrays.asList("taxi", "minibus", "cargotaxi");

    private ReadFromFileValidator() {

    }

    /**
     * lineNumber указывает номер строки в файле в которой указаны невалидные данные
     *
     * @param linesFromFile
     * @return
     */
    static List<String> validateCarParametersFromFile(List<String> linesFromFile) {
        List<String> validLines = new ArrayList<>();
        for (int i = 0; i < linesFromFile.size(); i++) {
            String description = linesFromFile.get(i);
            String[] carParameters = description.split("\\" + delimiter);
            int lineNumber = i + 1;

            if (validateTaxiType(carParameters[0], lineNumber)
                    && validateNumberOfParameters(carParameters.length, carParameters[0], lineNumber)
                    && validateCarBrand(carParameters[1], lineNumber)
                    && validateCapacity(carParameters[3], lineNumber)
                    && validateCapacity(carParameters[4], lineNumber)
                    && validateMileage(carParameters[6], lineNumber)
                    && validateCost(carParameters[7], lineNumber)
                    && validateIndividualCharacteristics(carParameters, lineNumber)) {
                validLines.add(linesFromFile.get(i));
            }
        }
        return validLines;
    }


    private static boolean validateNumberOfParameters(int actualNumberOfParameters, String carType, int lineNumber) {
        if (carType.equals(taxiTypes.get(0)) || carType.equals(taxiTypes.get(1))) {
            if (actualNumberOfParameters == expectedNumberOfParametersForPassangerTaxi) {
                return true;
            } else {
                log.error("У файла в строке " + lineNumber + " неверное число параметров.");
                return false;
            }
        } else if (carType.equals(taxiTypes.get(2))) {
            if (actualNumberOfParameters == expectedNumberOfParametersForCargoTaxi) {
                return true;
            } else {
                log.error("У файла в строке " + lineNumber + " неверное число параметров.");
                return false;
            }
        } else {
            log.error("У файла в строке " + lineNumber + "  указан несуществующий тип такси.");
            return false;
        }
    }

    private static boolean validateTaxiType(String taxiType, int lineNumber) {
        if (taxiTypes.contains(taxiType)) {
            return true;
        } else {
            log.error("У файла в строке " + lineNumber + " указан несуществующий тип такси.");
            return false;
        }
    }

    private static boolean validateCarBrand(String carBrand, int lineNumber) {
        if (CarBrand.getByTitle(carBrand).isPresent()) {
            return true;
        } else {
            log.error("У файла в строке " + lineNumber + " указан невалидный брэнд.");
            return false;
        }
    }

    private static boolean validateCost(String cost, int lineNumber) {
        if (isInteger(cost)) {
            return true;
        } else {
            log.error("У файла в строке " + lineNumber + " указана невалидная цена.");
            return false;
        }
    }

    private static boolean validateMileage(String mileage, int lineNumber) {
        if (isInteger(mileage)) {
            return true;
        } else {
            log.error("У файла в строке " + lineNumber + " указан невалидный пробег.");
            return false;
        }
    }

    private static boolean validateCapacity(String capacity, int lineNumber) {
        if (isInteger(capacity)) {
            return true;
        } else {
            log.error("У файла в строке " + lineNumber + " указана невалидная вместимость.");
            return false;
        }
    }

    private static boolean validateIndividualCharacteristics(String[] carParameters, int lineNumber) {
        if (carParameters[0].equals(taxiTypes.get(2))) {
            if (isDouble(carParameters[8])
                    && isDouble(carParameters[9])
                    && isDouble(carParameters[10])
                    && isDouble(carParameters[11])) {
                return true;
            } else {
                log.error("У файла в строке " + lineNumber + " указан невалидный размер грузовой платформы.");
                return false;
            }
        } else {
            if (isBoolean(carParameters[8])
                    && isBoolean(carParameters[9])
                    && isBoolean(carParameters[10])) {
                return true;
            } else {
                log.error("У файла в строке " + lineNumber + " указаны невалидные параметры возможностей перевозки.");
                return false;
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
