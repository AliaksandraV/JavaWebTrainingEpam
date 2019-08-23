package by.training.composite.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * s an element that has sub-elements: leaves or other containers.
 * A container doesn’t know the concrete classes of its children.
 * It works with all sub-elements only via the component interface.
 */
public abstract class Composite implements Component {

    /**
     * Components list.
     */
    protected List<Component> components = new ArrayList<>();

    /**
     * Default constructs.
     */
    public Composite() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param newComponents the collection whose elements are to be placed
     *                      into this list
     */
    public Composite(final List<Component> newComponents) {
        this.components = newComponents;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param c element to be appended to this list
     */
    public void add(final Component c) {
        components.add(c);
    }

    /**
     * Removes the first occurrence of the specified element from list.
     *
     * @param c element to be removed from this list, if present
     */
    public void remove(final Component c) {
        components.remove(c);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws ComponentException if index out of bond
     */
    public Component takeChild(final int index) throws ComponentException {
        if (checkRange(index)) {
            return components.get(index);
        } else {
            throw new ComponentException("Index " + index
                    + " out of bounds for length " + components.size());
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the element at the specified position in this list
     */
    public int takeChildrenNumber() {
        return components.size();
    }

    /**
     * Returns an unmodifiable view of the specified list.
     *
     * @return an unmodifiable view of the specified list.
     */
    public List<Component> getImmutableComponents() {
        return Collections.unmodifiableList(components);
    }

    /**
     * Check possibility index out of bond exception.
     *
     * @param index element index.
     * @return true if range is correct.
     */
    private boolean checkRange(final int index) {
        return index >= 0 && index < components.size();
    }
}
