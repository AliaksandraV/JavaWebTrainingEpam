package by.training.photographer.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class AlbumEntity extends Entity {

    private Calendar date;
    private LocalizedTextEntity nameEntity;
    private LocalizedTextEntity descriptionEntity;
    private PhotoCategoryEntity photoCategory;
    private List<PhotoEntity> photoList;

    public Calendar getDate() {
        return date;
    }

    public void setDate(final Calendar date) {
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
                Objects.equals(descriptionEntity, that.descriptionEntity) &&
                Objects.equals(photoCategory, that.photoCategory) &&
                Objects.equals(photoList, that.photoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), date, nameEntity, descriptionEntity, photoCategory, photoList);
    }

    @Override
    public String toString() {
        return "AlbumEntity{" +
                "date=" + date +
                ", nameEntity=" + nameEntity +
                ", descriptionEntity=" + descriptionEntity +
                ", photoCategory=" + photoCategory +
                ", photoList=" + photoList +
                '}';
    }
}
