package by.training.taxistation.controller.actions;

import by.training.taxistation.service.MenuHandlerService;
import by.training.taxistation.view.SearchCarsByLoadCapacityView;
import by.training.taxistation.controller.InputFormatException;
import by.training.taxistation.controller.MainMenuController;

import java.util.List;

public class SearchCarsByLoadCapacityController extends BaseActionController {
    /**
     * view initialisation.
     */
    private final SearchCarsByLoadCapacityView view
            = new SearchCarsByLoadCapacityView();
    /**
     * handler initialisation.
     */
    private final MenuHandlerService menuHandler = new MenuHandlerService();

    /**
     * Constructor.
     * @param mainMenuController main menu controller
     */
    public SearchCarsByLoadCapacityController(
            final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    /**
     * action run.
     */
    @Override
    public void internalRun() {
        int from;
        int to;
        view.printLabel();
        from = getIntInput(view.readFromInput());
        to = getIntInput(view.readToInput());
        if (from > to) {
            System.out.println(
                    "Значение <от> не может быть больше значения <до>.");
        } else {
            List foundPassengerCars = menuHandler
                    .searchCarsByCargoCapacity(from, to);
            if (foundPassengerCars.isEmpty()) {
                System.out.println(
                        "В указанном диапазоне автомобилей не найдено.");
            } else {
                view.print(foundPassengerCars);
            }
        }
    }

    /**
     * wraps input in int.
     * @param input input
     * @return input
     */
    private int getIntInput(final String input) {
        try {
            validateInt(input);
        } catch (InputFormatException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(input);
    }

    /**
     * validate input.
     * @param input input
     * @throws InputFormatException if input invalid
     */
    @Override
    protected void validateInt(final String input) throws InputFormatException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new InputFormatException();
        }
    }

}

