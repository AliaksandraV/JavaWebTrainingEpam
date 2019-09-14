package by.training.photographer.entity;

import java.util.List;

public class PhotoCategoryEntity {

    private long id;
    private LocalizedTextEntity localizedName;
    private String coverImagePath;
    private List<AlbumEntity> albumList;
}
