package by.training.taxistation.dao.validation;

import by.training.taxistation.entity.taxi.CarBrand;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFromFileValidator {

    private static final Logger log = Logger.getLogger(ReadFromFileValidator.class);
    private static final String delimiter = "|";
    private static final int expectedNumberOfParameters = 6;
    private static final List<String> taxiTypes = Arrays.asList("taxi", "minibus", "cargotaxi");

    private ReadFromFileValidator() {

    }

    public static List<String> validateCarParametersFromFile(List<String> linesFromFile) {
        List<String> validLines = new ArrayList<>();
        for (int i = 0; i < linesFromFile.size(); i++) {
            String description = linesFromFile.get(i);
            String[] carParameters = description.split("\\" + delimiter);
            int lineNumber = i + 1;
            if (validateNumberOfParameters(carParameters.length, lineNumber)
                    && validateTaxiType(carParameters[0], lineNumber)
                    && validateCarBrand(carParameters[1], lineNumber)
                    && validateCost(carParameters[3], lineNumber)
                    && validateMileage(carParameters[4], lineNumber)
                    && validateCapacity(carParameters[5], lineNumber)) {
                validLines.add(linesFromFile.get(i));
            }
        }
        return validLines;
    }

    private static boolean validateNumberOfParameters(int actualNumberOfParameters, int lineNumber) {
        if (actualNumberOfParameters == expectedNumberOfParameters) {
            return true;
        } else {
            log.error("У файла в строке " + lineNumber + " неверное число параметров.");
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

    private static boolean isInteger(String carParameter) {
        try {
            Integer.valueOf(carParameter);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
