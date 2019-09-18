package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PhotoEntity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotoDaoImpl extends DaoImpl<Integer, PhotoEntity> implements PhotoDao {
    private static Logger logger = Logger.getLogger(PhotoDaoImpl.class);

    private static final String CREATE = "INSERT INTO photo (path, album_id ) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE photo SET path = ?, album_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM photo WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT id, path, album_id FROM photo WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, path, album_id FROM photo ORDER BY id";

    @Override
    public void create(final PhotoEntity photo) {
        try (PreparedStatement statement = initConnection().prepareStatement(CREATE)) {
            initDbFields(statement, photo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final PhotoEntity photo) {
        try (PreparedStatement statement = initConnection().prepareStatement(UPDATE)) {
            initDbFields(statement, photo);
            statement.setInt(3, photo.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final Integer id) {
        try (PreparedStatement statement = initConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PhotoEntity findById(final Integer id) {
        PhotoEntity photo = new PhotoEntity();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_BY_ID);
             ResultSet resultSet = createResultSet(statement, id)) {
            if (resultSet.next()) {
                initPhoto(resultSet, photo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return photo;
    }

    @Override
    public List<PhotoEntity> findAll() {
        List<PhotoEntity> photos = new ArrayList<>();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PhotoEntity photo = new PhotoEntity();
                photos.add(initPhoto(resultSet, photo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return photos;
    }

    private void initDbFields(final PreparedStatement statement, final PhotoEntity photo) throws SQLException {
        statement.setString(1, photo.getPath());
        statement.setInt(2, photo.getAlbumEntity().getId());
    }

    private PhotoEntity initPhoto(final ResultSet resultSet, final PhotoEntity photo) throws SQLException {
        photo.setId(resultSet.getInt("id"));
        photo.setPath(resultSet.getString("path"));
        AlbumEntity name = new AlbumEntity();
        name.setId(resultSet.getInt("album_id"));
        photo.setAlbumEntity(name);
        return photo;
    }
}
