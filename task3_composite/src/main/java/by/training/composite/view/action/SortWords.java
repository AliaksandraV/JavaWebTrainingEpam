package by.training.composite.view.action;

import by.training.composite.service.LanguageManager;

public class SortWords {

    public void print(final String text) {
        System.out.println(LanguageManager.INSTANCE.getString("sort_words_label") + text);
    }
}
