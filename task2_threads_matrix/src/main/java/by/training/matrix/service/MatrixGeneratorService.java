package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MatrixGeneratorService {

    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(MatrixGeneratorService.class);


    public static void fillRandomized(Matrix matrix, int start, int end) throws MatrixException {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                if (i == j) {
                    matrix.setElement(i, j, 0);
                } else {
                    int value = (int) (Math.random() * (end - start) + start);
                    matrix.setElement(i, j, value);
                }

            }
        }
    }


    public Matrix fillFromFile() throws MatrixException {
        String filePath = PropertiesService.takeProperty("storage.file.path.matrix");
        List<String> lines = new ArrayList<>();
        Matrix matrix = null;

        if (isFileEmpty(filePath)) {
            LOG.info("Файл пустой. Нет данных.");
        }
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(lines::add);
        } catch (IOException exception) {
            LOG.error("Возникла ошибка при чтении из файла.", exception);
        }


// TODO: массив не строк а интов надо и следовтельно валидация элемента на возможность его быть интом
        for (int i = 0; i < lines.size(); i++) {
            String[] rowMatrixElements = lines.get(i).split(" ");
            if (matrix==null){
                matrix = new Matrix(lines.size(), rowMatrixElements.length);
            }
            for (int j = 0; j < rowMatrixElements.length; j++) {
                matrix.setElement(i, j, Integer.valueOf(rowMatrixElements[j]));
            }
        }
        return matrix;
    }

    /**
     * check is file empty.
     *
     * @return true if file is empty
     */
    private boolean isFileEmpty(String filePath) {
        File file = new File(filePath);
        return file.length() == 0;
    }

}
