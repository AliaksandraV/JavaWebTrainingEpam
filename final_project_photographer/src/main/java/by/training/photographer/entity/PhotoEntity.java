package by.training.photographer.entity;

import java.util.Objects;

public class PhotoEntity extends Entity{

    private String path;
    private AlbumEntity albumId;

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public AlbumEntity getAlbumId() {
        return albumId;
    }

    public void setAlbumId(final AlbumEntity albumId) {
        this.albumId = albumId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhotoEntity that = (PhotoEntity) o;
        return Objects.equals(path, that.path) &&
                Objects.equals(albumId, that.albumId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), path, albumId);
    }

    @Override
    public String toString() {
        return "PhotoEntity{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", albumId=" + albumId +
                '}';
    }
}
