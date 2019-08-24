package by.training.composite;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceBundleManager {
    INSTANCE;

    private ResourceBundle resourceBundle;
    private final String resourceName = "property.text";

    ResourceBundleManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}