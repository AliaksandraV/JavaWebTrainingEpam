package by.training.photographer.entity;

import java.util.Objects;

public class LikeEntity extends Entity {
    private UserEntity userEntity;
    private PhotoEntity photoEntity;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LikeEntity that = (LikeEntity) o;
        return Objects.equals(userEntity, that.userEntity) &&
                Objects.equals(photoEntity, that.photoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userEntity, photoEntity);
    }

    @Override
    public String toString() {
        return "LikeEntity{" +
                "userEntity=" + userEntity +
                ", photoEntity=" + photoEntity +
                ", id=" + id +
                '}';
    }
}
