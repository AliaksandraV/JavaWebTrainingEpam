package by.training.photographer.dao;

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

public class PhotoCategoryDaoImplTest extends BaseDaoImplTest {
    private PhotoCategoryDao photoCategoryDao;

    private static final int ID = 1;
    private static final int ID_NAME = 1;
    private static final String NAME_TEXT = "albumName";
    private static final LocalizedTextEntity CATEGORY_TEXT = new LocalizedTextEntity(ID_NAME, NAME_TEXT);
    private static final String PATH = "albumName";
    private static final PhotoCategoryEntity NEW_PHOTO_CATEGORY_ENTITY = new PhotoCategoryEntity(CATEGORY_TEXT, PATH, null);
    private static final PhotoCategoryEntity SAVED_PHOTO_CATEGORY_ENTITY = new PhotoCategoryEntity(ID, CATEGORY_TEXT, PATH, null);

    @BeforeClass
    public void initClass() {
        photoCategoryDao = new PhotoCategoryDaoImpl(getConnection());
    }

    @Test
    public void testCreate() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_NAME + "', '" + NAME_TEXT + "')");

        assertTrue(photoCategoryDao.findAll().isEmpty());
        // when
        Integer id = photoCategoryDao.create(NEW_PHOTO_CATEGORY_ENTITY);
        // then
        assertEquals(photoCategoryDao.findById(id), SAVED_PHOTO_CATEGORY_ENTITY);
    }

    @Test
    public void testUpdate() throws PersistenceException {
        //init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_NAME + "', '" + NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID + "', '" + PATH + "', '" + ID_NAME + "')");

        String updatedPath = "new";
        PhotoCategoryEntity updatedUserEntity = new PhotoCategoryEntity(ID, CATEGORY_TEXT, updatedPath, null);

        // when
        photoCategoryDao.update(updatedUserEntity);

        // then
        assertEquals(updatedUserEntity, photoCategoryDao.findById(ID));
    }

    @Test
    public void testDelete() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_NAME + "', '" + NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID + "', '" + PATH + "', '" + ID_NAME + "')");

        assertFalse(photoCategoryDao.findAll().isEmpty());

        // when
        photoCategoryDao.delete(ID);

        // then
        assertTrue(photoCategoryDao.findAll().isEmpty());
    }

    @Test
    public void testFindById() throws PersistenceException {
        // init
        assertNull(photoCategoryDao.findById(ID));
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_NAME + "', '" + NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID + "', '" + PATH + "', '" + ID_NAME + "')");
        // when
        PhotoCategoryEntity result = photoCategoryDao.findById(ID);

        // then
        assertEquals(result, SAVED_PHOTO_CATEGORY_ENTITY);
    }

    @Test
    public void testFindAll() throws PersistenceException {
        // init
        executeScript("INSERT INTO localized_text(id, russian) VALUES ('"
            + ID_NAME + "', '" + NAME_TEXT + "')");

        executeScript("INSERT INTO photo_category (id, cover_image_path, localized_name_id) VALUES ('"
            + ID + "', '" + PATH + "', '" + ID_NAME + "')");
        // when
        List<PhotoCategoryEntity> result = photoCategoryDao.findAll();

        // then
        assertEquals(result, Collections.singletonList(SAVED_PHOTO_CATEGORY_ENTITY));
    }
}