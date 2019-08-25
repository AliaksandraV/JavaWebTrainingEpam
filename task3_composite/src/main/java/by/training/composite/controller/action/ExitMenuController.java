package by.training.composite.controller.action;

import by.training.composite.controller.BaseMenuController;

/**
 * Exit Menu Controller.
 */
public class ExitMenuController extends BaseMenuController {
    /**
     * exit from application.
     */
    @Override
    public void run() {
        System.exit(0);
    }
}
