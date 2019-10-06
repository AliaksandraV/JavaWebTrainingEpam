package by.training.photographer.dao;

import by.training.photographer.entity.LikeEntity;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.entity.UserEntity;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDaoImpl extends BaseDaoImpl<Integer, LikeEntity> implements LikeDao {
    private static Logger logger = Logger.getLogger(LikeDaoImpl.class);

    private static final String CREATE = "INSERT INTO `like` (user_id, photo_id) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE `like` SET user_id = ?, photo_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM `like` WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT id, user_id, photo_id FROM `like` WHERE id= ?";
    private static final String FIND_ALL = "SELECT id, user_id, photo_id FROM `like` ORDER BY id";


    @Override
    public void create(final LikeEntity like) {
        try (PreparedStatement statement = initConnection().prepareStatement(CREATE)) {
            initDbFields(statement, like);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final LikeEntity like) {
        try (PreparedStatement statement = initConnection().prepareStatement(UPDATE)) {
            initDbFields(statement, like);
            statement.setInt(3, like.getId());
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
    public LikeEntity findById(final Integer id) {
        LikeEntity like = new LikeEntity();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_BY_ID);
             ResultSet resultSet = createResultSet(statement, id)) {
            if (resultSet.next()) {
                initLike(resultSet, like);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return like;
    }

    @Override
    public List<LikeEntity> findAll() {
        List<LikeEntity> likes = new ArrayList<>();
        try (PreparedStatement statement = initConnection().prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                LikeEntity like = new LikeEntity();
                likes.add(initLike(resultSet, like));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likes;
    }

    private void initDbFields(final PreparedStatement statement, final LikeEntity like) throws SQLException {
        statement.setInt(1, like.getUserEntity().getId());
        statement.setInt(2, like.getPhotoEntity().getId());
    }

    private LikeEntity initLike(final ResultSet resultSet, final LikeEntity like) throws SQLException {
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
