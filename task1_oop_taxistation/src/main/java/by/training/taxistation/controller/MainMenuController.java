package by.training.taxistation.controller;

import by.training.taxistation.controller.actions.CarsCostController;
import by.training.taxistation.controller.actions.CarsListController;
import by.training.taxistation.controller.actions.CarsSortedByBrandAndCostController;
import by.training.taxistation.controller.actions.CarsSortedByBrandController;
import by.training.taxistation.controller.actions.SearchCarsByPassengerCapacityController;
import by.training.taxistation.controller.actions.SearchCarsByLoadCapacityController;
import by.training.taxistation.controller.actions.ExitController;
import by.training.taxistation.view.MainMenuViewView;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MainMenuController extends BaseController {
    /**
     * view initialisation.
     */
    private MainMenuViewView view;
    /**
     * menu controllers map.
     */
    private Map<Integer, BaseController> controllerMap = new HashMap<>();
    /**
     * logger initialisation.
     */
    private static final org.apache.log4j.Logger LOG
            = Logger.getLogger(MainMenuController.class);
    /**
     * menu index.
     */
    private static final int FIRST_MENU_INDEX = 1;
    /**
     * menu index.
     */
    private static final int SECOND_MENU_INDEX = 2;
    /**
     * menu index.
     */
    private static final int THIRD_MENU_INDEX = 3;
    /**
     * menu index.
     */
    private static final int FOURTH_MENU_INDEX = 4;
    /**
     * menu index.
     */
    private static final int FIFTH_MENU_INDEX = 5;
    /**
     * menu index.
     */
    private static final int SIXTH_MENU_INDEX = 6;
    /**
     * menu index.
     */
    private static final int EIGHTH_MENU_INDEX = 8;

    /**
     * constructor.
     */
    public MainMenuController() {
        this.view = new MainMenuViewView();
        initControllerMap();
    }

    /**
     * menu controllers map initialisation.
     */
    private void initControllerMap() {
        controllerMap.put(
                FIRST_MENU_INDEX, new CarsListController(this));
        controllerMap.put(SECOND_MENU_INDEX, new CarsCostController(this));
        controllerMap.put(
                THIRD_MENU_INDEX, new CarsSortedByBrandController(this));
        controllerMap.put(
                FOURTH_MENU_INDEX, new CarsSortedByBrandAndCostController(this));
        controllerMap.put(FIFTH_MENU_INDEX,
                new SearchCarsByPassengerCapacityController(this));
        controllerMap.put(SIXTH_MENU_INDEX,
                new SearchCarsByLoadCapacityController(this));
        controllerMap.put(EIGHTH_MENU_INDEX, new ExitController());
    }

    /**
     * run menu.
     */
    @Override
    public void run() {
        view.print();
        int menuSelectedIndex = inputToInt();
        BaseController baseController = controllerMap.get(menuSelectedIndex);
        baseController.run();
    }
    /**
     * wraps input in int.
     * @return input
     */
    private Integer inputToInt() {
        String input = view.readSelectedItemIndex();
        try {
            validateMainMenuInput(input);
        } catch (MenuChoiceException e) {
            LOG.error("Выбран несуществующий пункт меню.");
            System.out.println("Повторите ввод: ");
            return inputToInt();
        }
        return Integer.parseInt(input);
    }

    /**
     * validate input.
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

        if (!controllerMap.containsKey(input)) {
            throw new MenuChoiceException();
        }
    }

}
