package by.training.composite.view;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public abstract class BaseMenuView {
    public ResourceBundle resourceBundle;
    public Locale engLocale = new Locale("en", "US");
    public Locale ruLocale = new Locale("ru", "RU");
    public Locale byLocale = new Locale("be", "BY");


    protected BaseMenuView() {
        resourceBundle = ResourceBundle.getBundle("property.text", engLocale);
    }

    /**
     * read input from console.
     *
     * @return input
     */
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void setENlanguage() {
        resourceBundle = ResourceBundle.getBundle("property.text", engLocale);
    }

    public void setRUlanguage() {
        resourceBundle = ResourceBundle.getBundle("property.text", ruLocale);

    }

    public void setBYlanguage() {
        resourceBundle = ResourceBundle.getBundle("property.text", byLocale);
    }
}
