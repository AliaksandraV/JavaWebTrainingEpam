package by.training.photographer.dao;

import by.training.photographer.entity.PhotoCategoryEntity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class PhotoCategoryDaoImpl implements PhotoCategoryDao {


    @Override
    public void create(final PhotoCategoryEntity photoCategory) {
//        String sql = "INSERT INTO album (date, localized_name_id, localized_description_id, photo_category_id) VALUES (?, ?, ?, ?);";
//        PreparedStatement statement = null;
//        try {
//            StatementCreator statementCreator = new StatementCreator();
//            statement = statementCreator.takeStatement(sql);
//            if (album.getDate() != null) {
//                statement.setDate(1, new Date(album.getDate().getTime().getTime()));
//            } else {
//                statement.setNull(1, Types.DATE);
//            }
//
//            if (album.getNameEntity() != null) {
//                statement.setInt(2, album.getNameEntity().getId());
//            } else {
//                statement.setNull(2, Types.INTEGER);
//            }
//
//            if (album.getDescriptionEntity() != null) {
//                statement.setInt(3, album.getDescriptionEntity().getId());
//            } else {
//                statement.setNull(3, Types.INTEGER);
//
//            }
//
//            if (album.getPhotoCategory() != null) {
//                statement.setInt(4, album.getPhotoCategory().getId());
//            } else {
//                statement.setNull(4, Types.INTEGER);
//            }
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException | NullPointerException e) {
//                e.printStackTrace();
//
//            }
//        }
    }

    @Override
    public void update(final PhotoCategoryEntity photoCategory) {

    }

    @Override
    public void delete(final Integer id) {

    }

    @Override
    public PhotoCategoryEntity findById(final Integer id) {
        return null;
    }

    @Override
    public List<PhotoCategoryEntity> findAll() {
        return null;
    }
}
