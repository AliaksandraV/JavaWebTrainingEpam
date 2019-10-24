package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.Entity;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlbumDaoImpl
    extends BaseDaoImpl<Integer, AlbumEntity>
    implements AlbumDao {

    private static Logger logger = Logger.getLogger(AlbumDaoImpl.class);

    private static final String CREATE_QUERY =
        "INSERT INTO album " +
            "            (cover_image_path, " +
            "             date, " +
            "             localized_name_id, " +
            "             localized_description_id, " +
            "             photo_category_id) " +
            "VALUES (?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY =
        "UPDATE `album` " +
            "SET   cover_image_path =?, " +
            "       date = ?, " +
            "       localized_name_id = ?, " +
            "       localized_description_id = ?, " +
            "       photo_category_id = ? " +
            "WHERE  id = ? ";

    private static final String DELETE_QUERY =
        "DELETE FROM `album` " +
            "WHERE `id` = ?";

    private static final String FIND_BY_ID_QUERY =
        "SELECT a.id, " +
            "       a.cover_image_path, " +
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

    private static final String FIND_ALL_QUERY =
        "SELECT a.id, " +
            "       a.cover_image_path, " +
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

    private static final String FIND_BY_CATEGORY_ID_QUERY =
        "SELECT a.id, " +
            "       a.cover_image_path, " +
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

    public AlbumDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Integer create(final AlbumEntity album) throws PersistenceException {
        try (PreparedStatement statement = getConnection()
            .prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
             ResultSet resultSet = createAndGenerateId(statement, album)) {

            return getGeneratedId(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet createAndGenerateId(final PreparedStatement statement,
                                          final AlbumEntity album)
        throws SQLException {

        setStringParameterToStatement(statement, 1, album.getCoverImagePath());
        setDateParameterToStatement(statement, 2, album.getDate());
        setIdParameterToStatement(statement, 3, album.getNameEntity());
        setIdParameterToStatement(statement, 4, album.getDescriptionEntity());
        setIdParameterToStatement(statement, 5, album.getPhotoCategory());

        statement.executeUpdate();

        return statement.getGeneratedKeys();
    }

    private void setStringParameterToStatement(final PreparedStatement statement, int index, final String str) throws SQLException {
        if (str != null) {
            statement.setString(index, str);
        } else {
            statement.setNull(index, Types.VARCHAR);
        }
    }

    private void setDateParameterToStatement(PreparedStatement statement, int index, Calendar date) throws SQLException {
        if (date != null) {
            statement.setDate(index, new Date(date.getTime().getTime()));
        } else {
            statement.setNull(index, Types.DATE);
        }
    }

    private void setIdParameterToStatement(final PreparedStatement statement, final int index, final Entity entity) throws SQLException {
        if (entity != null) {
            statement.setInt(index, entity.getId());
        } else {
            statement.setNull(index, Types.INTEGER);
        }
    }

    private Integer getGeneratedId(ResultSet resultSet) throws SQLException, PersistenceException {
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            logger.error("There is no auto incremented index after trying to add record into table `album`");
            throw new PersistenceException();
        }
    }

    @Override
    public void update(final AlbumEntity album) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            setStringParameterToStatement(statement, 1, album.getCoverImagePath());
            setDateParameterToStatement(statement, 2, album.getDate());
            setIdParameterToStatement(statement, 3, album.getNameEntity());
            setIdParameterToStatement(statement, 4, album.getDescriptionEntity());
            setIdParameterToStatement(statement, 5, album.getPhotoCategory());
            statement.setInt(6, album.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public AlbumEntity findById(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID_QUERY);
             ResultSet resultSet = findById(statement, id)) {

            return resultSet.next() ? createAlbumEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet findById(final PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    @Override
    public List<AlbumEntity> findAll() throws PersistenceException {
        List<AlbumEntity> albums = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                albums.add(createAlbumEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return albums;
    }

    @Override
    public List<AlbumEntity> findByCategory(final Integer categoryId) throws PersistenceException {
        List<AlbumEntity> albums = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_CATEGORY_ID_QUERY);
             ResultSet resultSet = findById(statement, categoryId)) {

            while (resultSet.next()) {
                albums.add(createAlbumEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return albums;
    }


    private AlbumEntity createAlbumEntity(final ResultSet resultSet) throws SQLException {
        AlbumEntity album = new AlbumEntity();

        album.setId(resultSet.getInt("id"));

        String coverPath = resultSet.getString("cover_image_path");
        if (!resultSet.wasNull()) {
            album.setCoverImagePath(coverPath);
        }

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

