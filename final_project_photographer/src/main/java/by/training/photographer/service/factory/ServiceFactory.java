package by.training.photographer.service.factory;

import by.training.photographer.service.AlbumService;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.PhotoService;
import by.training.photographer.service.UserService;

public interface ServiceFactory {
    UserService createUserService();

    AlbumService createAlbumService();

    PhotoService createPhotoService();

    PhotoCategoryService createPhotoCategoryService();
}
