package by.training.photographer.entity;

import java.util.Date;
import java.util.List;

public class AlbumEntity {

    private long id;
    private Date date;
    private LocalizedTextEntity localizedName;
    private PhotoCategoryEntity photoCategory;
    private List<PhotoEntity> photoList;
}
