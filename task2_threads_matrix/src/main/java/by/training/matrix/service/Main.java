package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * launches the application.
 */
public final class Main {
    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(Main.class);
    /**
     * timeout value.
     */
    private static final long TIMEOUT = 24L;

    /**
     * default constructor.
     */
    private Main() {
    }

    /**
     * The main method.
     *
     * @param args the command line parameters.
     */
    public static void main(final String[] args) {
        try {
            ParameterService parameter = new ParameterService();

            MatrixCreatorService matrixCreatorService
                    = new MatrixCreatorService();

            Matrix matrixForThread = matrixCreatorService
                    .createRandomWithZeroMainDiagonal(
                            parameter.getMatrixSize());
            LOG.info("Matrix is: " + matrixForThread);
            threadCreator(matrixForThread, parameter.getThreadNumber());
            LOG.info("Matrix with new main diagonal by Thread: "
                    + matrixForThread);

            Matrix matrixForExecutor = matrixCreatorService
                    .createRandomWithZeroMainDiagonal(
                            parameter.getMatrixSize());
            LOG.info("Matrix is: " + matrixForExecutor);
            executorCreator(matrixForExecutor, parameter.getThreadNumber());
            LOG.info("Matrix with new main diagonal by executer: "
                    + matrixForExecutor);

        } catch (Exception e) {
            LOG.error(e);
        }
    }

    /**
     * create threads with unique number that will try to write its
     * number in matrix main diagonal.
     *
     * @param matrix        matrix that will be changed.
     * @param threadNumbers that will be create.
     * @throws InterruptedException if any thread has interrupted the
     *                              current thread.
     */
    private static void threadCreator(final Matrix matrix,
                                      final int threadNumbers)
            throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= threadNumbers; i++) {
            Thread thread = new Thread(new MainDiagonalFillService(i, matrix));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    /**
     * create executors with unique number that will try to write its number
     * in matrix main diagonal.
     *
     * @param matrix        matrix that will be changed.
     * @param threadNumbers number of executors that will be create.
     * @throws InterruptedException if any thread has interrupted the current
     *                              thread.
     */
    private static void executorCreator(final Matrix matrix,
                                        final int threadNumbers)
            throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(threadNumbers);

        for (int i = 1; i <= threadNumbers; i++) {
            executor.execute(new MainDiagonalFillService(i, matrix));
        }

        executor.shutdown();
        while (!executor.awaitTermination(TIMEOUT, TimeUnit.HOURS)) {
            LOG.info("Not yet. Still waiting for termination");
        }
    }
}
