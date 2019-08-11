package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;

public class TaskValidator {

   public boolean isMatrixSuitableForTheTask(Matrix matrix) throws MatrixException {
       return isSquareMatrix(matrix)&&isCorrectMatrixSize(matrix)&&isZeroMainDiagonal(matrix);
   }

    //TODO: проверять что матрица квадратная
    private boolean isSquareMatrix(Matrix matrix) {
        return matrix.getHorizontalSize() == matrix.getVerticalSize();
    }

    //TODO: проверять что главная диагональ матрицы заполнена нулями
    private boolean isZeroMainDiagonal(Matrix matrix) throws MatrixException {
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            if (matrix.getElement(i, i) != 0) {
               return false;
            }
        }
        return true;
    }

    //TODO: проверять размер матрицы в соответствиями с условиями таска
    private boolean isCorrectMatrixSize(Matrix matrix) {
        return matrix.getHorizontalSize()>=8 && matrix.getHorizontalSize()<=12
                && matrix.getVerticalSize()>=8 && matrix.getVerticalSize()<=12;
    }


    //TODO: создать класс который будет отвечать за создание потоков в который будет передаваться число потоков для создания и это число будет сверяться с требуемым


}
