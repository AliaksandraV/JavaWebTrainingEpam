package by.training.composite.view;

import by.training.composite.service.LanguageManager;

public class MainMenu extends BaseMenu {

    /**
     * print menu.
     */
//    public void print() {
//        System.out.print(resourceBundle.getString("main_menu"));
//    }
    public void print() {
        System.out.print(LanguageManager.INSTANCE.getString("main_menu"));
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
