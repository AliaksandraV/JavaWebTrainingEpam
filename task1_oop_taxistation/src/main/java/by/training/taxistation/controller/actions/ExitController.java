package by.training.taxistation.controller.actions;

import by.training.taxistation.controller.BaseController;

public class ExitController extends BaseController {
    /**
     * exit from application.
     */
    @Override
    public void run() {
        System.exit(0);
    }
}
