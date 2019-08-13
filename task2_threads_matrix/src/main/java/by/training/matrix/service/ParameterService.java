package by.training.matrix.service;

import by.training.matrix.exception.FileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Read value of matrix size and thread number from file.
 */
public class ParameterService {

    /**
     * File path from properties file.
     */
    private String filePath;

    /**
     * A constant holding the minimum value for matrix size.
     */
    private static final int MIN_MATRIX_SIZE = 8;
    /**
     * A constant holding the maximum value for matrix size.
     */
    private static final int MAX_MATRIX_SIZE = 12;
    /**
     * A constant holding the minimum value for thread amount.
     */
    private static final int MIN_THREAD_AMOUNT = 4;
    /**
     * A constant holding the maximum value for thread amount.
     */
    private static final int MAX_THREAD_AMOUNT = 6;

    /**
     * default constructor.
     */
    public ParameterService() {
        setFilePath(PropertiesService.takeProperty(
                "storage.file.path.matrix"));
    }

    /**
     * Search matrix size parameter in file.
     *
     * @return matrix size
     * @throws FileException if incorrect value of matrix size.
     */
    public int getMatrixSize() throws FileException {
        try {
            String matrixSizeParameter = findParameterByName(
                    loadLinesFromFile(), "matrix size");
            if (matrixSizeParameter != null) {
                int matrixSize = Integer.parseInt(matrixSizeParameter);

                if (isCorrectMatrixSize(matrixSize)) {
                    return matrixSize;
                } else {
                    throw new FileException("Для размера матрицы указано "
                            + "значение не попадающее в диапазот от 8 до 12.");
                }

            } else {
                throw new FileException("Размер матрицы не указан.");
            }
        } catch (NumberFormatException e) {
            throw new FileException(
                    "Размер матрицы указан в неверном формате.");
        }
    }

    /**
     * Search thread number parameter in file.
     *
     * @return thread number.
     * @throws FileException if incorrect value of thread number.
     */
    public int getThreadNumber() throws FileException {
        try {
            String threadNumberParameter = findParameterByName(
                    loadLinesFromFile(), "thread number");
            if (threadNumberParameter != null) {
                int threadNumber = Integer.parseInt(threadNumberParameter);

                if (isCorrectThreadNumber(threadNumber)) {
                    return threadNumber;
                } else {
                    throw new FileException(
                            "Для количества потоков указано значение не"
                                    + "попадающее в диапазот от 4 до 6.");
                }

            } else {
                throw new FileException("Количество потоков не указано.");
            }
        } catch (NumberFormatException e) {
            throw new FileException(
                    "Количество потоков указано в неверном формате.");
        }
    }

    /**
     * Load list of lines from file.
     *
     * @return list of lines
     * @throws FileException if file is empty.
     */
    private List<String> loadLinesFromFile() throws FileException {
        List<String> lines = new ArrayList<>();
        if (isFileEmpty(filePath)) {
            throw new FileException("Файл пустой. Нет данных.");
        }
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(lines::add);
        } catch (IOException exception) {
            throw new FileException(exception.getMessage());
        }
        return lines;
    }

    /**
     * Looking for the desired value.
     *
     * @param lines         from file.
     * @param nameParameter search parameter
     * @return looking value.
     * @throws FileException if incorrect parameters number in file.
     */
    private String findParameterByName(final List<String> lines,
                                       final String nameParameter)
            throws FileException {
        for (String line : lines) {

            String[] initializationParameters = line.split("=");
            if (initializationParameters.length != 2) {
                throw new FileException("Неверное значение параметров.");
            }
            String parameter = initializationParameters[0];

            if (parameter.equalsIgnoreCase(nameParameter)) {
                return initializationParameters[1];
            }
        }
        return null;
    }

    /**
     * Check matrix size parameter.
     *
     * @param matrixSize actual matrix size
     * @return true if matrix size is correct.
     */
    private boolean isCorrectMatrixSize(final int matrixSize) {

        return matrixSize >= MIN_MATRIX_SIZE && matrixSize <= MAX_MATRIX_SIZE;
    }

    /**
     * Check thread number parameter.
     *
     * @param threadNumber actual thread number
     * @return true if thread number is correct.
     */
    private boolean isCorrectThreadNumber(final int threadNumber) {
        return threadNumber >= MIN_THREAD_AMOUNT
                && threadNumber <= MAX_THREAD_AMOUNT;
    }

    /**
     * check is file empty.
     *
     * @param actualFilePath file path
     * @return true if file is empty
     */
    private boolean isFileEmpty(final String actualFilePath) {
        File file = new File(actualFilePath);
        return file.length() == 0;
    }

    /**
     * return file path.
     * @return file path.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * set file path.
     * @param newFilePath file path.
     */
    public void setFilePath(final String newFilePath) {
        this.filePath = newFilePath;
    }
}
