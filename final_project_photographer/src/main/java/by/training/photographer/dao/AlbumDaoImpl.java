package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlbumDaoImpl extends DaoImpl<Integer, AlbumEntity> implements AlbumDao {
    private static Logger logger = Logger.getLogger(AlbumDaoImpl.class);

    private static final String CREATE = "INSERT INTO album (date, localized_name_id, localized_description_id, photo_category_id) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE `album` SET `date` = ?, `localized_name_id` = ?, `localized_description_id` = ?, `photo_category_id` = ? WHERE `id` = ?";
    private static final String DELETE = "DELETE FROM `album` WHERE `id` = ?";
    private static final String FIND_BY_ID = "SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` WHERE `id`= ?";
    private static final String FIND_ALL = "SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` ORDER BY `id`";

    @Override
    public void create(final AlbumEntity album) {
        try (PreparedStatement statement = initConnection().prepareStatement(CREATE)) {
            initFields(statement, album);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final AlbumEntity album) {
        try (PreparedStatement statement = initConnection().prepareStatement(UPDATE)) {
            initFields(statement, album);
            statement.setInt(5, album.getId());
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
    public AlbumEntity findById(final Integer id) {
        AlbumEntity album = new AlbumEntity();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_BY_ID);
             ResultSet resultSet = createResultSet(statement, id)) {
            if (resultSet.next()) {
                createAlbum(resultSet, album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public List<AlbumEntity> findAll() {
        List<AlbumEntity> albums = new ArrayList<>();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                AlbumEntity album = new AlbumEntity();
                albums.add(createAlbum(resultSet, album));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    private void initFields(final PreparedStatement statement, final AlbumEntity album) throws SQLException {
        if (album.getDate() != null) {
            statement.setDate(1, new Date(album.getDate().getTime().getTime()));
        } else {
            statement.setNull(1, Types.DATE);
        }

        if (album.getNameEntity() != null) {
            statement.setInt(2, album.getNameEntity().getId());
        } else {
            statement.setNull(2, Types.INTEGER);
        }

        if (album.getDescriptionEntity() != null) {
            statement.setInt(3, album.getDescriptionEntity().getId());
        } else {
            statement.setNull(3, Types.INTEGER);

        }

        if (album.getPhotoCategory() != null) {
            statement.setInt(4, album.getPhotoCategory().getId());
        } else {
            statement.setNull(4, Types.INTEGER);
        }
    }

    private AlbumEntity createAlbum(final ResultSet resultSet, final AlbumEntity album) throws SQLException {

        album.setId(resultSet.getInt("id"));

        Date myDate = resultSet.getDate("date");
        if (!resultSet.wasNull()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            album.setDate(cal);
        }

        Integer nameId = resultSet.getInt("localized_name_id");
        if (!resultSet.wasNull()) {
            LocalizedTextEntity name = new LocalizedTextEntity();
            name.setId(nameId);
            album.setNameEntity(name);
        }

        Integer descriptionId = resultSet.getInt("localized_description_id");
        if (!resultSet.wasNull()) {
            LocalizedTextEntity description = new LocalizedTextEntity();
            description.setId(descriptionId);
            album.setDescriptionEntity(description);
        }

        Integer categoryId = resultSet.getInt("photo_category_id");
        if (!resultSet.wasNull()) {
            PhotoCategoryEntity category = new PhotoCategoryEntity();
            category.setId(categoryId);
            album.setPhotoCategory(category);
        }

        return album;
    }
}

