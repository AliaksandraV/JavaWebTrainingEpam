package by.training.taxistation.сontroller.actions;

import by.training.taxistation.сontroller.BaseController;
import by.training.taxistation.сontroller.MainMenuController;

import java.util.Arrays;

public abstract class BaseActionController extends BaseController {

    private MainMenuController mainMenuController;

    public BaseActionController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    public void showContinueDialog() {
        System.out.println("\nПродолжить? (д/н): ");
        String input = readInput();
        //TODO подумать что делать с валидацией не очень что она в одном месте
        boolean validInput = validateContinueInput(input);
        if (!validInput) {
            System.out.println("Неверный ввод."); //TODO вместо этого exeption?
            showContinueDialog();
        } else if ("y".equals(input) || "д".equals(input)) {
            showNext();
        } else {
            System.exit(0);
        }
    }

    public static boolean validateContinueInput(String input) {
        return Arrays.asList("д", "н", "y", "n").contains(input);
    }

    @Override
    public void run() {
        internalRun();
        showContinueDialog();
    }

    public abstract void internalRun();

    public void showNext() {
        mainMenuController.run();
    }

}