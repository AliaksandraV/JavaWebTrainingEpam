package by.training.composite.service;

import by.training.composite.entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceInParagraphByWordsNumberSort  {

    public Text sort(final Component text) throws ComponentException {
        Comparator<Component> comparator = Comparator
                .comparingInt(o -> ((Composite)((Composite) o)
                        .getImmutableComponents()
                        .get(0))
                        .getImmutableComponents()
                        .size());

        List<Component> paragraphs = new ArrayList<>();

        ((Text) text).getImmutableComponents()
                .forEach(
                        paragraph -> {
                            List<Component> sentences = new ArrayList<>();
                            ((Composite) paragraph).getImmutableComponents()
                                    .forEach(
                                            sentence -> {
                                                List<Component> components = getSortedComponents(comparator, ((Composite) sentence));
                                                sentences.add(new Sentence(components));
                                            });
                            paragraphs.add(new Paragraph(sentences));
                        });
        return new Text(paragraphs);
    }

    private static List<Component> getSortedComponents(final Comparator<Component> comparator, final Component composite) {
        return ((Composite) composite).getImmutableComponents()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
