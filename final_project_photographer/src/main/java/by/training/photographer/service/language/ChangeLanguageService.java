package by.training.photographer.service.language;

import java.util.Locale;

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
     * one of choice.
     */
    private static final int INT = 3;
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


    public void setLanguage() throws Exception {
        switch (languageChoise) {
            case 1:
                setRUlanguage();
                break;
            case 2:
                setENlanguage();
                break;
            default:
                throw new Exception();
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


}
