package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlbumDaoImpl implements AlbumDao {
    private static Logger logger = Logger.getLogger(AlbumDaoImpl.class);

    @Override
    public void create(final AlbumEntity album) {
        String sql = "INSERT INTO album (date, localized_name_id, localized_description_id, photo_category_id) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
            statement = statementCreator.takeStatement(sql);
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
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();

            }
        }

    }

    @Override
    public void update(final AlbumEntity album) {
        String sql = "UPDATE `album` SET `date` = ?, `localized_name_id` = ?, `localized_description_id` = ?, `photo_category_id` = ? WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
            statement = statementCreator.takeStatement(sql);
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

            statement.setInt(5, album.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public void delete(final Integer id) {
        String sql = "DELETE FROM `album` WHERE `id` = ?";
        PreparedStatement statement = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
            statement = statementCreator.takeStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public AlbumEntity findById(final Integer id) {
        String sql = "SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` WHERE `id`= ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
            statement = statementCreator.takeStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            AlbumEntity album = null;
            if (resultSet.next()) {
                album = new AlbumEntity();
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
            }
            return album;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
        return null;
    }

    @Override
    public List<AlbumEntity> findAll() {
        String sql = "SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id` FROM `album` ORDER BY `id`";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            StatementCreator statementCreator = new StatementCreator();
            statement = statementCreator.takeStatement(sql);
            resultSet = statement.executeQuery();
            List<AlbumEntity> albums = new ArrayList<>();
            AlbumEntity album = null;
            while (resultSet.next()) {
                album = new AlbumEntity();
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
                albums.add(album);
            }
            return albums;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
        return null;
    }
}

