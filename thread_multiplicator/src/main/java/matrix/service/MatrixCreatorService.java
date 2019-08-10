package matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exceptions.MatrixException;

public class MatrixCreatorService {

//    /**
//     * file path.
//     */
//    private String filePath;

    public static void fillRandomized(Matrix t, int start, int end) {
        int v = t.getVerticalSize();
        int h = t.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                try {
                    if(i==j){
                        t.setElement(i,j,0);
                    } else {
                        int value = (int) (Math.random() * (end - start) + start);
                        t.setElement(i, j, value);
                    }
                } catch (MatrixException e) {
                    /* в данном случае exception невозможен, поэтому обработка отсутствует */
                }
            }
        }
    }


//     public void fillFromFile(Matrix t, File f) {
//         filePath = PropertiesService.takeProperty("storage.file.path");
//     }
    // public void fillFromStream(Matrix t, InputStream input) { /* код*/ }
    // public void fillFromDataBase(Matrix t, Connection conn) { /* код*/ }
}
