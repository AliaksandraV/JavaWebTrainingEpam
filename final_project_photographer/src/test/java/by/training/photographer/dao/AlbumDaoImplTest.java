package by.training.photographer.dao;

import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.LocalizedTextEntity;
import by.training.photographer.entity.PhotoCategoryEntity;
import by.training.photographer.exception.PersistenceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class AlbumDaoImplTest extends BaseDaoImplTest {
    private AlbumDao albumDao;

    private static final int ID_ALBUM_NAME = 1;
    private static final String ALBUM_NAME_TEXT = "albumName";
    private static final LocalizedTextEntity ALBUM_NAME = new LocalizedTextEntity(ID_ALBUM_NAME);
    private static final int ID_ALBUM_DESCRIPTION = 2;
    private static final String ALBUM_DESCRIPTION_TEXT = "albumDescription";
    private static final LocalizedTextEntity ALBUM_DESCRIPTION = new LocalizedTextEntity(ID_ALBUM_DESCRIPTION);
    private static final int ID_CATEGORY_NAME = 3;
    private static final String CATEGORY_NAME_TEXT = "categoryDescription";
    private static final String CATEGORY_COVER_IMG_PATH = "categoryCoverImgPath";
    private static final int ID_CATEGORY = 1;
    private static final PhotoCategoryEntity CATEGORY = new PhotoCategoryEntity(ID_CATEGORY);
    private static final int ID_ALBUM = 1;
    private static final AlbumEntity NEW_ALBUM_ENTITY = new AlbumEntity(null, ALBUM_NAME, ALBUM_DESCRIPTION, CATEGORY, null);
    private static final AlbumEntity SAVED_ALBUM_ENTITY = new AlbumEntity(ID_ALBUM, null, ALBUM_NAME, ALBUM_DESCRIPTION, CATEGORY, null);

    @BeforeClass
    public void initClass() {
        albumDao = new AlbumDaoImpl(getConnection());
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

        assertTrue(albumDao.findAll().isEmpty());
        // when
        Integer id = albumDao.create(NEW_ALBUM_ENTITY);
        System.out.println(albumDao.findById(id));
        System.out.println(SAVED_ALBUM_ENTITY);
        // then
        assertEquals(albumDao.findById(id), SAVED_ALBUM_ENTITY);
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

        executeScript("INSERT INTO album (id, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        AlbumEntity updatedUserEntity = new AlbumEntity(ID_ALBUM, null, ALBUM_NAME, ALBUM_DESCRIPTION, CATEGORY, null);

        // when
        albumDao.update(updatedUserEntity);

        // then
        assertEquals(updatedUserEntity, albumDao.findById(ID_ALBUM));
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

        executeScript("INSERT INTO album (id, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        assertFalse(albumDao.findAll().isEmpty());

        // when
        albumDao.delete(ID_ALBUM);

        // then
        assertTrue(albumDao.findAll().isEmpty());
    }

    @Test
    public void testFindById() throws PersistenceException {
        // init
        assertNull(albumDao.findById(ID_ALBUM));
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_NAME + "', '" + ALBUM_NAME_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_DESCRIPTION + "', '" + ALBUM_DESCRIPTION_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_CATEGORY_NAME + "', '" + CATEGORY_NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID_CATEGORY + "', '" + CATEGORY_COVER_IMG_PATH + "', '" + ID_CATEGORY_NAME + "')");

        executeScript("INSERT INTO album (id, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        // when
        AlbumEntity result = albumDao.findById(ID_ALBUM);

        // then
        assertEquals(result, SAVED_ALBUM_ENTITY);
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

        executeScript("INSERT INTO album (id, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        // when
        List<AlbumEntity> result = albumDao.findAll();

        // then
        assertEquals(result, Collections.singletonList(SAVED_ALBUM_ENTITY));
    }

    @Test
    public void testFindByCategory() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_NAME + "', '" + ALBUM_NAME_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_ALBUM_DESCRIPTION + "', '" + ALBUM_DESCRIPTION_TEXT + "')");
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_CATEGORY_NAME + "', '" + CATEGORY_NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID_CATEGORY + "', '" + CATEGORY_COVER_IMG_PATH + "', '" + ID_CATEGORY_NAME + "')");

        executeScript("INSERT INTO album (id, localized_name_id, localized_description_id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_ALBUM_NAME + "', '" + ID_ALBUM_DESCRIPTION + "', '" + ID_CATEGORY + "')");

        // when
        List<AlbumEntity> result = albumDao.findByCategory(1);

        // then
        assertEquals(result, Collections.singletonList(SAVED_ALBUM_ENTITY));
    }
}