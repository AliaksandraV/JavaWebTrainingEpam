package by.training.composite.service;

import by.training.composite.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordsByLengthInSentenceSort {

    public Text sort(final Component text) throws ComponentException {
        Comparator<Component> comparator = Comparator.comparingInt(o -> ((Composite) o).getImmutableComponents().size());

        List<Component> paragraphs = new ArrayList<>();

        ((Text)text).getImmutableComponents().forEach(paragraph -> {
            List<Component> components = getSortedComponents(comparator, ((Composite) paragraph));
            paragraphs.add(new Paragraph(components));
        });

        return new Text(paragraphs);
    }

    private static List<Component> getSortedComponents(final Comparator<Component> comparator, final Component composite) {
        return ((Composite)composite).getImmutableComponents()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
