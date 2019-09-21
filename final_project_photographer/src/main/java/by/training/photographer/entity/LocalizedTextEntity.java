package by.training.photographer.entity;

import java.util.Objects;

public class LocalizedTextEntity extends Entity {

    private String russian;

    /**
     * default constructor
     */
    public LocalizedTextEntity() {
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
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        LocalizedTextEntity that = (LocalizedTextEntity) obj;
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
