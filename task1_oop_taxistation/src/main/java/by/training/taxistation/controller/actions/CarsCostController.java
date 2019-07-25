package by.training.taxistation.controller.actions;

import by.training.taxistation.service.MenuHandlerService;
import by.training.taxistation.view.CarsCostView;
import by.training.taxistation.controller.MainMenuController;

public class CarsCostController extends BaseActionController {
    /**
     * view for print car cost.
     */
    private final CarsCostView carsCostView = new CarsCostView();
    /**
     * handler for menu actions.
     */
    private final MenuHandlerService menuHandler = new MenuHandlerService();

    /**
     * constructor.
     * @param mainMenuController  controller
     */
    public CarsCostController(final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    /**
     * run action.
     */
    @Override
    public void internalRun() {
        carsCostView.print(menuHandler.carsCost());
    }
}
