package by.training.composite.controller;

import by.training.composite.service.LanguageManager;
import by.training.composite.controller.action.*;
import by.training.composite.view.MainMenu;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MainMenuMenuController extends BaseMenuController {
    /**
     * view initialisation.
     */
    private MainMenu view;
    /**
     * menu controllers map.
     */
    private Map<Integer, BaseMenuController> menuMap = new HashMap<>();
    /**
     * logger initialisation.
     */
    private static final org.apache.log4j.Logger LOG
            = Logger.getLogger(MainMenuMenuController.class);
    /**
     * menu index.
     */
    private static final int MENU_INDEX_1 = 1;
    /**
     * menu index.
     */
    private static final int MENU_INDEX_2 = 2;
    /**
     * menu index.
     */
    private static final int MENU_INDEX_3 = 3;
    /**
     * menu index.
     */
    private static final int MENU_INDEX_4 = 4;
    /**
     * menu index.
     */
    private static final int MENU_INDEX_5 = 5;
    /**
     * menu index.
     */
    private static final int MENU_INDEX_6 = 6;

    /**
     * constructor.
     */
    public MainMenuMenuController() {
        view = new MainMenu();
        initMenuMap();
    }

    /**
     * menu controllers map initialisation.
     */
    private void initMenuMap() {
        menuMap.put(MENU_INDEX_1, new PrintTextFromFileMenuController(this));
        menuMap.put(MENU_INDEX_2, new SortParagraphsMenuController(this));
        menuMap.put(MENU_INDEX_3, new SortSentenceMenuController(this));
        menuMap.put(MENU_INDEX_4, new SortWordsMenuController(this));
        menuMap.put(MENU_INDEX_5, new ChangeLanguageMenuController(this));
        menuMap.put(MENU_INDEX_6, new ExitMenuController());
    }

    /**
     * run menu.
     */
    @Override
    public void run() {
        view.print();
        int menuSelectedIndex = inputToInt();
        BaseMenuController baseMenuController = menuMap.get(menuSelectedIndex);
        baseMenuController.run();
    }

    /**
     * wraps input in int.
     *
     * @return input
     */
    private Integer inputToInt() {
        String input = view.readSelectedItemIndex();
        try {
            validateMainMenuInput(input);
        } catch (MenuChoiceException e) {
            LOG.error(LanguageManager.INSTANCE.getString("menu_item_not_exist"));
            System.out.println(LanguageManager.INSTANCE.getString("repeat_input"));
            return inputToInt();
        }
        return Integer.parseInt(input);
    }

    /**
     * validate input.
     *
     * @param chosenIndex input
     * @throws MenuChoiceException if input invalid
     */
    private void validateMainMenuInput(
            final String chosenIndex) throws MenuChoiceException {
        try {
            validateInt(chosenIndex);
        } catch (InputFormatException exception) {
            throw new MenuChoiceException();
        }

        int input = Integer.valueOf(chosenIndex);

        if (!menuMap.containsKey(input)) {
            throw new MenuChoiceException();
        }
    }

}