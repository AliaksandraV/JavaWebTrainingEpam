package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * class for creating threads which try to fill matrix main diagonal.
 */
public class MainDiagonalFillService implements Runnable {
    /**
     * unique number for thread instance.
     */
    private int uniqNumber;
    /**
     * matrix instance.
     */
    private Matrix matrix;
    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(
            MainDiagonalFillService.class);

    /**
     * constructor.
     * @param newUniqNumber unique Number
     * @param newMatrix matrix
     */
    public MainDiagonalFillService(final int newUniqNumber,
                                   final Matrix newMatrix) {
        uniqNumber = newUniqNumber;
        matrix = newMatrix;
    }

    /**
     * Each thread writes its uniqNumber to the matrix.
     */
    @Override
    public void run() {
        try {
            boolean canContinue = true;
            while (canContinue) {
                TimeUnit.SECONDS.sleep(1);
                canContinue = MatrixService.getInstance()
                        .tryInsert(matrix, uniqNumber);
            }
        } catch (InterruptedException e) {
            LOG.error(e);
        }
    }
}

