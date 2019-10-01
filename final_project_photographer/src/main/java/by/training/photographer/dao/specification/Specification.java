package by.training.photographer.dao.specification;

import java.util.List;

public interface Specification <T> {

    List<T> query(List<T> entities);
}
