package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MainDiagonalFillService implements Runnable {

    private int unicNumber;
    private Matrix matrix;
    private ReentrantLock locker;

    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(MainDiagonalFillService.class);

    /**
     * constructor.
     */
    public MainDiagonalFillService(final int newUnicNumber, final Matrix newMatrix, final ReentrantLock lock) {
        unicNumber = newUnicNumber;
        matrix = newMatrix;
        locker = lock;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < matrix.getVerticalSize(); i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    locker.lock();
                    if (matrix.getElement(i, i) == 0) {
                        matrix.setElement(i, i, unicNumber);
                    }
                } finally {
                    locker.unlock();
                }
            }
        } catch (MatrixException | InterruptedException e) {
            LOG.error(e);
        }
    }

}

