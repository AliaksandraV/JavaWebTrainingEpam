package by.training.composite.controller.action;

import by.training.composite.controller.MainMenuController;
import by.training.composite.dao.FileException;
import by.training.composite.service.action.PrintTextFromFileService;
import by.training.composite.view.action.PrintTextFromFile;
import org.apache.log4j.Logger;

/**
 * Print Text From File Menu Controller.
 */
public class PrintTextFromFileMenuController extends BaseActionMenuController {
    /**
     * logger initialisation.
     */
    private static final Logger LOG =
            Logger.getLogger(PrintTextFromFileMenuController.class);
    /**
     * view for print car cost.
     */
    private final PrintTextFromFile print = new PrintTextFromFile();
    /**
     * handler for menu actions.
     */
    private final PrintTextFromFileService printTextService =
            new PrintTextFromFileService();

    /**
     * constructor.
     *
     * @param mainMenuController controller
     */
    public PrintTextFromFileMenuController(
            final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    /**
     * run action.
     */
    @Override
    public void internalRun() {
        try {
            print.print(printTextService.readText());
        } catch (FileException e) {
            LOG.error(e);
        }
    }
}
