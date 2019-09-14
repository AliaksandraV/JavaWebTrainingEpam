package by.training.photographer.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AlbumEntity extends Entity {

    private Date date;
    private LocalizedTextEntity nameEntity;
    private LocalizedTextEntity descriptionEntity;
    private PhotoCategoryEntity photoCategory;
    private List<PhotoEntity> photoList;

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public LocalizedTextEntity getNameEntity() {
        return nameEntity;
    }

    public void setNameEntity(final LocalizedTextEntity nameEntity) {
        this.nameEntity = nameEntity;
    }

    public LocalizedTextEntity getDescriptionEntity() {
        return descriptionEntity;
    }

    public void setDescriptionEntity(final LocalizedTextEntity descriptionEntity) {
        this.descriptionEntity = descriptionEntity;
    }

    public PhotoCategoryEntity getPhotoCategory() {
        return photoCategory;
    }

    public void setPhotoCategory(final PhotoCategoryEntity photoCategory) {
        this.photoCategory = photoCategory;
    }

    public List<PhotoEntity> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(final List<PhotoEntity> photoList) {
        this.photoList = photoList;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlbumEntity that = (AlbumEntity) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(nameEntity, that.nameEntity) &&
                Objects.equals(photoCategory, that.photoCategory) &&
                Objects.equals(photoList, that.photoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date, nameEntity, photoCategory, photoList);
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "date=" + date +
                ", nameEntity=" + nameEntity +
                ", photoCategory=" + photoCategory +
                ", photoList=" + photoList +
                ", id=" + id +
                '}';
    }
}
