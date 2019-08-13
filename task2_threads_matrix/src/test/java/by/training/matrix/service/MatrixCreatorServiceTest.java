package by.training.matrix.service;

import by.training.matrix.entity.Matrix;
import by.training.matrix.exception.MatrixException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Test creating matrix with zero main diagonal.
 */
public class MatrixCreatorServiceTest {

    /**
     * contains method for matrix creating.
     */
    private MatrixCreatorService creatorService;

    /**
     * MatrixCreatorService initialization.
     */
    @BeforeTest
    public void beforeTest() {
        creatorService = new MatrixCreatorService();
    }

    /**
     * Return matrix size and expected main diagonal with such size.
     *
     * @return matrix size and expected main diagonal with such size
     */
    @DataProvider(name = "dataForTestCheckZeroMainDiagonal")
    public Object[][] createPositiveDataForCheckMainDiagonal() {
        return new Object[][]{
                {8, new ArrayList<Integer>() {{
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                }},
                },
                {12, new ArrayList<Integer>() {{
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                    add(0);
                }}
                }};
    }

    /**
     * check that matrix created with zero main diagonal.
     *
     * @param size                 matrix size
     * @param expectedMainDiagonal expected values for main diagonal.
     * @throws MatrixException if getting element out of range
     */
    @Test(description = "Positive scenario for check matrix main diagonal",
            dataProvider = "dataForTestCheckZeroMainDiagonal")
    public void testCreateWithRandomValues(
            final int size,
            final List<Integer> expectedMainDiagonal)
            throws MatrixException {
        Matrix matrix = creatorService.createRandomWithZeroMainDiagonal(size);

        List<Integer> actualMainDiagonal = new ArrayList<>();
        for (int i = 0; i < matrix.getVerticalSize(); i++) {
            actualMainDiagonal.add(matrix.getElement(i, i));
        }

        assertEquals(actualMainDiagonal, expectedMainDiagonal);
    }
}
