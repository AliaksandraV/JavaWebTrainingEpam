package by.training.photographer.dao;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(PropertiesReader.class);

    /**
     * constructor.
     */
    private PropertiesReader() {
    }

    /**
     * configurations properties.
     *
     * @param propertiesFile name of property File
     * @param key           value From Properties File
     * @return properties
     */
    public static String takeProperty(final String propertiesFile,
                                      final String key) {
        ClassLoader classLoader = PropertiesReader.class.getClassLoader();
        Properties property = new Properties();
        try (InputStream input = classLoader
                .getResourceAsStream(propertiesFile)) {
            if (input == null) {
                throw new FileNotFoundException(
                        "Невозможно найти файл config.properties");
            }

            property.load(input);

        } catch (IOException ex) {
            LOG.error("Ошибка чтения файла config.properties.");
        }
        return property.getProperty(key);
    }
}
