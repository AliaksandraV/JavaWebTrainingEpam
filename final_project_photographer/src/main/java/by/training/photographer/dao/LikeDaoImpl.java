package by.training.photographer.dao;

import by.training.photographer.entity.LikeEntity;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LikeDaoImpl extends BaseDaoImpl<Integer, LikeEntity> implements LikeDao {
    private static Logger logger = Logger.getLogger(LikeDaoImpl.class);

    private static final String CREATE_QUERY = "INSERT INTO `like` (user_id, photo_id) VALUES (?, ?);";
    private static final String DELETE_QUERY = "DELETE FROM `like` WHERE id = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT id, user_id, photo_id FROM `like` WHERE id= ?";
    private static final String FIND_ALL_QUERY = "SELECT id, user_id, photo_id FROM `like` ORDER BY id";

    public LikeDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Integer create(final LikeEntity like) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
             ResultSet resultSet = createAndGenerateId(statement, like)) {

            return getGeneratedId(resultSet);
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet createAndGenerateId(final PreparedStatement statement, final LikeEntity like) throws SQLException {
        statement.setInt(1, like.getUserEntity().getId());
        statement.setInt(2, like.getPhotoEntity().getId());

        statement.executeUpdate();

        return statement.getGeneratedKeys();
    }

    private Integer getGeneratedId(ResultSet resultSet) throws SQLException, PersistenceException {
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            logger.error("There is no auto incremented index after trying to add record into table `like`");
            throw new PersistenceException();
        }
    }

    @Override
    public void update(final LikeEntity like) {

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
    public LikeEntity findById(final Integer id) throws PersistenceException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID_QUERY);
             ResultSet resultSet = findById(statement, id)) {

            return resultSet.next() ? createLikeEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private ResultSet findById(final PreparedStatement statement, Integer id) throws SQLException {
        statement.setInt(1, id);
        return statement.executeQuery();
    }

    @Override
    public List<LikeEntity> findAll() throws PersistenceException {
        List<LikeEntity> likes = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(FIND_ALL_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                likes.add(createLikeEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return likes;
    }

    private LikeEntity createLikeEntity(final ResultSet resultSet) throws SQLException {
        LikeEntity like = new LikeEntity();

        like.setId(resultSet.getInt("id"));

        UserEntity user = new UserEntity();
        user.setId(resultSet.getInt("user_id"));
        like.setUserEntity(user);

        PhotoEntity photo = new PhotoEntity();
        photo.setId(resultSet.getInt("photo_id"));
        like.setPhotoEntity(photo);

        return like;
    }
}
