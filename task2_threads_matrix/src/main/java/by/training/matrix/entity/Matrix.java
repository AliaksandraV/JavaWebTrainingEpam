package by.training.matrix.entity;

import by.training.matrix.exceptions.MatrixException;

/**
 * matrix entity.
 */
public class Matrix {
    /**
     * store elements of matrix.
     */
    private int[][] matrix;
    /**
     * matrix vertical size.
     */
    private int verticalSize;
    /**
     * matrix horizontal size.
     */
    private int horizontalSize;

    /**
     * default constructor.
     */
    public Matrix() {

    }

    /**
     * constructor.
     *
     * @param newVerticalSize   matrix vertical size.
     * @param newHorizontalSize matrix horizontal size.
     * @throws MatrixException if size contain negative meaning.
     */
    public Matrix(int newVerticalSize, int newHorizontalSize) throws MatrixException {
        if ((newVerticalSize < 1) || (newHorizontalSize < 1)) {
            throw new MatrixException("Отрицательное значение размера матрицы.");
        }
        matrix = new int[newVerticalSize][newHorizontalSize];
        verticalSize = matrix.length;
        horizontalSize = matrix[0].length;
    }

    /**
     * vertical size.
     *
     * @return vertical size.
     */
    public int getVerticalSize() {
        return verticalSize;
    }

    /**
     * horizontal size.
     *
     * @return horizontal size.
     */
    public int getHorizontalSize() {
        return horizontalSize;
    }

    /**
     * Returns the element at the specified position in this matrix.
     *
     * @param columnIndex column index of the element to return
     * @param rowIndex    row index of the element to return
     * @return the element at the specified position in this list
     * @throws MatrixException if the index is out of range.
     */
    public int getElement(int columnIndex, int rowIndex) throws MatrixException {
        if (checkRange(columnIndex, rowIndex)) {
            int value = matrix[columnIndex][rowIndex];
            return value;
        } else {
            throw new MatrixException("Выход за пределы массива.");
        }

    }

    /**
     * Inserts the specified element at the specified position in this matrix
     *
     * @param columnIndex column index at which the specified element is to be inserted
     * @param rowIndex    row index at which the specified element is to be inserted
     * @param value       element to be inserted
     * @throws MatrixException if the index is out of range.
     */
    public void setElement(int columnIndex, int rowIndex, int value) throws MatrixException {
        if (checkRange(columnIndex, rowIndex)) {
            matrix[columnIndex][rowIndex] = value;
//            System.out.println("Записано значение " + value);
        } else {
            throw new MatrixException("Выход за пределы массива.");
        }
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix : " + matrix.length + "x" + matrix[0].length + "\n");
        for (int[] row : matrix) {
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
        return verticalSize >= 0 && verticalSize < matrix.length && horizontalSize >= 0 && horizontalSize < matrix[0].length;
    }
}
