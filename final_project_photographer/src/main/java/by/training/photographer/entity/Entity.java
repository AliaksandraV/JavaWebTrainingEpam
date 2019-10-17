package by.training.photographer.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class is the root of the entity-class hierarchy.
 * Every class that has Entity as a superclass. All objects,
 *  * including arrays, implement the methods of this class.
 */
public abstract class Entity implements Serializable {

    /**
     * Uniq id. Not Null. Any inheritor must have id.
     */
    protected int id;

    public Entity() {
    }

    public Entity(final int id) {
        this.id = id;
    }

    /**
     * Return id.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.
     *
     * @param id id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity entity = (Entity) obj;
        return id == entity.id;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
