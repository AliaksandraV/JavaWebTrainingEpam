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


    public Matrix multiply(Matrix p, Matrix q) throws MatrixException {
        int v = p.getVerticalSize();
        int h = q.getHorizontalSize();
        int temp = p.getHorizontalSize();
        // проверка возможности умножения
        if (temp != q.getVerticalSize()) {
            throw new MatrixException(); // Incompatible matrices
        }
        // создание матрицы результата
        Matrix result = new Matrix(v, h);
        try {
            // умножение
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    int value = 0;
                    for (int k = 0; k < temp; k++) {
                        value += p.getElement(i, k) * q.getElement(k, j);
                    }
                    result.setElement(i, j, value);
                }
            }
        } catch (MatrixException e) {
            LOG.error(e);
        }
        return result;
    }
}