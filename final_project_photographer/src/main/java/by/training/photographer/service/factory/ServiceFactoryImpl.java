package by.training.photographer.service.factory;

import by.training.photographer.dao.DaoFactory;
import by.training.photographer.service.AlbumService;
import by.training.photographer.service.AlbumServiceImpl;
import by.training.photographer.service.PhotoCategoryService;
import by.training.photographer.service.PhotoCategoryServiceImpl;
import by.training.photographer.service.PhotoService;
import by.training.photographer.service.PhotoServiceImpl;
import by.training.photographer.service.UserService;
import by.training.photographer.service.UserServiceImpl;

public class ServiceFactoryImpl implements ServiceFactory {

    private final DaoFactory daoFactory;

    public ServiceFactoryImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public UserService createUserService() {
        return new UserServiceImpl(daoFactory);
    }

    @Override
    public AlbumService createAlbumService() {
        return new AlbumServiceImpl(daoFactory);
    }

    @Override
    public PhotoService createPhotoService() {
        return new PhotoServiceImpl(daoFactory);
    }

    @Override
    public PhotoCategoryService createPhotoCategoryService() {
        return new PhotoCategoryServiceImpl(daoFactory);
    }
}
