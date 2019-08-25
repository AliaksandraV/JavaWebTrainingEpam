package by.training.composite.service.action;

import by.training.composite.service.LanguageManager;
import by.training.composite.controller.MenuChoiceException;

import java.util.Locale;

/**
 * Change Language Service.
 */
public class ChangeLanguageService {
    /**
     * english locale.
     */
    private Locale engLocale = new Locale("en", "US");
    /**
     * russian locale.
     */
    private Locale ruLocale = new Locale("ru", "RU");
    /**
     * belorussian locale.
     */
    private Locale byLocale = new Locale("be", "BY");
    /**
     * chosen language.
     */
    private int languageChoise;

    /**
     * constructor for setting language.
     *
     * @param language chosen language
     */
    public ChangeLanguageService(final int language) {
        languageChoise = language;
    }

    /**
     * set application language.
     *
     * @throws MenuChoiceException if no case
     */
    public void setLanguage() throws MenuChoiceException {
        switch (languageChoise) {
            case 1:
                setRUlanguage();
                break;
            case 2:
                setBYlanguage();
                break;
            case 3:
                setENlanguage();
                break;
            default:
                throw new MenuChoiceException();
        }
    }

    /**
     * set english language.
     */
    private void setENlanguage() {
        LanguageManager.INSTANCE.changeResource(engLocale);
    }

    /**
     * set russian language.
     */
    private void setRUlanguage() {
        LanguageManager.INSTANCE.changeResource(ruLocale);

    }

    /**
     * set belorussian language.
     */
    private void setBYlanguage() {
        LanguageManager.INSTANCE.changeResource(byLocale);
    }
}
