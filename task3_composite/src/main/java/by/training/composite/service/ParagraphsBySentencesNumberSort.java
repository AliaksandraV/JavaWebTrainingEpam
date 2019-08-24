package by.training.composite.service;

import by.training.composite.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphsBySentencesNumberSort implements Sorting {

    @Override
    public Text sort(final Component text) throws ComponentException {
        Comparator<Component> comparator = Comparator.comparingInt(o -> ((Composite) o).getImmutableComponents().size());

        return new Text(getSortedComponents(comparator,  text));
    }

    private static List<Component> getSortedComponents(final Comparator<Component> comparator, final Component composite) {
        return ((Composite)composite).getImmutableComponents()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

}
