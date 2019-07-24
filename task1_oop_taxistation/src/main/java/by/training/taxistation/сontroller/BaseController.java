package by.training.taxistation.сontroller;

import by.training.taxistation.repository.factory.TaxiStationFactory;

import java.util.Scanner;

public abstract class BaseController {

    public abstract void run();

    protected String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    protected void validateInt(String input) throws InputFormatException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new InputFormatException();
        }
    }

}
