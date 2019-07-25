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
    private final int firstMenuIndex = 1;
    /**
     * menu index.
     */
    private final int secondMenuIndex = 2;
    /**
     * menu index.
     */
    private final int thirdMenuIndex = 3;
    /**
     * menu index.
     */
    private final int fourthMenuIndex = 4;
    /**
     * menu index.
     */
    private final int fifthMenuIndex = 5;
    /**
     * menu index.
     */
    private final int sixthMenuIndex = 6;
    /**
     * menu index.
     */
    private final int eighthMenuIndex = 8;

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
                firstMenuIndex, new CarsListController(this));
        controllerMap.put(secondMenuIndex, new CarsCostController(this));
        controllerMap.put(
                thirdMenuIndex, new CarsSortedByBrandController(this));
        controllerMap.put(
                fourthMenuIndex, new CarsSortedByBrandAndCostController(this));
        controllerMap.put(fifthMenuIndex,
                new SearchCarsByPassengerCapacityController(this));
        controllerMap.put(sixthMenuIndex,
                new SearchCarsByLoadCapacityController(this));
//        controllerMap.put(7, new AddCarController(this));
        controllerMap.put(eighthMenuIndex, new ExitController());
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
