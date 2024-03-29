package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PaginationResult;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhotoDaoImpl extends BaseDaoImpl<Integer, PhotoEntity> implements PhotoDao {
    private static Logger logger = Logger.getLogger(PhotoDaoImpl.class);

    private static final String CREATE_QUERY =
        "INSERT INTO photo (path, album_id ) "
        + "VALUES (?, ?);";

    private static final String UPDATE_QUERY =
        "UPDATE photo "
        + "SET path = ?, album_id = ? "
        + "WHERE id = ?";

    private static final String DELETE_QUERY =
        "DELETE FROM photo "
        + "WHERE id = ?";

    private static final String FIND_BY_ID_QUERY =
        "SELECT id, path, album_id "
        + "FROM photo WHERE id = ?";

    private static final String FIND_ALL_QUERY =
        "SELECT id, path, album_id "
        + "FROM photo "
        + "ORDER BY id";

    private static final String FIND_BY_ALBUM_WITH_PAGINATION_QUERY =
        "SELECT id, path, album_id "
        + "FROM photo "
        + "WHERE album_id = ? "
        + "ORDER BY id "
        + "LIMIT ? OFFSET ?";

    private static final String FIND_BY_ALBUM_QUERY =
        "SELECT id, path, album_id "
        + "FROM photo "
        + "WHERE album_id = ? "
        + "ORDER BY id ";

    private static final String COUNT_AMOUNT_QUERY =
        "SELECT COUNT(id)"
        + "FROM photo "
        + "WHERE album_id = ?";

    public PhotoDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Integer create(final PhotoEntity photo) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
             ResultSet resultSet = createAndGenerateId(statement, photo)) {

            return getGeneratedId(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet createAndGenerateId(final PreparedStatement statement, final PhotoEntity photo) throws SQLException {
        statement.setString(1, photo.getPath());
        statement.setInt(2, photo.getAlbumEntity().getId());

        statement.executeUpdate();

        return statement.getGeneratedKeys();
    }

    private Integer getGeneratedId(ResultSet resultSet) throws SQLException, PersistenceException {
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            logger.error("There is no auto incremented index after trying to add record into table `photo`");
            throw new PersistenceException();
        }
    }

    @Override
    public void update(final PhotoEntity photo) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, photo.getPath());
            statement.setInt(2, photo.getAlbumEntity().getId());
            statement.setInt(3, photo.getId());
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
    public PhotoEntity findById(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID_QUERY);
             ResultSet resultSet = findById(statement, id)) {

            return resultSet.next() ? createPhotoEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet findById(final PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    @Override
    public List<PhotoEntity> findAll() throws PersistenceException {
        List<PhotoEntity> photos = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                photos.add(createPhotoEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return photos;
    }

    @Override
    public List<PhotoEntity> findByAlbum(final Integer albumId) throws PersistenceException {
        List<PhotoEntity> photos = new ArrayList<>();

        try (PreparedStatement statement =
                 getConnection().prepareStatement(FIND_BY_ALBUM_QUERY);
             ResultSet resultSet = findById(statement, albumId)) {

            while (resultSet.next()) {
                photos.add(createPhotoEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return photos;
    }

    @Override
    public PaginationResult<PhotoEntity> findByAlbumWithPagination(final Integer albumId, final int currentPage, final int stepAmount) throws PersistenceException {
        List<PhotoEntity> photos = new ArrayList<>();
        PaginationResult pagination = new PaginationResult(currentPage, stepAmount);
        pagination.setCurrentPage(currentPage);
        pagination.setStepAmount(stepAmount);


        try (PreparedStatement statement =
                 getConnection().prepareStatement(FIND_BY_ALBUM_WITH_PAGINATION_QUERY);
             ResultSet resultSet = findByIdPagination(statement, albumId, stepAmount, (currentPage - 1) * stepAmount)) {

            while (resultSet.next()) {
                photos.add(createPhotoEntity(resultSet));
            }

            try (PreparedStatement statementCount =
                     getConnection().prepareStatement(COUNT_AMOUNT_QUERY);
                 ResultSet resultSetCount = findById(statementCount, albumId)) {
                resultSetCount.next();
                pagination.setTotalRecords(resultSetCount.getInt(1));
            }
            pagination.setTotalPages((int) Math.ceil((double) pagination.getTotalRecords() / (double) pagination.getStepAmount()));
            pagination.setList(photos);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return pagination;

    }

    private ResultSet findByIdPagination(final PreparedStatement statement, final int albumId, final int stepAmount, final int start) throws SQLException {
        statement.setInt(1, albumId);
        statement.setInt(2, stepAmount);
        statement.setInt(3, start);
        return statement.executeQuery();
    }

    private PhotoEntity createPhotoEntity(final ResultSet resultSet) throws SQLException {
        PhotoEntity photo = new PhotoEntity();

        photo.setId(resultSet.getInt("id"));
        photo.setPath(resultSet.getString("path"));
        AlbumEntity name = new AlbumEntity();
        name.setId(resultSet.getInt("album_id"));
        photo.setAlbumEntity(name);

        return photo;
    }
}
