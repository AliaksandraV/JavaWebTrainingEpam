package by.training.matrix.entity;

import by.training.matrix.exception.MatrixException;

/**
 * matrix entity.
 */
public class Matrix {
    /**
     * store elements of matrix.
     */
    private int[][] values;
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
    public Matrix(final int newVerticalSize, final int newHorizontalSize)
            throws MatrixException {
        if ((newVerticalSize < 1) || (newHorizontalSize < 1)) {
            throw new MatrixException(
                    "Отрицательное значение размера матрицы.");
        }
        values = new int[newVerticalSize][newHorizontalSize];
        verticalSize = values.length;
        horizontalSize = values[0].length;
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
    public int getElement(final int columnIndex, final int rowIndex)
            throws MatrixException {
        if (checkRange(columnIndex, rowIndex)) {
            return values[columnIndex][rowIndex];
        } else {
            throw new MatrixException("Выход за пределы массива.");
        }

    }

    /**
     * Inserts the specified element at the specified position in this matrix.
     *
     * @param columnIndex column index at which the specified element is to be
     *                    inserted
     * @param rowIndex    row index at which the specified element is to be
     *                    inserted
     * @param value       element to be inserted
     * @throws MatrixException if the index is out of range.
     */
    public void setElement(final int columnIndex, final int rowIndex,
                           final int value) throws MatrixException {
        if (checkRange(columnIndex, rowIndex)) {
            values[columnIndex][rowIndex] = value;
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
        StringBuilder matrixValues = new StringBuilder("\nMatrix : "
                + values.length + "x" + values[0].length + "\n");
        for (int[] row : values) {
            for (int value : row) {
                matrixValues.append(value + " ");
            }
            matrixValues.append("\n");
        }
        return matrixValues.toString();
    }

    /**
     * check possibility index out of bond exception.
     *
     * @param actualVerticalSize   matrix verticalSize.
     * @param actualHorizontalSize matrix horizontalSize.
     * @return true if range is correct.
     */
    private boolean checkRange(final int actualVerticalSize,
                               final int actualHorizontalSize) {
        return actualVerticalSize >= 0
                && actualVerticalSize < values.length
                && actualHorizontalSize >= 0
                && actualHorizontalSize < values[0].length;
    }
}
