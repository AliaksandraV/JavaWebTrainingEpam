package by.training.composite.service;

import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphsSentencesNumberService implements Sorting {
    @Override
    public void sort(final Component text) throws ComponentException {
        List<Component> components = new ArrayList<>();
//        for (int i = 0; i < text.takeChildrenNumber(); i++) {
//            text.takeChild(i)
//        }

//        users.stream()
//                .sorted(Comparator.comparingInt(User::getAge))
//                .collect(Collectors.toList());
    }
}
