package by.training.taxistation.controller.actions;

import by.training.taxistation.controller.BaseController;
import by.training.taxistation.controller.MainMenuController;

import java.util.Arrays;

public abstract class BaseActionController extends BaseController {
    /**
     * main Menu Controller.
     */
    private MainMenuController mainMenuController;

    /**
     * constructor.
     * @param newMainMenuController main Menu Controller
     */
    public BaseActionController(
            final MainMenuController newMainMenuController) {
        this.mainMenuController = newMainMenuController;
    }

    /**
     * dialog for continue program.
     */
    public void showContinueDialog() {
        System.out.println("\nПродолжить? (д/н): ");
        String input = readInput();
        boolean validInput = validateContinueInput(input);
        if (!validInput) {
            System.out.println("Неверный ввод.");
            showContinueDialog();
        } else if ("y".equals(input) || "д".equals(input)) {
            showNext();
        } else {
            System.exit(0);
        }
    }

    /**
     * validate Continue Input.
     * @param input input
     * @return true if input valide
     */
    public static boolean validateContinueInput(final String input) {
        return Arrays.asList("д", "н", "y", "n").contains(input);
    }

    /**
     * menu run.
     */
    @Override
    public void run() {
        internalRun();
        showContinueDialog();
    }

    /**
     * run for inheritor.
     */
    public abstract void internalRun();

    /**
     * what to show after end of action work.
     */
    public void showNext() {
        mainMenuController.run();
    }

}
