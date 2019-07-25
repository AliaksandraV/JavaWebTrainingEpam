package by.training.taxistation;

import by.training.taxistation.repository.factory.TaxiStationFactory;
import by.training.taxistation.repository.factory.TaxiStationFactoryImpl;
import by.training.taxistation.controller.MainMenuController;

public final class Main {

    private Main() {
    }

    /**
     * Start point of the program.
     *
     * @param args command line values
     */
    public static void main(final String[] args) {
        TaxiStationFactory factory = new TaxiStationFactoryImpl();
        factory.fill();
        MainMenuController menuController = new MainMenuController();
        menuController.run();
    }
}
