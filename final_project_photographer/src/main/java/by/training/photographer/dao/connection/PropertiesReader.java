package by.training.photographer.dao.connection;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    /**
     * Logger initialisation.
     */
    private static final Logger LOG = Logger.getLogger(PropertiesReader.class);

    /**
     * Source property file name.
     */
    private String propertiesFile;

    /**
     * Constructor.
     */
    public PropertiesReader(final String newPropertiesFile) {
        propertiesFile = newPropertiesFile;
    }

    /**
     * Take the property value by a key.
     *
     * @param key - property name
     * @return property value
     */
    public String takeProperty(final String key) {
        ClassLoader classLoader = PropertiesReader.class.getClassLoader();
        Properties property = new Properties();

        try (InputStream input = classLoader.getResourceAsStream(propertiesFile)) {
            if (input == null) {
                throw new FileNotFoundException("Невозможно найти файл " + propertiesFile);
            }
            property.load(input);
        } catch (IOException ex) {
            LOG.error("Ошибка чтения файла " + propertiesFile);
        }

        return property.getProperty(key);
    }
}
