package by.training.matrix;

import by.training.matrix.entity.Matrix;
import by.training.matrix.service.MainDiagonalFillService;
import by.training.matrix.service.MatrixCreatorService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    private static final int THREAD_NUMBER = 4;

    public static void main(String[] args) {
        try {
            MatrixCreatorService matrixCreatorService = new MatrixCreatorService();
            Matrix matrix = matrixCreatorService.loadFromFile();
            // todo validate matrix

            LOG.info("Matrix is: " + matrix);

            threadCreator(matrix, THREAD_NUMBER);

            LOG.info("Matrix with new main diagonal is: " + matrix);
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    private static void threadCreator(final Matrix matrix, final int threadNumbers) throws InterruptedException {
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

}
