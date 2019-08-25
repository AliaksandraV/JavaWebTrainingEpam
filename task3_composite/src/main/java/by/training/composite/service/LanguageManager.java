package by.training.composite.service;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Language Manager Singleton
 * defines the language of the application.
 */
public enum LanguageManager {
    /**
     * instanse of Language Manager.
     */
    INSTANCE;
    /**
     * resource Bundle.
     */
    private ResourceBundle resourceBundle;
    /**
     * property for resource Bundle.
     */
    private final String resourceName = "property.text";

    /**
     * Set english as a default language.
     */
    LanguageManager() {
        Locale engLocale = new Locale("en", "US");
        resourceBundle = ResourceBundle.getBundle(
                resourceName, engLocale);
    }

    /**
     * Change application language.
     *
     * @param locale language locale
     */
    public void changeResource(final Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    /**
     * Return string in application language.
     *
     * @param key key.
     * @return string in application language
     */
    public String getString(final String key) {
        return resourceBundle.getString(key);
    }
}
