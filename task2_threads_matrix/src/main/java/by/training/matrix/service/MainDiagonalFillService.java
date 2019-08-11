package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class MainDiagonalFillService implements Runnable {

    private int unicNumber;
    private Matrix matrix;

    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(MainDiagonalFillService.class);

    /**
     * constructor.
     */
    public MainDiagonalFillService(final int newUnicNumber, final Matrix newMatrix) {
        unicNumber = newUnicNumber;
        matrix = newMatrix;
    }

    @Override
    public void run() {
        boolean haveMore = true;

        while (haveMore) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                LOG.error(e);
            }
            haveMore = MatrixService.getInstance().tryInsert(matrix, unicNumber);
        }
    }

}

