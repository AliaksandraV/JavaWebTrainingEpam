package by.training.composite.controller.action;

import by.training.composite.controller.MainMenuController;
import by.training.composite.dao.FileException;
import by.training.composite.entity.ComponentException;
import by.training.composite.service.action.SortWordsService;
import by.training.composite.view.action.SortWords;
import org.apache.log4j.Logger;

/**
 * SortWordsMenuController.
 */
public class SortWordsMenuController extends BaseActionMenuController {
    /**
     * logger initialisation.
     */
    private static final Logger LOG =
            Logger.getLogger(SortWordsMenuController.class);
    /**
     * view.
     */
    private final SortWords view = new SortWords();
    /**
     * handler for menu actions.
     */
    private final SortWordsService service = new SortWordsService();

    /**
     * constructor.
     *
     * @param mainMenuController controller
     */
    public SortWordsMenuController(
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
