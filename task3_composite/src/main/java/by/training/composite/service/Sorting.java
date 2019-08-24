package by.training.composite.service;

import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Text;

import java.util.Comparator;

public interface Sorting {

    Text sort(Component text) throws ComponentException;
}
