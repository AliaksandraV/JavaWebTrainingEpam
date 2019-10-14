package by.training.photographer.entity;

import java.util.List;
import java.util.Objects;

public class PhotoCategoryEntity extends Entity {

    private LocalizedTextEntity localizedName;
    private String coverImagePath;
    private List<AlbumEntity> albumList;

    /**
     * default constructor
     */
    public PhotoCategoryEntity() {
    }

    public PhotoCategoryEntity(final int id) {
        super(id);
    }

    public PhotoCategoryEntity(final LocalizedTextEntity localizedName,
                               final String coverImagePath,
                               final List<AlbumEntity> albumList) {
        this.localizedName = localizedName;
        this.coverImagePath = coverImagePath;
        this.albumList = albumList;
    }

    public PhotoCategoryEntity(final int id,
                               final LocalizedTextEntity localizedName,
                               final String coverImagePath,
                               final List<AlbumEntity> albumList) {
        super(id);
        this.localizedName = localizedName;
        this.coverImagePath = coverImagePath;
        this.albumList = albumList;
    }

    public LocalizedTextEntity getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(final LocalizedTextEntity localizedName) {
        this.localizedName = localizedName;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(final String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }

    public List<AlbumEntity> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(final List<AlbumEntity> albumList) {
        this.albumList = albumList;
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
        PhotoCategoryEntity that = (PhotoCategoryEntity) o;
        return Objects.equals(localizedName, that.localizedName) &&
            Objects.equals(coverImagePath, that.coverImagePath) &&
            Objects.equals(albumList, that.albumList);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), localizedName, coverImagePath, albumList);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "PhotoCategoryEntity{" +
            "id=" + id +
            ", localizedName=" + localizedName +
            ", coverImagePath='" + coverImagePath + '\'' +
            ", albumList=" + albumList +
            '}';
    }
}
