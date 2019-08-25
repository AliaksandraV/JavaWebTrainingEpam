package by.training.composite.view.action;

import by.training.composite.service.LanguageManager;
import by.training.composite.view.BaseMenu;

public class PrintTextFromFile extends BaseMenu {
    /**
     * print text.
     * @param text text
     */
//    public void print(final String text) {
//        System.out.println(resourceBundle.getString("print_text_label") + text);
//    }
    public void print(final String text) {
        System.out.println(LanguageManager.INSTANCE.getString("print_text_label") + text);
    }
}
