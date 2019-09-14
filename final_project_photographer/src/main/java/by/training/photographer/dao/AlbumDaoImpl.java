package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class AlbumDaoImpl implements AlbumDao {
    private static Logger logger = Logger.getLogger(AlbumDaoImpl.class);


    @Override
    public void create(final AlbumEntity album) {
        String sql = "INSERT INTO album (date, localized_name_id, localized_description_id, photo_category_id) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if (album.getDate() != null) {
                statement.setDate(1, new Date(album.getDate().getTime()));
            } else {
                statement.setNull(1, Types.DATE);
            }

            if( album.getNameEntity()!= null){
                statement.setInt(2, album.getNameEntity().getId());
            } else {
                statement.setNull(2, Types.INTEGER);
            }

            if(album.getDescriptionEntity()!= null){
                statement.setInt(3, album.getDescriptionEntity().getId());
            } else {
                statement.setNull(3, Types.INTEGER);

            }

            if(album.getPhotoCategory()!= null){
                statement.setInt(4, album.getPhotoCategory().getId());
            } else {
                statement.setNull(4, Types.INTEGER);
            }
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();

            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();

            }
        }

    }

    @Override
    public void update(final AlbumEntity album) {

    }

    @Override
    public void delete(final Integer id) {

    }

    @Override
    public void delete(final AlbumEntity entity) {

    }

    @Override
    public AlbumEntity findById(final Integer id) {
        return null;
    }

    @Override
    public List<AlbumEntity> FindAll() {
        return null;
    }

    @Override
    public List<AlbumEntity> findAll() {
        return null;
    }
}

