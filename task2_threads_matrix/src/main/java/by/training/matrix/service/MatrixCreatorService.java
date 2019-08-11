package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;
import org.apache.log4j.Logger;

/**
 * contains methods for creating matrix with values.
 */
public class MatrixCreatorService {

    /**
     * creates a matrix of a given size fills it with random values ​​and the main diagonal zeros.
     * @param size matrix size.
     * @return the filled matrix.
     * @throws MatrixException if the index is out of range.
     */
    public Matrix createWithRandomValues(int size) throws MatrixException {
        Matrix matrix = new Matrix(size, size);
        int start = 9;
        int end = 9;

        int verticalSize = matrix.getVerticalSize();
        int horizontalSize = matrix.getHorizontalSize();
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                if (i == j) {
                    matrix.setElement(i, j, 0);
                } else {
                    int value = (int) (Math.random() * (end - start) + start);
                    matrix.setElement(i, j, value);
                }
            }
        }
        return matrix;
    }
}
