package by.training.composite.service;

import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Composite;
import by.training.composite.entity.Text;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Paragraphs By Sentences Number Sort.
 */
public class ParagraphsBySentencesNumberSort implements Sorting {

    /**
     * sort.
     *
     * @param text text for sorting
     * @return sorted text
     */
    @Override
    public Text sort(final Component text) {
        Comparator<Component> comparator =
                Comparator.
                        comparingInt(o -> ((Composite) o)
                                .getImmutableComponents()
                                .size());

        return new Text(getSortedComponents(comparator, text));
    }

    /**
     * sort component on their level.
     * @param comparator rule for sorting
     * @param composite object fo sorting
     * @return sorted components.
     */
    private static List<Component> getSortedComponents(
            final Comparator<Component> comparator,
            final Component composite) {
        return ((Composite) composite).getImmutableComponents()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

}
