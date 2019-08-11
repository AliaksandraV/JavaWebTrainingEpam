package by.training.matrix.service;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesService {
    /**
     * logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(PropertiesService.class);

    /**
     * constructor.
     */
    private PropertiesService() {

    }

    /**
     * configurations properties.
     *
     * @param valueFromPropertiesFile value From Properties File
     * @return properties
     */
    public static String takeProperty(final String valueFromPropertiesFile) {
        String name = "config.properties";
        ClassLoader classLoader = PropertiesService.class.getClassLoader();
        Properties prop = new Properties();
        try (InputStream input = classLoader.getResourceAsStream(name)) {
            if (input == null) {
                throw new FileNotFoundException(
                        "Невозможно найти файл config.properties");
            }

            prop.load(input);

        } catch (IOException ex) {
            LOG.error("Ошибка чтения файла config.properties.");
        }
        return prop.getProperty(valueFromPropertiesFile);
    }
}
