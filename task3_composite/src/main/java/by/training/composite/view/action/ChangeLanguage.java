package by.training.composite.view.action;

import by.training.composite.service.LanguageManager;
import by.training.composite.view.BaseMenu;

/**
 * view for change language menu.
 */
public class ChangeLanguage extends BaseMenu {
    /**
     * print menu.
     */
    public void print() {
        System.out.println(
                LanguageManager.INSTANCE.getString("language_choice"));
    }

    /**
     * read input in console.
     *
     * @return input
     */
    public String readSelectedItemIndex() {
        return readInput();
    }

}
