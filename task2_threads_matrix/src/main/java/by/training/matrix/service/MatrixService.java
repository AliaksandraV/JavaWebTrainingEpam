package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * thread safe singleton, provides access to threads to fill the main diagonal of the matrix.
 */
public class MatrixService {
    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(MatrixService.class);

    /**
     * locker initialisation.
     */
    private ReentrantLock locker = new ReentrantLock();

    /**
     * default constructor for singleton object.
     */
    private MatrixService() {
    }

    /**
     * create instance of MatrixService class.
     */
    public static class MatrixServiceHolder {
        /**
         * private constructor to hide the implicit public one.
         */
        private MatrixServiceHolder() {
        }

        /**
         * instance of MatrixService.
         */
        static final MatrixService HOLDER_INSTANCE = new MatrixService();
    }

    /**
     * return instance of MatrixService.
     * @return the instance of MatrixService.
     */
    public static MatrixService getInstance() {
        return MatrixServiceHolder.HOLDER_INSTANCE;
    }

    /**
     * iterates over the main diagonal of the matrix, provides access to threads to fill the main diagonal of the matrix,
     * controls that the element is overwritten only once.
     * @param matrix matrix in which you need to fill in the diagonal
     * @param value value which will be written.
     * @return true if value has been established, false if there are no more values ​​that can be set.
     */
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
