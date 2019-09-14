package by.training.photographer.entity;

import java.util.List;
import java.util.Objects;

public class PhotoCategoryEntity extends Entity{

    private LocalizedTextEntity localizedName;
    private String coverImagePath;
    private List<AlbumEntity> albumList;

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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), localizedName, coverImagePath, albumList);
    }

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
