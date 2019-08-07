package by.training.matrix;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;
import by.training.matrix.service.MatrixCreatorService;
import by.training.matrix.service.MultiplicatorService;

public class Main {

    public static void main(String[] args) throws MatrixException {
//        try {
//
//            Matrix p = new Matrix(100, 100);
//            MatrixCreatorService.fillRandomized(p, 2, 8);
//            System.out.println("Matrix first is: " + p);
//            Matrix q = new Matrix(100, 100);
//            MatrixCreatorService.fillRandomized(q, 2, 7);
//            System.out.println("Matrix second is: " + q);
//            MultiplicatorService mult = new MultiplicatorService();
//            System.out.println("Matrices product is " + mult.multiply(p, q));
//        } catch (MatrixException ex) {
//            System.err.println("Error of creating matrix " + ex);
//        }
        try {
            Matrix p = matrix1();

            System.out.println("Matrix first is: " + p);

            Matrix q = matrix2();

            System.out.println("Matrix second is: " + q);
            MultiplicatorService mult = new MultiplicatorService();
            System.out.println("Matrices product is " + mult.multiply(p, q));
        } catch (MatrixException ex) {
            System.err.println("Error of creating matrix " + ex);
        }
    }

    public static Matrix matrix1() throws MatrixException {
        Matrix p = new Matrix(2, 3);
        p.setElement(0, 0, 3);
        p.setElement(0, 1, 4);
        p.setElement(0, 2, 7);
        p.setElement(1, 0, 4);
        p.setElement(1, 1, 7);
        p.setElement(1, 2, 2);
        return p;
    }

    public static Matrix matrix2() throws MatrixException {
        Matrix q = new Matrix(3, 4);
        q.setElement(0, 0, 3);
        q.setElement(0, 1, 3);
        q.setElement(0, 2, 6);
        q.setElement(0, 3, 6);
        q.setElement(1, 0, 5);
        q.setElement(1, 1, 6);
        q.setElement(1, 2, 5);
        q.setElement(1, 3, 5);
        q.setElement(2, 0, 4);
        q.setElement(2, 1, 3);
        q.setElement(2, 2, 3);
        q.setElement(2, 3, 4);
        return q;
    }
}
