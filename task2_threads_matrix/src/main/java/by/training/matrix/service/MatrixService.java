package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;

public class MatrixService {

    private MatrixGeneratorService matrixGenerator = new MatrixGeneratorService();
    private Matrix matrix;

    public MatrixService(Matrix newMatrix){
        matrix = newMatrix;
    }

    public Matrix createRandomMatrix() {
        return null;
    }

    public void createFromFile() throws MatrixException {
//        matrixGenerator.fillFromFile(matrix);
//        return matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
