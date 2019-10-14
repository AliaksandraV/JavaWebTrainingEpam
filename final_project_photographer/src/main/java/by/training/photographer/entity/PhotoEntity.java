package by.training.photographer.entity;

import java.util.List;
import java.util.Objects;

public class PhotoEntity extends Entity {

    private String path;
    private AlbumEntity albumEntity;
    private List<LikeEntity> likes;

    /**
     * default constructor.
     */
    public PhotoEntity() {
    }

    public PhotoEntity(final int id) {
        super(id);
    }

    public PhotoEntity(final String path,
                       final AlbumEntity albumEntity,
                       final List<LikeEntity> likes) {
        this.path = path;
        this.albumEntity = albumEntity;
        this.likes = likes;
    }

    public PhotoEntity(final int id,
                       final String path,
                       final AlbumEntity albumEntity,
                       final List<LikeEntity> likes) {
        super(id);
        this.path = path;
        this.albumEntity = albumEntity;
        this.likes = likes;
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
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhotoEntity that = (PhotoEntity) o;
        return Objects.equals(path, that.path) &&
            Objects.equals(albumEntity, that.albumEntity) &&
            Objects.equals(likes, that.likes);
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
            ", likes=" + likes +

            '}';
    }
}
