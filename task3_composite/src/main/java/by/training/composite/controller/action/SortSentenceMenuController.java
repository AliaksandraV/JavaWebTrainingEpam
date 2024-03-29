package by.training.composite.controller.action;

import by.training.composite.controller.MainMenuController;
import by.training.composite.dao.FileException;
import by.training.composite.entity.ComponentException;
import by.training.composite.service.action.SortSentenceService;
import by.training.composite.view.action.SortSentence;
import org.apache.log4j.Logger;

/**
 * SortSentenceMenuController.
 */
public class SortSentenceMenuController extends BaseActionMenuController {
    /**
     * logger initialisation.
     */
    private static final Logger LOG =
            Logger.getLogger(SortSentenceMenuController.class);
    /**
     * view.
     */
    private final SortSentence view = new SortSentence();
    /**
     * handler for menu actions.
     */
    private final SortSentenceService service = new SortSentenceService();

    /**
     * constructor.
     *
     * @param mainMenuController controller
     */
    public SortSentenceMenuController(
            final MainMenuController mainMenuController) {
        super(mainMenuController);
    }

    /**
     * run action.
     */
    @Override
    public void internalRun() {
        try {
            view.print(service.sort());
        } catch (FileException | ComponentException e) {
            LOG.error(e);
        }
    }
}
