package by.training.photographer.entity;

import java.util.Objects;

public class LocalizedTextEntity extends Entity {

    private String russian;

    public LocalizedTextEntity() {
    }

    public LocalizedTextEntity(final int id) {
        super(id);
    }

    public LocalizedTextEntity(final String russian) {
        this.russian = russian;
    }

    public LocalizedTextEntity(final int id, final String russian) {
        super(id);
        this.russian = russian;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(final String russian) {
        this.russian = russian;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LocalizedTextEntity that = (LocalizedTextEntity) o;
        return Objects.equals(russian, that.russian);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), russian);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "LocalizedTextEntity{" +
               "russian='" + russian + '\'' +
               ", id=" + id +
               '}';
    }
}
