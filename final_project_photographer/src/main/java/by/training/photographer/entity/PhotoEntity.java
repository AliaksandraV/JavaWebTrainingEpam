package by.training.photographer.entity;

import java.util.List;
import java.util.Objects;

public class PhotoEntity extends Entity{

    private String path;
    private AlbumEntity albumEntity;
    private List <LikeEntity> likes;

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public AlbumEntity getAlbumEntity() {
        return albumEntity;
    }

    public void setAlbumEntity(final AlbumEntity albumEntity) {
        this.albumEntity = albumEntity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhotoEntity that = (PhotoEntity) o;
        return Objects.equals(path, that.path) &&
                Objects.equals(albumEntity, that.albumEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), path, albumEntity);
    }

    @Override
    public String toString() {
        return "PhotoEntity{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", albumEntity=" + albumEntity +
                '}';
    }
}
