package by.training.composite.dao;

import by.training.composite.exception.FileException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Read text from file and return String.
 */
public class FileReader {

    /**
     * File path from properties file.
     */
    private Path filePath;

    /**
     * default constructor.
     */
    public FileReader() {
        setFilePath(Paths.get(PropertiesReader.takeProperty("config.properties",
                "file.path")));
    }

    /**
     * Load content from file.
     *
     * @return content in string format
     * @throws FileException if file is empty.
     */
    public String read() throws FileException {
        if (isFileEmpty(filePath)) {
            throw new FileException("Файл пустой. Нет данных.");
        }
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new FileException("Ошибка во время чтения данных из файла.");
        }
    }

    /**
     * check is file empty.
     *
     * @param actualFilePath file path
     * @return true if file is empty
     */
    private boolean isFileEmpty(final Path actualFilePath) {
        File file = new File(actualFilePath.toString());
        return file.length() == 0;
    }

    /**
     * return file path.
     *
     * @return file path.
     */
    public Path getFilePath() {
        return filePath;
    }

    /**
     * set file path.
     *
     * @param newFilePath file path.
     */
    public void setFilePath(final Path newFilePath) {
        filePath = newFilePath;
    }
}
