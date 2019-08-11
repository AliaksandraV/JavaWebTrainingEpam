package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class MatrixService {

    private static final Logger LOG = Logger.getLogger(MatrixService.class);

    private ReentrantLock locker = new ReentrantLock(); // создаем lock

    private MatrixService() {
    }

    public static class MatrixServiceHolder {
        private MatrixServiceHolder() {
        }

        static final MatrixService HOLDER_INSTANCE = new MatrixService();
    }

    public static MatrixService getInstance() {
        return MatrixServiceHolder.HOLDER_INSTANCE;
    }

    public Matrix createRandomMatrix() {
        return null;
    }

    public boolean tryInsert(Matrix matrix, int value) {
        try {
            locker.lock();

            for (int i = 0; i < matrix.getVerticalSize(); i++) {
                if (matrix.getElement(i, i) == 0) {
                    matrix.setElement(i, i, value);
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e);
        } finally {
            locker.unlock();
        }

        return false;
    }

}
