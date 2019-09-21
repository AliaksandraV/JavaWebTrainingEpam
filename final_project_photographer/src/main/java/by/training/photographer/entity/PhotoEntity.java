package by.training.photographer.entity;

import java.util.List;
import java.util.Objects;

public class PhotoEntity extends Entity{

    private String path;
    private AlbumEntity albumEntity;
    private List <LikeEntity> likes;

    /**
     * default constructor
     */
    public PhotoEntity() {
    }

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
        PhotoEntity that = (PhotoEntity) obj;
        return Objects.equals(path, that.path) &&
                Objects.equals(albumEntity, that.albumEntity);
    }
    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), path, albumEntity);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "PhotoEntity{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", albumEntity=" + albumEntity +
                '}';
    }
}
