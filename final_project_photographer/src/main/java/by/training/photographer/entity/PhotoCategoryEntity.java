package by.training.photographer.entity;

import java.util.List;
import java.util.Objects;

public class PhotoCategoryEntity extends Entity{

    private LocalizedTextEntity localizedName;
    private String coverImagePath;
    private List<AlbumEntity> albumList;

    /**
     * default constructor
     */
    public PhotoCategoryEntity() {
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
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        PhotoCategoryEntity that = (PhotoCategoryEntity) obj;
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
