package by.training.taxistation.сontroller;

public class MenuChoiceException extends InputFormatException {

    public MenuChoiceException() {
        super("Выбран несуществующий пункт меню.");
    }

    public MenuChoiceException(String message) {
        super(message);
    }
}

