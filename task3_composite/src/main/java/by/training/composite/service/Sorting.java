package by.training.composite.service;

import by.training.composite.entity.Component;
import by.training.composite.entity.ComponentException;
import by.training.composite.entity.Text;

/**
 * Sorting interface.
 */
public interface Sorting {
    /**
     * sort method.
     * @param text for sorting.
     * @return sorted text
     * @throws ComponentException exception
     */
    Text sort(Component text) throws ComponentException;
}
