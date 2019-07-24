package by.training.taxistation.сontroller.actions;

import by.training.taxistation.entity.car.Car;
import by.training.taxistation.service.CarService;
import by.training.taxistation.service.CarServiceImpl;
import by.training.taxistation.view.CarListView;
import by.training.taxistation.сontroller.MainMenuController;

import java.util.ArrayList;
import java.util.List;

public class CarsListController extends BaseActionController {

    private final CarListView carListView = new CarListView();
    private final CarService carService = new CarServiceImpl();

    public CarsListController(MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    //TODO переделать, этот товарищ должен с сервисом общаться а не со станцией.
    // НАВЕРНОЕ тут правильно передавать данные во вью
    @Override
    public void internalRun() {
       List<Car> cars = new ArrayList<>();
       cars.addAll(carService.read());  //TODO тут вылетает NullPointerException
        carListView.print(cars);
    }
}
