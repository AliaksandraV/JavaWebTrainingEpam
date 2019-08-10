package matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;

import java.util.concurrent.TimeUnit;

public class RowThreadMultiplicatorService implements Runnable {
    Matrix matrix1;
    Matrix matrix2;
    Matrix resultMatrix;
    int row;
    int column;

    public RowThreadMultiplicatorService(Matrix newMatrix1, Matrix newMatrix2, Matrix newResultMatrix, int newRow, int newColumn) {
        matrix1 = newMatrix1;
        matrix2 = newMatrix2;
        resultMatrix = newResultMatrix;
        row = newRow;
        column = newColumn;
    }

//    @Override
//    public void run() {
//
//    }


    @Override
    public void run() {
        try {
            int value = 0;
            for (int k = 0; k < matrix1.getHorizontalSize(); k++) {
                //TODO: вот это выносить в отдельный поток или циклы for немного изменить и расчет каждой строки новой матрицы венести в отдельный поток, при этом сделать возможность изменяемости количества потоков и это тоже учитывать.
                value += matrix1.getElement(row, k) * matrix2.getElement(k, column);

            }
            TimeUnit.SECONDS.sleep(1);
            resultMatrix.setElement(row, column, value);
        } catch (MatrixException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
