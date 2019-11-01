package by.training.photographer.dao;

import java.sql.Connection;

public interface DaoFactory {

    UserDao getUserDao(Connection connection);

    PhotoCategoryDao getCategoryDao(Connection connection);

    AlbumDao getAlbumDao(Connection connection);

    PhotoDao getPhotoDao(Connection connection);

    LocalizedTextDao getLocalizedTextDao(Connection connection);
}
