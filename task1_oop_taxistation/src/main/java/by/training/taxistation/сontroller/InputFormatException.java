package by.training.taxistation.сontroller;

public class InputFormatException extends Exception {

    public InputFormatException() {
        this("Введены данные неверного формата.");
    }

    public InputFormatException(String message) {
        super(message);
    }
}
