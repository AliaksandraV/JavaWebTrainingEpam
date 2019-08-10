package matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;
import org.apache.log4j.Logger;

public class MultiplicatorService {

    private Matrix matrix1;
    private Matrix matrix2;
    private Matrix resultMatrix;
    private int row;
    private int column;

    /**
     * logger initialisation.
     */
    private final org.apache.log4j.Logger LOG
            = Logger.getLogger(MultiplicatorService.class);


    public Matrix multiply(Matrix newMatrix1, Matrix newMatrix2) throws MatrixException, InterruptedException {
        matrix1 = newMatrix1;
        matrix2 = newMatrix2;

        int verticalSize = matrix1.getVerticalSize();
        int horizontalSize = matrix2.getHorizontalSize();


        if (!isCompatibleMatrices(matrix1.getHorizontalSize(), matrix2.getVerticalSize())) {
            throw new MatrixException("Несовместимые матрицы.");
        }

//        Matrix result = new Matrix(verticalSize, horizontalSize);
        resultMatrix = new Matrix(verticalSize, horizontalSize);
//        try {
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                row = i;
                column = j;
//                Thread thread = new Thread(this);
//                thread.run();
//                int nbThreads =  Thread.getAllStackTraces().keySet().size();
//                System.out.println(nbThreads);
//                run();
                RowThreadMultiplicatorService rowMultiplicator = new RowThreadMultiplicatorService(matrix1, matrix2, resultMatrix, row, column);
                Thread thread = new Thread(rowMultiplicator);
                thread.start();
                thread.join();

//                    int value = 0;
//                    for (int k = 0; k < matrix1.getHorizontalSize(); k++) {
//                        //TODO: вот это выносить в отдельный поток или циклы for немного изменить и расчет каждой строки новой матрицы венести в отдельный поток, при этом сделать возможность изменяемости количества потоков и это тоже учитывать.
//                        value += matrix1.getElement(i, k) * matrix2.getElement(k, j);
//
//                    }
//                    result.setElement(i, j, value);
            }
        }
//        } catch (MatrixException e) {
//            LOG.error(e);
//        }
        return resultMatrix;
    }

//    @Override
//    public void run() {
//        try {
//            int value = 0;
//
//            for (int k = 0; k < matrix1.getHorizontalSize(); k++) {
//                //TODO: вот это выносить в отдельный поток или циклы for немного изменить и расчет каждой строки новой матрицы венести в отдельный поток, при этом сделать возможность изменяемости количества потоков и это тоже учитывать.
//                value += matrix1.getElement(row, k) * matrix2.getElement(k, column);
//
//            }
//
//            resultMatrix.setElement(row, column, value);
//        } catch (MatrixException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Two matrices can be multiplied with each other only when the number of rows
     * in the first matrix coincides with the number of columns in the second matrix.
     *
     * @param firstMatrixHorizontalSize number of rows in the first matrix.
     * @param secondMatrixVerticalSize  the number of columns in the second matrix.
     * @return true if matrices are compatible.
     */
    private boolean isCompatibleMatrices(int firstMatrixHorizontalSize, int secondMatrixVerticalSize) {
        return firstMatrixHorizontalSize == secondMatrixVerticalSize;
    }
}
