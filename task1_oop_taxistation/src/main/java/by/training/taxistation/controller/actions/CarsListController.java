package by.training.taxistation.controller.actions;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.CarService;
import by.training.taxistation.service.CarServiceImpl;
import by.training.taxistation.view.CarListView;
import by.training.taxistation.controller.MainMenuController;

import java.util.ArrayList;
import java.util.List;

public class CarsListController extends BaseActionController {
    /**
     * view initialisation.
     */
    private final CarListView carListView = new CarListView();
    /**
     * service initialisation.
     */
    private final CarService carService = new CarServiceImpl();

    /**
     * constructor.
     * @param mainMenuController main menu controller
     */
    public CarsListController(final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    /**
     * action run.
     */
    @Override
    public void internalRun() {
        List<Car> cars = new ArrayList<>();
        cars.addAll(carService.read());
        carListView.print(cars);
    }
}
