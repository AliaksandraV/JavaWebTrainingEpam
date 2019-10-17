package by.training.photographer.entity;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * Album entity.
 */
public class AlbumEntity extends Entity {

    private String coverImagePath;
    /**
     * Date for album. Could be null.
     */
    private Calendar date;
    /**
     * Name for album. Could be null.
     */
    private LocalizedTextEntity nameEntity;
    /**
     * Description for album. Could be null.
     */
    private LocalizedTextEntity descriptionEntity;
    /**
     * Category in which the album is located. NOT null.
     */
    private PhotoCategoryEntity photoCategory;
    /**
     * List of photos located in this album.
     */
    private List<PhotoEntity> photoList;

    /**
     * default constructor.
     */
    public AlbumEntity() {
    }

    public AlbumEntity(final int id) {
        super(id);
    }

    public AlbumEntity(final String coverImagePath,
                       final Calendar date,
                       final LocalizedTextEntity nameEntity,
                       final LocalizedTextEntity descriptionEntity,
                       final PhotoCategoryEntity photoCategory,
                       final List<PhotoEntity> photoList) {
        this.coverImagePath = coverImagePath;
        this.date = date;
        this.nameEntity = nameEntity;
        this.descriptionEntity = descriptionEntity;
        this.photoCategory = photoCategory;
        this.photoList = photoList;
    }

    public AlbumEntity(final int id,
                       final String coverImagePath,
                       final Calendar date,
                       final LocalizedTextEntity nameEntity,
                       final LocalizedTextEntity descriptionEntity,
                       final PhotoCategoryEntity photoCategory,
                       final List<PhotoEntity> photoList) {
        super(id);
        this.coverImagePath = coverImagePath;
        this.date = date;
        this.nameEntity = nameEntity;
        this.descriptionEntity = descriptionEntity;
        this.photoCategory = photoCategory;
        this.photoList = photoList;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(final String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }

    /**
     * Return data.
     *
     * @return data.
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Set date.
     *
     * @param date date for set.
     */
    public void setDate(final Calendar date) {
        this.date = date;
    }

    /**
     * Return album name.
     *
     * @return album name
     */
    public LocalizedTextEntity getNameEntity() {
        return nameEntity;
    }

    /**
     * Set album name.
     *
     * @param nameEntity album name.
     */
    public void setNameEntity(final LocalizedTextEntity nameEntity) {
        this.nameEntity = nameEntity;
    }

    /**
     * Return album description.
     *
     * @return album description.
     */
    public LocalizedTextEntity getDescriptionEntity() {
        return descriptionEntity;
    }

    /**
     * Set album description.
     *
     * @param descriptionEntity album description.
     */
    public void setDescriptionEntity(
        final LocalizedTextEntity descriptionEntity) {
        this.descriptionEntity = descriptionEntity;
    }

    /**
     * Return category.
     *
     * @return photo category.
     */
    public PhotoCategoryEntity getPhotoCategory() {
        return photoCategory;
    }

    /**
     * Set category for album.
     *
     * @param photoCategory photo category.
     */
    public void setPhotoCategory(final PhotoCategoryEntity photoCategory) {
        this.photoCategory = photoCategory;
    }

    /**
     * Return list of photos located in this album.
     *
     * @return list of photos.
     */
    public List<PhotoEntity> getPhotoList() {
        return photoList;
    }

    /**
     * Set list of photos for this album.
     *
     * @param photoList list of photos for this album.
     */
    public void setPhotoList(final List<PhotoEntity> photoList) {
        this.photoList = photoList;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument;
     * false otherwise.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AlbumEntity that = (AlbumEntity) o;
        return Objects.equals(coverImagePath, that.coverImagePath) &&
            Objects.equals(date, that.date) &&
            Objects.equals(nameEntity, that.nameEntity) &&
            Objects.equals(descriptionEntity, that.descriptionEntity) &&
            Objects.equals(photoCategory, that.photoCategory) &&
            Objects.equals(photoList, that.photoList);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coverImagePath, date, nameEntity,
            descriptionEntity, photoCategory, photoList);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "AlbumEntity{" +
            "id=" + id +
            ", coverImagePath='" + coverImagePath + '\'' +
            dataPrint() +
            ", nameEntity=" + nameEntity +
            ", descriptionEntity=" + descriptionEntity +
            ", photoCategory=" + photoCategory +
            ", photoList=" + photoList +
            '}';
    }

    private String dataPrint() {
        if (date != null) {
            return "date=" + date.get(Calendar.DAY_OF_MONTH)
                + "." + date.get(Calendar.MONTH)
                + "." + date.get(Calendar.YEAR);
        } else {
            return "not indicated";
        }
    }
}
