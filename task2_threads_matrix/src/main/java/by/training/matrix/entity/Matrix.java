package by.training.matrix.entity;

import by.training.matrix.exceptions.MatrixException;

public class Matrix {

    private int[][] a;
    private int verticalSize;
    private int horizontalSize;


    public Matrix(int newVerticalSize, int newHorizontalSize) throws MatrixException {
        if ((newVerticalSize < 1) || (newHorizontalSize < 1)) {
            throw new MatrixException("Отрицательное значение размера матрицы.");
        }
        a = new int[newVerticalSize][newHorizontalSize];
        verticalSize = a.length;
        horizontalSize = a[0].length;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public int getElement(int columnIndex, int rowIndex) throws MatrixException {
        if (checkRange(columnIndex, rowIndex)) {
            int value = a[columnIndex][rowIndex];
            return value;
        } else {
            throw new MatrixException("Выход за пределы массива.");
        }

    }

    public void setElement(int columnIndex, int rowIndex, int value) throws MatrixException {
        if (checkRange(columnIndex, rowIndex)) {
            a[columnIndex][rowIndex] = value;
//            System.out.println("Записано значение " + value);
        } else {
            throw new MatrixException("Выход за пределы массива.");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x" + a[0].length + "\n");
        for (int[] row : a) {
            for (int value : row) {
                s.append(value + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    /**
     * check possibility index out of bond exception.
     *
     * @param verticalSize   matrix verticalSize.
     * @param horizontalSize matrix horizontalSize.
     * @return true if range is correct.
     */
    private boolean checkRange(int verticalSize, int horizontalSize) {
        if (verticalSize >= 0 && verticalSize < a.length && horizontalSize >= 0 && horizontalSize < a[0].length) {
            return true;
        } else {
            return false;
        }
    }
}
