package by.training.composite.service;

import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;

public interface Sorting {

    void sort(Component component) throws ComponentException;
}
