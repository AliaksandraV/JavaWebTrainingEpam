package by.training.composite;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale rus = new Locale("ru", "RU");
        Locale current = Locale.getDefault();
        Locale.setDefault(Locale.CANADA);

        current.getCountry(); // код региона
        current.getDisplayCountry(); // название региона
        current.getLanguage(); // код языка региона
        current.getDisplayLanguage(); // название языка региона
    }
}
