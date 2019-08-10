package by.training.matrix;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;
import by.training.matrix.service.MainDiagonalFillService;
import by.training.matrix.service.MatrixGeneratorService;
import by.training.matrix.service.MatrixService;
import by.training.matrix.service.TaskValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws MatrixException {
        //TODO: сообразить как передать а потом забрать одну единственную матрицу через все слои классов
        MatrixGeneratorService generatorService = new MatrixGeneratorService();
        Matrix matrix = generatorService.fillFromFile();

//        System.out.println("Matrix is: " + matrix);

        TaskValidator validator = new TaskValidator();
        matrix = new Matrix(8,12);
        System.out.println(validator.isCorrectMatrixSize(matrix));

//        try {
//            Matrix matrix = new Matrix(3, 3);
//            MatrixGeneratorService.fillRandomized(matrix, 9, 9);
//            System.out.println("Matrix is: " + matrix);
//
//            ReentrantLock locker = new ReentrantLock(); // создаем заглушку
//
//
//            threadCreator(matrix, 4, locker);
//
//            System.out.println("NEW Matrix is: " + matrix);
//
//
//        } catch (MatrixException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }

//    private static void threadCreator(final Matrix matrix, final int threadNumbers, final ReentrantLock locker) throws InterruptedException {
//        List<Thread> threads = new ArrayList<>();
//
//        for (int i = 1; i <= threadNumbers; i++){
//            threads.add(new Thread(new MainDiagonalFillService(i , matrix, locker)));
//        }
//
//        for (Thread thread: threads){
//            thread.start();
//        }
//
//        for (Thread thread: threads){
//            thread.join();
//        }
//
//    }

}
