package by.training.photographer.dao;

import by.training.photographer.entity.LikeEntity;
import by.training.photographer.entity.PhotoEntity;
import by.training.photographer.entity.UserEntity;
import by.training.photographer.exception.PersistenceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class LikeDaoImplTest extends BaseDaoImplTest {
    private LikeDao likeDao;

    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String PHONE = "phone2";
    private static final int ROLE = 2;
    private static final int ID_PHOTO = 1;
    private static final String PATH = "path";
    private static final int ID_CATEGORY = 1;
    private static final int ID_ALBUM = 1;
    private static final int ID = 1;
    private static final int ID_USER = 1;
    private static final UserEntity USER = new UserEntity(ID_USER);
    private static final PhotoEntity PHOTO = new PhotoEntity(ID_PHOTO);
    private static final LikeEntity NEW_LIKE_ENTITY = new LikeEntity(USER, PHOTO);
    private static final LikeEntity SAVED_LIKE_ENTITY = new LikeEntity(ID, USER, PHOTO);

    @BeforeClass
    public void initClass() {
        likeDao = new LikeDaoImpl(getConnection());
    }

    @Test
    public void testCreate() throws PersistenceException {
        // init
        executeScript("INSERT INTO photo_category (id) VALUES ('"
            + ID_CATEGORY + "')");

        executeScript("INSERT INTO album (id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_CATEGORY + "')");

        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");

        executeScript("INSERT INTO user (id, email, password, name, phone_number, role) VALUES ('"
            + ID + "', '" + EMAIL + "', '" + PASSWORD + "', '" + NAME + "', '" + PHONE + "', '" + ROLE + "')");

        assertTrue(likeDao.findAll().isEmpty());

        // when
        Integer id = likeDao.create(NEW_LIKE_ENTITY);

        // then
        assertEquals(SAVED_LIKE_ENTITY, likeDao.findById(id));
    }

    @Test
    public void testDelete() throws PersistenceException {
        // init
        executeScript("INSERT INTO photo_category (id) VALUES ('"
            + ID_CATEGORY + "')");
        executeScript("INSERT INTO album (id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_CATEGORY + "')");
        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");
        executeScript("INSERT INTO user (id, email, password, name, phone_number, role) VALUES ('"
            + ID + "', '" + EMAIL + "', '" + PASSWORD + "', '" + NAME + "', '" + PHONE + "', '" + ROLE + "')");

        executeScript("INSERT INTO `like` (user_id, photo_id) VALUES ('"
            + ID_USER + "', '" + ID_PHOTO + "')");

        assertFalse(likeDao.findAll().isEmpty());

        // when
        likeDao.delete(ID);

        // then
        assertTrue(likeDao.findAll().isEmpty());
    }

    @Test
    public void testFindById() throws PersistenceException {
        // init
        assertNull(likeDao.findById(ID));
        executeScript("INSERT INTO photo_category (id) VALUES ('"
            + ID_CATEGORY + "')");
        executeScript("INSERT INTO album (id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_CATEGORY + "')");
        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");
        executeScript("INSERT INTO user (id, email, password, name, phone_number, role) VALUES ('"
            + ID + "', '" + EMAIL + "', '" + PASSWORD + "', '" + NAME + "', '" + PHONE + "', '" + ROLE + "')");

        executeScript("INSERT INTO `like` (user_id, photo_id) VALUES ('"
            + ID_USER + "', '" + ID_PHOTO + "')");
        // when
        LikeEntity result = likeDao.findById(ID);

        // then
        assertEquals(result, SAVED_LIKE_ENTITY);
    }

    @Test
    public void testFindAll() throws PersistenceException {
        // init
        assertNull(likeDao.findById(ID));
        executeScript("INSERT INTO photo_category (id) VALUES ('"
            + ID_CATEGORY + "')");
        executeScript("INSERT INTO album (id, photo_category_id) VALUES ('"
            + ID_ALBUM + "', '" + ID_CATEGORY + "')");
        executeScript("INSERT INTO photo(id, path, album_id) VALUES ('"
            + ID_PHOTO + "', '" + PATH + "', '" + ID_ALBUM + "')");
        executeScript("INSERT INTO user (id, email, password, name, phone_number, role) VALUES ('"
            + ID + "', '" + EMAIL + "', '" + PASSWORD + "', '" + NAME + "', '" + PHONE + "', '" + ROLE + "')");

        executeScript("INSERT INTO `like` (user_id, photo_id) VALUES ('"
            + ID_USER + "', '" + ID_PHOTO + "')");

        // when
        List<LikeEntity> result = likeDao.findAll();

        // then
        assertEquals(result, Collections.singletonList(SAVED_LIKE_ENTITY));
    }
}