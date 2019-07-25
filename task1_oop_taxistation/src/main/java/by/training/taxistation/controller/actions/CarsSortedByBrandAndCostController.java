package by.training.taxistation.controller.actions;

import by.training.taxistation.service.MenuHandlerService;
import by.training.taxistation.view.CarsSortedByBrandView;
import by.training.taxistation.controller.MainMenuController;

public class CarsSortedByBrandAndCostController extends BaseActionController {
    /**
     * view initialisation.
     */
    private final CarsSortedByBrandView view = new CarsSortedByBrandView();
    /**
     * handler initialisation.
     */
    private final MenuHandlerService menuHandler = new MenuHandlerService();

    /**
     * constructor.
     * @param mainMenuController main menu controller
     */
    public CarsSortedByBrandAndCostController(
            final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    /**
     * action run.
     */
    @Override
    public void internalRun() {
        view.print(menuHandler.carsSortedByBrandAndCost());
    }
}
