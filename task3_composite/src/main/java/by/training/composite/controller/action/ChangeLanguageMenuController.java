package by.training.composite.controller.action;

import by.training.composite.service.LanguageManager;
import by.training.composite.controller.InputFormatException;
import by.training.composite.controller.MainMenuController;
import by.training.composite.controller.MenuChoiceException;
import by.training.composite.service.action.ChangeLanguageService;
import by.training.composite.view.action.ChangeLanguage;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Change language menu controller.
 */
public class ChangeLanguageMenuController extends BaseActionMenuController {
    /**
     * logger initialisation.
     */
    private static final Logger LOG =
            Logger.getLogger(ChangeLanguageMenuController.class);
    /**
     * view for print car cost.
     */
    private final ChangeLanguage view = new ChangeLanguage();
    /**
     * menu controllers map.
     */
    private Map<Integer, ChangeLanguageService> menuMap = new HashMap<>();
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
     * constructor.
     *
     * @param mainMenuController controller
     */
    public ChangeLanguageMenuController(
            final MainMenuController mainMenuController) {
        super(mainMenuController);
        initMenuMap();
    }

    /**
     * menu controllers map initialisation.
     */
    private void initMenuMap() {
        menuMap.put(MENU_INDEX_1, new ChangeLanguageService(MENU_INDEX_1));
        menuMap.put(MENU_INDEX_2, new ChangeLanguageService(MENU_INDEX_2));
        menuMap.put(MENU_INDEX_3, new ChangeLanguageService(MENU_INDEX_3));
    }

    /**
     * run action.
     */
    @Override
    public void internalRun() {
        view.print();
        int menuSelectedIndex = inputToInt();
        ChangeLanguageService service = menuMap.get(menuSelectedIndex);
        try {
            service.setLanguage();
        } catch (MenuChoiceException e) {
            LOG.error("Выбран несуществующий пункт меню.");
        }
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
            LOG.error(
                    LanguageManager.INSTANCE.getString("menu_item_not_exist"));
            System.out.println(
                    LanguageManager.INSTANCE.getString("repeat_input"));
            System.out.print("");
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

        int input = Integer.parseInt(chosenIndex);

        if (!menuMap.containsKey(input)) {
            throw new MenuChoiceException();
        }
    }
}
