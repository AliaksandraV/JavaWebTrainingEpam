package by.training.photographer.dao.specification.album;

import by.training.photographer.dao.specification.Specification;
import by.training.photographer.entity.AlbumEntity;

import java.util.List;

public interface AlbumSpecification extends Specification<AlbumEntity> {

    @Override
    List<AlbumEntity> query(List<AlbumEntity> entities);
}
