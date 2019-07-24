package by.training.taxistation.сontroller.actions;

import by.training.taxistation.service.MenuHandlerService;
import by.training.taxistation.view.CarsSortedByBrandView;
import by.training.taxistation.сontroller.MainMenuController;

public class CarsSortedByBrandAndCostController extends BaseActionController {

    private final CarsSortedByBrandView view = new CarsSortedByBrandView();
    private final MenuHandlerService menuHandler = new MenuHandlerService();

    public CarsSortedByBrandAndCostController(final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    @Override
    public void internalRun() {
        view.print(menuHandler.carsSortedByBrandAndCost());
    }
}
