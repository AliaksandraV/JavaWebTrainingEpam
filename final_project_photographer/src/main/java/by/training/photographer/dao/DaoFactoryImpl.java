package by.training.photographer.dao;

import java.sql.Connection;

public class DaoFactoryImpl implements DaoFactory {

    @Override
    public UserDao getUserDao(Connection connection) {
        return new UserDaoImpl(connection);
    }

    @Override
    public PhotoCategoryDao getCategoryDao(final Connection connection) {
        return new PhotoCategoryDaoImpl(connection);
    }

    @Override
    public AlbumDao getAlbumDao(final Connection connection) {
        return new AlbumDaoImpl(connection);
    }

    @Override
    public PhotoDao getPhotoDao(final Connection connection) {
        return new PhotoDaoImpl(connection);
    }

    @Override
    public LocalizedTextDao getLocalizedTextDao(final Connection connection) {
        return new LocalizedTextDaoImpl(connection);
    }
}
