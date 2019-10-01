package by.training.photographer.dao.specification.album;

import by.training.photographer.dao.specification.Specification;
import by.training.photographer.entity.AlbumEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchByCategoryId implements AlbumSpecification {

private static final String BY_CATEGORY_ID = "" +
        "SELECT `id`, `date`, `localized_name_id`, `localized_description_id`, `photo_category_id`\n" +
        "FROM `album`\n" +
        "WHERE photo_category_id=3";

    @Override
    public List<AlbumEntity> query(final List<AlbumEntity> cars) {
        List<AlbumEntity> albums = new ArrayList<>();
//        try (PreparedStatement statement = initConnection().prepareStatement(BY_CATEGORY_ID);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                AlbumEntity album = new AlbumEntity();
//                albums.add(createAlbum(resultSet, album));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return albums;
    }
}
