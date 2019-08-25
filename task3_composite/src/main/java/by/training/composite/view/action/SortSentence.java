package by.training.composite.view.action;

import by.training.composite.service.LanguageManager;

public class SortSentence {

    public void print(final String text) {
        System.out.println(LanguageManager.INSTANCE.getString("sort_sentence_label") + text);
    }
}
