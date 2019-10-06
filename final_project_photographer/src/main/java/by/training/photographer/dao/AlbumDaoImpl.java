package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlbumDaoImpl extends BaseDaoImpl<Integer, AlbumEntity> implements AlbumDao {
    private static Logger logger = Logger.getLogger(AlbumDaoImpl.class);

    private static final String CREATE = "INSERT INTO album (date, localized_name_id, localized_description_id, photo_category_id) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE `album` SET `date` = ?, `localized_name_id` = ?, `localized_description_id` = ?, `photo_category_id` = ? WHERE `id` = ?";
    private static final String DELETE = "DELETE FROM `album` WHERE `id` = ?";
    private static final String FIND_BY_ID = "SELECT a.id, " +
            "       a.date, " +
            "       a.localized_name_id, " +
            "       a.localized_description_id, " +
            "       a.photo_category_id, " +
            "       lt.russian  as name, " +
            "       lt2.russian as description " +
            "FROM album a " +
            "         LEFT JOIN localized_text lt " +
            "                   ON a.localized_name_id = lt.id " +
            "         LEFT JOIN localized_text lt2 " +
            "                   ON a.localized_description_id = lt2.id " +
            "WHERE a.id = ?";
    private static final String FIND_ALL = "SELECT a.id, " +
            "       a.date, " +
            "       a.localized_name_id, " +
            "       a.localized_description_id, " +
            "       a.photo_category_id, " +
            "       lt.russian AS name, " +
            "       lt2.russian AS description " +
            "FROM album a " +
            "LEFT JOIN localized_text lt ON a.localized_name_id = lt.id " +
            "LEFT JOIN localized_text lt2 ON a.localized_description_id = lt2.id " +
            "ORDER BY id;";

    private static final String FIND_BY_CATEGORY_ID = "" +
            "SELECT a.id, " +
            "       a.date, " +
            "       a.localized_name_id, " +
            "       a.localized_description_id, " +
            "       a.photo_category_id, " +
            "       lt.russian  as name, " +
            "       lt2.russian as description " +
            "FROM album a " +
            "         LEFT JOIN localized_text lt " +
            "                   ON a.localized_name_id = lt.id " +
            "         LEFT JOIN localized_text lt2 " +
            "                   ON a.localized_description_id = lt2.id " +
            "WHERE photo_category_id=?";

    @Override
    public Integer create(final AlbumEntity album) {
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

    @Override
    public List<AlbumEntity> findByCategory(final Integer id) {
        List<AlbumEntity> albums = new ArrayList<>();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_BY_CATEGORY_ID);
             ResultSet resultSet = createResultSet(statement, id)) {
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

        int nameId = resultSet.getInt("localized_name_id");
        String nameStr = resultSet.getString("name");
        if (!resultSet.wasNull()) {
            LocalizedTextEntity name = new LocalizedTextEntity();
            name.setId(nameId);
            name.setRussian(nameStr);
            album.setNameEntity(name);
        }

        int descriptionId = resultSet.getInt("localized_description_id");
        String descriptionStr = resultSet.getString("description");
        if (!resultSet.wasNull()) {
            LocalizedTextEntity description = new LocalizedTextEntity();
            description.setId(descriptionId);
            description.setRussian(descriptionStr);
            album.setDescriptionEntity(description);
        }

        int categoryId = resultSet.getInt("photo_category_id");
        if (!resultSet.wasNull()) {
            PhotoCategoryEntity category = new PhotoCategoryEntity();
            category.setId(categoryId);
            album.setPhotoCategory(category);
        }

        return album;
    }
}

