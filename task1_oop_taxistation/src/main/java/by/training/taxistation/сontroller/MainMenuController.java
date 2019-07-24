package by.training.taxistation.сontroller;

import by.training.taxistation.view.MainMenuView;
import by.training.taxistation.сontroller.actions.*;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MainMenuController extends BaseController  {

    private MainMenuView view;
    private Map<Integer, BaseController> controllerMap = new HashMap<>();
    private static final org.apache.log4j.Logger log = Logger.getLogger(MainMenuController.class);

    public MainMenuController() {
        this.view = new MainMenuView();
        initControllerMap();
    }

    private void initControllerMap() {
        controllerMap.put(1, new CarsListController(this));
        controllerMap.put(2, new CarsCostController(this));
        controllerMap.put(3, new CarsSortedByBrandController(this));
        controllerMap.put(4, new CarsSortedByBrandAndCostController(this));
        controllerMap.put(5, new SearchCarsByPassengerCapacityController(this));
        controllerMap.put(6, new SearchCarsByLoadCapacityController(this));
//        controllerMap.put(7, new AddCarController(this));
//        controllerMap.put(8, new ExitController());
    }

    @Override
    public void run() {
        view.print();
        int menuSelectedIndex = inputToInt();
        BaseController baseController = controllerMap.get(menuSelectedIndex);
        baseController.run();
    }

    private Integer inputToInt() {
        String input = view.readSelectedItemIndex();
        try {
            validateMainMenuInput(input);
        } catch (MenuChoiceException e) {
            log.error("Выбран несуществующий пункт меню.");
            System.out.println("Повторите ввод: ");
            return inputToInt();
        }
        return Integer.parseInt(input);
    }


    private void validateMainMenuInput(String chosenIndex) throws MenuChoiceException {
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
