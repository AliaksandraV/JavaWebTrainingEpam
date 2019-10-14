package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.LikeEntity;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.exception.PersistenceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;


public class PhotoDaoImplTest extends BaseDaoImplTest {
    private PhotoDao photoDao;

    private static final int ID_PHOTO = 1;
    private static final String PATH = "path";
    private static final Calendar calendar = Calendar.getInstance();
    static {
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 6);
    }
    private static final Date DATE = new Date(calendar.getTime().getTime());
    private static final int ID_ALBUM_NAME = 1;
    private static final String ALBUM_NAME_TEXT = "albumName";
    private static final int ID_ALBUM_DESCRIPTION = 2;
    private static final String ALBUM_DESCRIPTION_TEXT = "albumDescription";
    private static final int ID_CATEGORY_NAME = 3;
    private static final String CATEGORY_NAME_TEXT = "categoryDescription";
    private static final String CATEGORY_COVER_IMG_PATH = "categoryCoverImgPath";
    private static final int ID_CATEGORY = 1;
    private static final int ID_ALBUM = 1;
    private static final AlbumEntity ALBUM = new AlbumEntity(ID_ALBUM);
    private static final List<LikeEntity> LIKES = new ArrayList<>();
    private static final PhotoEntity NEW_PHOTO_ENTITY = new PhotoEntity(PATH, ALBUM, LIKES);
    private static final PhotoEntity SAVED_PHOTO_ENTITY = new PhotoEntity(ID_PHOTO, PATH, ALBUM, null);

    @BeforeClass
    public void initClass() {
        photoDao = new PhotoDaoImpl(getConnection());
    }

    @Test
    public void testCreate() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_NAME + "', '" + ALBUM_NAME_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_DESCRIPTION + "', '" + ALBUM_DESCRIPTION_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_CATEGORY_NAME + "', '" + CATEGORY_NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID_CATEGORY + "', '" + CATEGORY_COVER_IMG_PATH + "', '" + ID_CATEGORY_NAME + "')");

        executeScript("INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + DATE + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        assertTrue(photoDao.findAll().isEmpty());
        // when
        Integer id = photoDao.create(NEW_PHOTO_ENTITY);

        // then
        assertEquals(photoDao.findById(id), SAVED_PHOTO_ENTITY);
    }

    @Test
    public void testUpdate() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_NAME + "', '" + ALBUM_NAME_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_DESCRIPTION + "', '" + ALBUM_DESCRIPTION_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_CATEGORY_NAME + "', '" + CATEGORY_NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID_CATEGORY + "', '" + CATEGORY_COVER_IMG_PATH + "', '" + ID_CATEGORY_NAME + "')");

        executeScript("INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + DATE + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");

        String updatedPath = "new name";
        PhotoEntity updatedPhotoEntity = new PhotoEntity(ID_PHOTO, updatedPath, ALBUM, null);

        // when
        photoDao.update(updatedPhotoEntity);

        // then
        assertEquals(updatedPhotoEntity, photoDao.findById(ID_PHOTO));
    }

    @Test
    public void testDelete() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_NAME + "', '" + ALBUM_NAME_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_DESCRIPTION + "', '" + ALBUM_DESCRIPTION_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_CATEGORY_NAME + "', '" + CATEGORY_NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID_CATEGORY + "', '" + CATEGORY_COVER_IMG_PATH + "', '" + ID_CATEGORY_NAME + "')");

        executeScript("INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + DATE + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");

        assertFalse(photoDao.findAll().isEmpty());

        // when
        photoDao.delete(ID_PHOTO);

        // then
        assertTrue(photoDao.findAll().isEmpty());
    }

    @Test
    public void testFindById() throws PersistenceException {
        // init
        assertNull(photoDao.findById(ID_PHOTO));
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_NAME + "', '" + ALBUM_NAME_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_DESCRIPTION + "', '" + ALBUM_DESCRIPTION_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_CATEGORY_NAME + "', '" + CATEGORY_NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID_CATEGORY + "', '" + CATEGORY_COVER_IMG_PATH + "', '" + ID_CATEGORY_NAME + "')");

        executeScript("INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + DATE + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");

        // when
        PhotoEntity result = photoDao.findById(ID_PHOTO);

        // then
        assertEquals(result, SAVED_PHOTO_ENTITY);
    }

    @Test
    public void testFindAll() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_NAME + "', '" + ALBUM_NAME_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_DESCRIPTION + "', '" + ALBUM_DESCRIPTION_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_CATEGORY_NAME + "', '" + CATEGORY_NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID_CATEGORY + "', '" + CATEGORY_COVER_IMG_PATH + "', '" + ID_CATEGORY_NAME + "')");

        executeScript("INSERT INTO album (id, date, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + DATE + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");
        // when
        List<PhotoEntity> result = photoDao.findAll();

        // then
        assertEquals(result, Collections.singletonList(SAVED_PHOTO_ENTITY));
    }
}