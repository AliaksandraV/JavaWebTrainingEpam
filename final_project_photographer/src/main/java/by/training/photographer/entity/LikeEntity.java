package by.training.photographer.entity;

import java.util.Objects;

public class LikeEntity extends Entity {

    private UserEntity userEntity;
    private PhotoEntity photoEntity;

    public LikeEntity() {
    }

    public LikeEntity(final int id) {
        super(id);
    }

    public LikeEntity(final UserEntity userEntity, final PhotoEntity photoEntity) {
        this.userEntity = userEntity;
        this.photoEntity = photoEntity;
    }

    public LikeEntity(final int id,
                      final UserEntity userEntity,
                      final PhotoEntity photoEntity) {
        super(id);
        this.userEntity = userEntity;
        this.photoEntity = photoEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public PhotoEntity getPhotoEntity() {
        return photoEntity;
    }

    public void setPhotoEntity(final PhotoEntity photoEntity) {
        this.photoEntity = photoEntity;
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
        LikeEntity that = (LikeEntity) obj;
        return Objects.equals(userEntity, that.userEntity) &&
               Objects.equals(photoEntity, that.photoEntity);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userEntity, photoEntity);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "LikeEntity{" +
               "userEntity=" + userEntity +
               ", photoEntity=" + photoEntity +
               ", id=" + id +
               '}';
    }
}
