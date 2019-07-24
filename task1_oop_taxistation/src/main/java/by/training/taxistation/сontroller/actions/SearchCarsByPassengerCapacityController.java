package by.training.taxistation.сontroller.actions;

import by.training.taxistation.service.MenuHandlerService;
import by.training.taxistation.view.SearchCarsByPassengerCapacityView;
import by.training.taxistation.сontroller.InputFormatException;
import by.training.taxistation.сontroller.MainMenuController;

import java.util.List;

public class SearchCarsByPassengerCapacityController extends BaseActionController {

    private final SearchCarsByPassengerCapacityView view = new SearchCarsByPassengerCapacityView();
    private final MenuHandlerService menuHandler = new MenuHandlerService();

    public SearchCarsByPassengerCapacityController(final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    @Override
    public void internalRun() {
        int from;
        int to;
        view.printLabel();
        from = getIntInput(view.readFromInput());
        to = getIntInput(view.readToInput());
        if (from > to) {
            System.out.println("Значение <от> не может быть больше значения <до>.");
        } else {
            List foundPassengerCars = menuHandler.searchCarsByPassengerCapacity(from, to);
            if (foundPassengerCars.isEmpty()) {
                System.out.println("В указанном диапазоне автомобилей не найдено.");
            } else {
                view.print(foundPassengerCars);
            }
        }
    }

    private int getIntInput(String input) {
        try {
            validateInt(input);
        } catch (InputFormatException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(input);
    }

    protected void validateInt(String input) throws InputFormatException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new InputFormatException();
        }
    }
}
