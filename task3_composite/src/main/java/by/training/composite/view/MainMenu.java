package by.training.composite.view;

public class MainMenu extends BaseMenuView {

    /**
     * print menu.
     */
    public void print() {
        System.out.print(resourceBundle.getString("main_menu"));
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
