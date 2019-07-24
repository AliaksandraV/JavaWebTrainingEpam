package by.training.taxistation.сontroller.actions;

import by.training.taxistation.service.MenuHandlerService;
import by.training.taxistation.view.CarsCostView;
import by.training.taxistation.сontroller.MainMenuController;

public class CarsCostController extends BaseActionController {

    private final CarsCostView carsCostView = new CarsCostView();
    private final MenuHandlerService menuHandler = new MenuHandlerService();

    public CarsCostController(MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    @Override
    public void internalRun() {
        carsCostView.print(menuHandler.carsCost());
    }
}
