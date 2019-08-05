package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;
import org.apache.log4j.Logger;

public class MultiplicatorService {
    /**
     * logger initialisation.
     */
    private final org.apache.log4j.Logger LOG
            = Logger.getLogger(MultiplicatorService.class);


    public Matrix multiply(Matrix matrix1, Matrix matrix2) throws MatrixException {
        int verticalSize = matrix1.getVerticalSize();
        int horizontalSize = matrix2.getHorizontalSize();

        if (!isCompatibleMatrices(matrix1.getHorizontalSize(), matrix2.getVerticalSize())) {
            throw new MatrixException("Несовместимые матрицы.");
        }

        Matrix result = new Matrix(verticalSize, horizontalSize);
        try {
            for (int i = 0; i < verticalSize; i++) {
                for (int j = 0; j < horizontalSize; j++) {
                    int value = 0;
                    for (int k = 0; k < matrix1.getHorizontalSize(); k++) {
                        //TODO: вот это выносить в отдельный поток или циклы for немного изменить и расчет каждой строки новой матрицы венести в отдельный поток, при этом сделать возможность изменяемости количества потоков и это тоже учитывать.
                        value += matrix1.getElement(i, k) * matrix2.getElement(k, j);

                    }
                    result.setElement(i, j, value);
                }
            }
        } catch (MatrixException e) {
            LOG.error(e);
        }
        return result;
    }

    /**
     * Two matrices can be multiplied with each other only when the number of rows
     * in the first matrix coincides with the number of columns in the second matrix.
     * @param firstMatrixHorizontalSize number of rows in the first matrix.
     * @param secondMatrixVerticalSize the number of columns in the second matrix.
     * @return true if matrices are compatible.
     */
    private boolean isCompatibleMatrices(int firstMatrixHorizontalSize, int secondMatrixVerticalSize) {
        return firstMatrixHorizontalSize == secondMatrixVerticalSize;
    }
}
