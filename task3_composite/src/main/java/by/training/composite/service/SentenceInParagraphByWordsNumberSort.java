package by.training.composite.service;

import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Composite;
import by.training.composite.entity.Text;
import by.training.composite.entity.Paragraph;
import by.training.composite.entity.Sentence;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sentence In Paragraph By Words Number Sort.
 */
public class SentenceInParagraphByWordsNumberSort  implements Sorting {

    /**
     * sort.
     *
     * @param text text for sorting
     * @return sorted text
     * @throws ComponentException if component exception
     */
    @Override
    public Text sort(final Component text) throws ComponentException {
        Comparator<Component> comparator = Comparator
                .comparingInt(o -> ((Composite) ((Composite) o)
                        .getImmutableComponents()
                        .get(0))
                        .getImmutableComponents()
                        .size());

        List<Component> paragraphs = new ArrayList<>();

        ((Text) text)
                .getImmutableComponents()
                .forEach(paragraph -> {
                    List<Component> sentences = new ArrayList<>();
                    ((Composite) paragraph)
                            .getImmutableComponents()
                            .forEach(sentence -> {
                                List<Component> components =
                                    getSortedComponents(
                                            comparator, sentence);
                                sentences.add(new Sentence(components));
                            });
                    paragraphs.add(new Paragraph(sentences));
                });
        return new Text(paragraphs);
    }

    /**
     * sort component on their level.
     *
     * @param comparator rule for sorting
     * @param composite  object fo sorting
     * @return sorted components.
     */
    private static List<Component> getSortedComponents(
            final Comparator<Component> comparator, final Component composite) {
        return ((Composite) composite).getImmutableComponents()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
