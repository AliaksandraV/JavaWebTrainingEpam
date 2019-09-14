package by.training.photographer.entity;

import java.util.Objects;

public class LocalizedTextEntity extends Entity {

    private String russian;

    public String getRussian() {
        return russian;
    }

    public void setRussian(final String russian) {
        this.russian = russian;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LocalizedTextEntity that = (LocalizedTextEntity) o;
        return Objects.equals(russian, that.russian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), russian);
    }

    @Override
    public String toString() {
        return "LocalizedTextEntity{" +
                "russian='" + russian + '\'' +
                ", id=" + id +
                '}';
    }
}
