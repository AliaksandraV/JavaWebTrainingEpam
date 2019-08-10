package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;

public class TaskValidator {
    //TODO: проверять что матрица квадратная
    public boolean isSquareMatrix(Matrix matrix) {
        return matrix.getHorizontalSize() == matrix.getVerticalSize();
    }

    //TODO: проверять что главная диагональ матрицы заполнена нулями
    public boolean isZeroMainDiagonal(Matrix matrix) throws MatrixException {
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            if (matrix.getElement(i, i) != 0) {
               return false;
            }
        }
        return true;
    }

    //TODO: проверять размер матрицы в соответствиями с условиями таска
    public boolean isCorrectMatrixSize(Matrix matrix) {
        return matrix.getHorizontalSize()>=8 && matrix.getHorizontalSize()<=12
                && matrix.getVerticalSize()>=8 && matrix.getVerticalSize()<=12;
    }


    //TODO: создать класс который будет отвечать за создание потоков в который будет передаваться число потоков для создания и это число будет сверяться с требуемым


}
