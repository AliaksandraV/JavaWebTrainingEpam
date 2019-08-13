package by.training.matrix.service;

import by.training.matrix.exception.FileException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

/**
 * tests for getting parameters from file.
 */
public class ParameterServiceTest {
    /**
     * ParameterService with empty File.
     */
    private ParameterService emptyFile = new ParameterService();
    /**
     * ParameterService with invalid Data.
     */
    private ParameterService invalidData = new ParameterService();
    /**
     * ParameterService with wrong Matrix Size Value = 0.
     */
    private ParameterService wrongMatrixSizeValue0 = new ParameterService();
    /**
     * ParameterService with wrong Matrix Size Value = 7.
     */
    private ParameterService wrongMatrixSizeValue7 = new ParameterService();
    /**
     * ParameterService with wrong Matrix Size Value = 13.
     */
    private ParameterService wrongMatrixSizeValue13 = new ParameterService();
    /**
     * ParameterService with wrong Thread Amount Value = 0.
     */
    private ParameterService wrongThreadAmountValue0 = new ParameterService();
    /**
     * ParameterService with wrong Thread Amount Value = 3.
     */
    private ParameterService wrongThreadAmountValue3 = new ParameterService();
    /**
     * ParameterService with wrong Thread Amount Value = 7.
     */
    private ParameterService wrongThreadAmountValue7 = new ParameterService();

    /**
     * File path settings.
     */
    @BeforeTest
    public void beforeTest() {
        emptyFile.setFilePath(
                "src/test/resources/data/emptyFile.txt");
        invalidData.setFilePath(
                "src/test/resources/data/invalidData.txt");
        wrongMatrixSizeValue0.setFilePath(
                "src/test/resources/data/wrongMatrixSizeValue0.txt");
        wrongMatrixSizeValue7.setFilePath(
                "src/test/resources/data/wrongMatrixSizeValue0.txt");
        wrongMatrixSizeValue13.setFilePath(
                "src/test/resources/data/wrongMatrixSizeValue0.txt");
        wrongThreadAmountValue0.setFilePath(
                "src/test/resources/data/wrongThreadAmountValue0.txt");
        wrongThreadAmountValue3.setFilePath(
                "src/test/resources/data/wrongThreadAmountValue0.txt");
        wrongThreadAmountValue7.setFilePath(
                "src/test/resources/data/wrongThreadAmountValue0.txt");
    }

    /**
     * Data for negative GetMatrixSize testing.
     *
     * @return value and expected result
     */
    @DataProvider(name = "dataForTestGetMatrix")
    public Object[][] createInvalidDataForGetMatrixSizeParameter() {
        return new Object[][]{
                {emptyFile, FileException.class},
                {invalidData, FileException.class},
                {wrongMatrixSizeValue0, FileException.class},
                {wrongMatrixSizeValue7, FileException.class},
                {wrongMatrixSizeValue13, FileException.class}
        };
    }

    /**
     * Data for negative GetThreadNumber testing.
     *
     * @return value and expected result
     */
    @DataProvider(name = "dataForTestGetThreadNumber")
    public Object[][] createInvalidDataForGetThreadNumberParameter() {
        return new Object[][]{
                {emptyFile, FileException.class},
                {invalidData, FileException.class},
                {wrongThreadAmountValue0, FileException.class},
                {wrongThreadAmountValue3, FileException.class},
                {wrongThreadAmountValue7, FileException.class}
        };
    }

    /**
     * test for getMatrixSize method.
     *
     * @param parameter class with certain seted parameters
     * @param expected  result
     * @throws FileException if perameters in file are invalid
     */
    @Test(description = "Negative scenario for Get Matrix Size",
            dataProvider = "dataForTestGetMatrix")
    public void testGetMatrixSize(
            final ParameterService parameter,
            final Class expected) throws FileException {
        assertThrows(expected, parameter::getMatrixSize);
    }

    /**
     * test for getThreadNumber method.
     * @param parameter class with certain seted parameters
     * @param expected result
     * @throws FileException if perameters in file are invalid
     */
    @Test(description = "Negative scenario for Get Thread Number",
            dataProvider = "dataForTestGetThreadNumber")
    public void testGetThreadNumber(
            final ParameterService parameter,
            final Class expected) throws FileException {
        assertThrows(expected, parameter::getThreadNumber);
    }
}
