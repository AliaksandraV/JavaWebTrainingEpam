package by.training.composite.controller.action;

import by.training.composite.controller.MainMenuController;
import by.training.composite.dao.FileException;
import by.training.composite.entity.ComponentException;
import by.training.composite.service.action.SortParagraphsService;
import by.training.composite.view.action.SortParagraphs;
import org.apache.log4j.Logger;

/**
 * SortParagraphsMenuController.
 */
public class SortParagraphsMenuController extends BaseActionMenuController {
    /**
     * logger initialisation.
     */
    private static final Logger LOG =
            Logger.getLogger(SortParagraphsMenuController.class);
    /**
     * view.
     */
    private final SortParagraphs view = new SortParagraphs();
    /**
     * handler for menu actions.
     */
    private final SortParagraphsService service = new SortParagraphsService();

    /**
     * constructor.
     *
     * @param mainMenuController controller
     */
    public SortParagraphsMenuController(
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
