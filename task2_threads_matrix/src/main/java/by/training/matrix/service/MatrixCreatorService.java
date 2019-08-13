package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exception.MatrixException;

import java.util.concurrent.ThreadLocalRandom;

/**
 * contains methods for creating matrix with values.
 */
public class MatrixCreatorService {
    /**
     * A constant holding the minimum value for random.
     */
    private static final int MIN_VALUE_FOR_RANDOM = 11;
    /**
     * A constant holding the maximum value for random.
     */
    private static final int MAX_VALUE_FOR_RANDOM = 22;

    /**
     * creates a matrix of a given size fills it with random values ​​and the
     * main diagonal zeros.
     *
     * @param size matrix size.
     * @return the filled matrix.
     * @throws MatrixException if the index is out of range.
     */
    public Matrix createRandomWithZeroMainDiagonal(final int size)
            throws MatrixException {
        Matrix matrix = new Matrix(size, size);

        int verticalSize = matrix.getVerticalSize();
        int horizontalSize = matrix.getHorizontalSize();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (i == j) {
                    matrix.setElement(i, j, 0);
                } else {
                    int value = ThreadLocalRandom.current()
                            .nextInt(MIN_VALUE_FOR_RANDOM,
                                    MAX_VALUE_FOR_RANDOM);
                    matrix.setElement(i, j, value);
                }
            }
        }
        return matrix;
    }
}
