package by.training.taxistation.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private PropertiesUtil() {

    }

    public static String getProperty(String key) {
        String name = "config.properties";
        ClassLoader classLoader = PropertiesUtil.class.getClassLoader();
        try (InputStream input = classLoader.getResourceAsStream(name)) {
            Properties prop = new Properties();

            if (input == null) {
                throw new FileNotFoundException("Невозможно найти файл config.properties");
            }

            prop.load(input);

            return prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Ошибка чтения файла config.properties.");
        }
    }
}