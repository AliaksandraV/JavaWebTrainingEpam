package by.training.composite.controller.action;

import by.training.composite.service.LanguageManager;
import by.training.composite.controller.BaseMenuController;
import by.training.composite.controller.MainMenuController;

import java.util.Arrays;

/**
 * Base class for action controllers.
 */
public abstract class BaseActionMenuController extends BaseMenuController {
    /**
     * main Menu Controller.
     */
    private MainMenuController mainMenuController;

    /**
     * constructor.
     *
     * @param newMainMenuController main Menu Controller
     */
    BaseActionMenuController(
            final MainMenuController newMainMenuController) {
        this.mainMenuController = newMainMenuController;
    }

    /**
     * dialog for continue program.
     */
    private void showContinueDialog() {
        System.out.println(
                LanguageManager.INSTANCE.getString("continue_label"));
        String input = readInput();
        boolean validInput = validateContinueInput(input);
        if (!validInput) {
            System.out.println(
                    LanguageManager.INSTANCE.getString("invalid_input"));
            showContinueDialog();
        } else if ("y".equals(input) || "д".equals(input)) {
            showNext();
        } else {
            System.exit(0);
        }
    }

    /**
     * validate Continue Input.
     *
     * @param input input
     * @return true if input valide
     */
    private static boolean validateContinueInput(final String input) {
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
    private void showNext() {
        mainMenuController.run();
    }
}
