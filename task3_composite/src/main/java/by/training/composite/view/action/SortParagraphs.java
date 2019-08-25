package by.training.composite.view.action;

import by.training.composite.service.LanguageManager;

/**
 * Sort Paragraphs view.
 */
public class SortParagraphs {

    /**
     * @param text for printing
     */
    public void print(final String text) {
        System.out.println(
                LanguageManager
                        .INSTANCE
                        .getString("sort_paragraph_label") + text);
    }
}
